-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DELIMITER $$
CREATE PROCEDURE sp_get_accounts_by_department(IN dept_name VARCHAR(50))
BEGIN
    SELECT a.account_id, a.email, a.username, a.full_name
    FROM `account` a
    JOIN department d ON a.department_id = d.department_id
    WHERE d.department_name = dept_name;
END$$
DELIMITER ;

CALL sp_get_accounts_by_department('Marketing');

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DELIMITER $$
CREATE PROCEDURE sp_count_accounts_in_groups()
BEGIN
    SELECT g.group_id, g.group_name, COUNT(ga.account_id) AS account_count
    FROM `group` g
    LEFT JOIN group_account ga ON g.group_id = ga.group_id
    GROUP BY g.group_id, g.group_name;
END$$
DELIMITER ;

CALL sp_count_accounts_in_groups();

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
DELIMITER $$
CREATE PROCEDURE sp_count_questions_by_type_current_month()
BEGIN
    SELECT tq.type_id, tq.type_name, COUNT(q.question_id) AS question_count
    FROM type_question tq
    LEFT JOIN question q ON tq.type_id = q.type_id 
        AND MONTH(q.create_date) = MONTH(NOW()) 
        AND YEAR(q.create_date) = YEAR(NOW())
    GROUP BY tq.type_id, tq.type_name;
END$$
DELIMITER ;

CALL sp_count_questions_by_type_current_month();

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP PROCEDURE IF EXISTS sp_get_max_question_type_id;
DELIMITER $$
CREATE PROCEDURE sp_get_max_question_type_id(OUT v_type_id INT)
BEGIN
    WITH cte_count_type_id AS (
        SELECT COUNT(q.type_id) AS question_count 
        FROM question q
        GROUP BY q.type_id
    )
    SELECT q.type_id INTO v_type_id 
	FROM question q
    GROUP BY q.type_id
    HAVING COUNT(q.type_id) = (SELECT MAX(question_count) FROM cte_count_type_id);
END$$
DELIMITER ;

SET @type_id = 0;
CALL sp_get_max_question_type_id(@type_id);
SELECT @type_id;

-- Question 5: Sử dụng store ở question 4 để tìm ra tên của type question
SELECT type_name FROM type_question WHERE type_id = @type_id;

-- Question 6: Viết store cho phép người dùng nhập vào chuỗi và trả về group hoặc user chứa chuỗi đó
DROP PROCEDURE IF EXISTS sp_search_group_or_account;
DELIMITER $$
CREATE PROCEDURE sp_search_group_or_account(IN search_string VARCHAR(50))
BEGIN
    SELECT g.group_name AS result, 'Group' AS type
    FROM `group` g 
    WHERE g.group_name LIKE CONCAT('%', search_string, '%')
    
    UNION
    
    SELECT a.username AS result, 'Account' AS type
    FROM `account` a 
    WHERE a.username LIKE CONCAT('%', search_string, '%');
END$$
DELIMITER ;

CALL sp_search_group_or_account('test');

-- Question 7: Viết store tự động tạo account từ fullName và email
DROP PROCEDURE IF EXISTS sp_insert_account;
DELIMITER $$
CREATE PROCEDURE sp_insert_account(IN var_email VARCHAR(100), IN var_full_name VARCHAR(100))
BEGIN
    DECLARE v_username VARCHAR(50) DEFAULT SUBSTRING_INDEX(var_email, '@', 1);
    DECLARE v_department_id INT; 
    DECLARE v_position_id INT; 
    DECLARE v_create_date DATETIME DEFAULT NOW();
        
    INSERT INTO `account` (email, username, full_name, department_id, position_id, create_date)
    VALUES (var_email, v_username, var_full_name, v_department_id, v_position_id, v_create_date);
    
    SELECT 'Account created successfully' AS message;
END$$
DELIMITER ;

CALL sp_insert_account('test@example.com', 'Test User');

-- Question 8: Viết 1 store cho phép người dùng nhập vào Essay hoặc Multiple-Choice 
-- để thống kê câu hỏi essay hoặc multiple-choice nào có content dài nhất 
DROP PROCEDURE IF EXISTS sp_get_longest_question_by_type;
DELIMITER $$
CREATE PROCEDURE sp_get_longest_question_by_type(IN question_type VARCHAR(50))
BEGIN
    DECLARE v_type_id INT;
    
    SELECT type_id INTO v_type_id 
    FROM type_question 
    WHERE type_name = question_type;
    
    SELECT * FROM question q
    WHERE q.type_id = v_type_id
    AND CHAR_LENGTH(q.content) = (
        SELECT MAX(CHAR_LENGTH(content)) 
        FROM question 
        WHERE type_id = v_type_id
    );
END$$
DELIMITER ;

CALL sp_get_longest_question_by_type('Essay');

-- Question 9: Viết store xóa exam dựa vào ID
DROP PROCEDURE IF EXISTS sp_delete_exam_by_id;
DELIMITER $$
CREATE PROCEDURE sp_delete_exam_by_id(IN in_exam_id INT)
BEGIN
    DELETE FROM exam_question WHERE exam_id = in_exam_id;
    DELETE FROM exam WHERE exam_id = in_exam_id;
END$$
DELIMITER ;

CALL sp_delete_exam_by_id(7);

-- Question 10: Tìm ra các exam được tạo từ 3 năm trước và xóa các exam đó đi (sử dụng store ở câu 9 để xóa) 
          -- Sau đó in số lượng record đã remove từ các table liên quan trong khi removing 
DROP PROCEDURE IF EXISTS sp_delete_old_exams;
DELIMITER $$
CREATE PROCEDURE sp_delete_old_exams()
BEGIN
    DECLARE v_exam_id INT;
    DECLARE v_deleted_count INT DEFAULT 0;
    DECLARE done INT DEFAULT FALSE;
    
    DECLARE exam_cursor CURSOR FOR 
        SELECT exam_id FROM exam 
        WHERE create_date < DATE_SUB(NOW(), INTERVAL 3 YEAR);
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = TRUE;
    
    OPEN exam_cursor;
    exam_loop: LOOP
        FETCH exam_cursor INTO v_exam_id;
        IF done THEN LEAVE exam_loop; END IF;
        
        CALL sp_delete_exam_by_id(v_exam_id);
        SET v_deleted_count = v_deleted_count + 1;
    END LOOP;
    CLOSE exam_cursor;
    
    SELECT CONCAT('Deleted ', v_deleted_count, ' exams') AS result;
END$$
DELIMITER ;

CALL sp_delete_old_exams();

-- Question 11: Viết store xóa phòng ban và chuyển account về phòng chờ
DROP PROCEDURE IF EXISTS sp_delete_department_by_name;
DELIMITER $$
CREATE PROCEDURE sp_delete_department_by_name(IN department_name VARCHAR(50))
BEGIN
    DECLARE v_DepartmentID INT;
    DECLARE v_WaitingRoomID INT;
    
    SELECT department_id INTO v_DepartmentID FROM department WHERE department_name = department_name;
    SELECT department_id INTO v_WaitingRoomID FROM department WHERE department_name = 'Waiting Room';
    
    IF v_DepartmentID IS NOT NULL AND v_WaitingRoomID IS NOT NULL THEN
        UPDATE account SET department_id = v_WaitingRoomID WHERE department_id = v_DepartmentID;
        DELETE FROM department WHERE department_name = department_name;
    END IF;
END$$
DELIMITER ;

CALL sp_delete_department_by_name('Marketing');

-- Question 12: Viết store in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong năm nay
DELIMITER $$
CREATE PROCEDURE sp_count_questions_by_month_this_year()
BEGIN
    WITH all_months AS (
        SELECT 1 AS month_number UNION SELECT 2 UNION SELECT 3 UNION SELECT 4 
        UNION SELECT 5 UNION SELECT 6 UNION SELECT 7 UNION SELECT 8 
        UNION SELECT 9 UNION SELECT 10 UNION SELECT 11 UNION SELECT 12
    )
    SELECT 
        am.month_number,
        MONTHNAME(DATE(CONCAT(YEAR(NOW()), '-', am.month_number, '-01'))) AS month_name,
        COALESCE(COUNT(q.question_id), 0) AS question_count
    FROM all_months am
    LEFT JOIN question q ON MONTH(q.create_date) = am.month_number 
        AND YEAR(q.create_date) = YEAR(NOW())
    GROUP BY am.month_number
    ORDER BY am.month_number;
END$$
DELIMITER ;

 CALL sp_count_questions_by_month_this_year();

-- Question 13: Viết store để in ra mỗi tháng có bao nhiêu câu hỏi được tạo trong 6 tháng gần đây nhất
DELIMITER $$
CREATE PROCEDURE sp_count_questions_last_6_months()
BEGIN
    WITH months AS (
        SELECT DATE_SUB(CURDATE(), INTERVAL 5 MONTH) AS month_date
        UNION SELECT DATE_SUB(CURDATE(), INTERVAL 4 MONTH)
        UNION SELECT DATE_SUB(CURDATE(), INTERVAL 3 MONTH)
        UNION SELECT DATE_SUB(CURDATE(), INTERVAL 2 MONTH)
        UNION SELECT DATE_SUB(CURDATE(), INTERVAL 1 MONTH)
        UNION SELECT CURDATE()
    )
    SELECT 
        YEAR(m.month_date) AS year_number,
        MONTH(m.month_date) AS month_number,
        MONTHNAME(m.month_date) AS month_name,
        COALESCE(COUNT(q.question_id), 0) AS question_count,
        CASE 
            WHEN COUNT(q.question_id) = 0 THEN 'Không có câu hỏi nào trong tháng'
            ELSE CONCAT(COUNT(q.question_id), ' câu hỏi')
        END AS result_message
    FROM months m
    LEFT JOIN question q ON YEAR(q.create_date) = YEAR(m.month_date) 
        AND MONTH(q.create_date) = MONTH(m.month_date)
    GROUP BY YEAR(m.month_date), MONTH(m.month_date), MONTHNAME(m.month_date)
    ORDER BY YEAR(m.month_date), MONTH(m.month_date);
END$$
DELIMITER ;

CALL sp_count_questions_last_6_months();