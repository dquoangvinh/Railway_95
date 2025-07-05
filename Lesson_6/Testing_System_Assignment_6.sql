-- Question 1: Trigger không cho phép nhập Group có ngày tạo trước 1 năm
DROP TRIGGER IF EXISTS trg_check_group_create_date;
DELIMITER $$
CREATE TRIGGER trg_check_group_create_date
BEFORE INSERT ON `group`
FOR EACH ROW
BEGIN
    DECLARE v_min_date DATETIME;
    SET v_min_date = DATE_SUB(NOW(), INTERVAL 1 YEAR);
    
    IF (NEW.create_date <= v_min_date) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot create group with date older than 1 year';
    END IF;
END$$
DELIMITER ;

INSERT INTO `group` (group_name, creator_id, create_date) 
VALUES ('Old Group', 1, '2022-01-01');

-- Question 2: Trigger không cho thêm user vào department "Sale"
DROP TRIGGER IF EXISTS trg_not_add_user_to_sale;
DELIMITER $$
CREATE TRIGGER trg_not_add_user_to_sale
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN
    DECLARE v_dept_id INT;
    
    SELECT department_id INTO v_dept_id 
    FROM department 
    WHERE department_name = 'Sale';
    
    IF (NEW.department_id = v_dept_id) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Department "Sale" cannot add more user';
    END IF;
END$$
DELIMITER ;

INSERT INTO account (email, username, full_name, department_id, position_id) 
VALUES ('newsale@gmail.com', 'newsale', 'New Sale User', 2, 1);

-- Question 3: Cấu hình 1 group có nhiều nhất 5 user
DROP TRIGGER IF EXISTS trg_limit_group_members;
DELIMITER $$
CREATE TRIGGER trg_limit_group_members
BEFORE INSERT ON group_account
FOR EACH ROW
BEGIN
    DECLARE v_count_members INT;
    
    SELECT COUNT(*) INTO v_count_members
    FROM group_account
    WHERE group_id = NEW.group_id;
    
    IF (v_count_members >= 5) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Group cannot have more than 5 members';
    END IF;
END$$
DELIMITER ;

INSERT INTO group_account (group_id, account_id) VALUES (1, 13);

-- Question 4: Cấu hình 1 bài thi có nhiều nhất 10 Question
DROP TRIGGER IF EXISTS trg_limit_exam_questions;
DELIMITER $$
CREATE TRIGGER trg_limit_exam_questions
BEFORE INSERT ON exam_question
FOR EACH ROW
BEGIN
    DECLARE v_count_questions INT;
    
    SELECT COUNT(*) INTO v_count_questions
    FROM exam_question
    WHERE exam_id = NEW.exam_id;
    
    IF (v_count_questions >= 10) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Exam cannot have more than 10 questions';
    END IF;
END$$
DELIMITER ;

INSERT INTO exam_question (exam_id, question_id) VALUES (1, 1);

-- Question 5: Trigger không cho xóa account admin
DROP TRIGGER IF EXISTS trg_protect_admin_account;
DELIMITER $$
CREATE TRIGGER trg_protect_admin_account
BEFORE DELETE ON `account`
FOR EACH ROW
BEGIN
    IF (OLD.email = 'admin@gmail.com') THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot delete admin account';
    END IF;
END$$
DELIMITER ;

DELETE FROM `account` WHERE email = 'admin@gmail.com';

-- Question 6: Trigger tự động assign "waiting Department" khi không điền departmentID
DROP TRIGGER IF EXISTS trg_set_waiting_department;
DELIMITER $$
CREATE TRIGGER trg_set_waiting_department
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN
    DECLARE v_waiting_dept_id INT;
    
    IF (NEW.department_id IS NULL) THEN
        SELECT department_id INTO v_waiting_dept_id
        FROM department
        WHERE department_name = 'waiting Department';
        
        SET NEW.department_id = v_waiting_dept_id;
    END IF;
END$$
DELIMITER ;

INSERT INTO account (email, username, full_name, position_id) 
VALUES ('newuser@gmail.com', 'newuser', 'New User', 1);

-- Question 7: Cấu hình 1 question tối đa 4 answers, tối đa 2 đáp án đúng
DROP TRIGGER IF EXISTS trg_limit_answers;
DELIMITER $$
CREATE TRIGGER trg_limit_answers
BEFORE INSERT ON `answer`
FOR EACH ROW
BEGIN
    DECLARE v_count_answers INT;
    DECLARE v_count_correct INT;
    
    SELECT COUNT(*) INTO v_count_answers
    FROM answer
    WHERE question_id = NEW.question_id;
    
    SELECT COUNT(*) INTO v_count_correct
    FROM answer
    WHERE question_id = NEW.question_id AND is_correct = 1;
    
    IF (v_count_answers >= 4) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Question cannot have more than 4 answers';
    END IF;
    
    IF (NEW.is_correct = 1 AND v_count_correct >= 2) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Question cannot have more than 2 correct answers';
    END IF;
END$$
DELIMITER ;

INSERT INTO answer (content, question_id, is_correct) VALUES ('Answer 1', 1, 1);

-- Question 8: Trigger sửa gender từ "nam/nữ/chưa xác định" thành "M/F/U"
-- (Cần thêm column gender vào table account trước)
ALTER TABLE account MODIFY COLUMN gender VARCHAR(20);

DROP TRIGGER IF EXISTS trg_convert_gender;
DELIMITER $$
CREATE TRIGGER trg_convert_gender
BEFORE INSERT ON `account`
FOR EACH ROW
BEGIN
    IF NEW.gender = 'Nam' THEN
        SET NEW.gender = 'M';
    ELSEIF NEW.gender = 'Nữ' THEN
        SET NEW.gender = 'F';
    ELSEIF NEW.gender = 'Chưa xác định' THEN
        SET NEW.gender = 'U';
    END IF;
END$$
DELIMITER ;

INSERT INTO account (email, username, full_name, department_id, position_id, gender) 
VALUES ('male@gmail.com', 'male', 'Male User', 1, 1, 'Nam');

-- Question 9: Trigger không cho xóa exam mới tạo được 2 ngày
DROP TRIGGER IF EXISTS trg_protect_new_exam;
DELIMITER $$
CREATE TRIGGER trg_protect_new_exam
BEFORE DELETE ON `exam`
FOR EACH ROW
BEGIN
    DECLARE v_min_date DATETIME;
    SET v_min_date = DATE_SUB(NOW(), INTERVAL 2 DAY);
    
    IF (OLD.create_date > v_min_date) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot delete exam created within 2 days';
    END IF;
END$$
DELIMITER ;

INSERT INTO exam (`code`, title, category_id, duration, creator_id, create_date) 
VALUES ('EXAM1', 'New Exam', 1, 60, 1, NOW());

DELETE FROM exam WHERE `code` = 'EXAM1';

-- Question 10: Trigger chỉ cho update/delete question khi chưa nằm trong exam
DROP TRIGGER IF EXISTS trg_check_question_in_exam_update;
DELIMITER $$
CREATE TRIGGER trg_check_question_in_exam_update
BEFORE UPDATE ON `question`
FOR EACH ROW
BEGIN
    DECLARE v_count_in_exam INT;
    
    SELECT COUNT(*) INTO v_count_in_exam
    FROM exam_question
    WHERE question_id = NEW.question_id;
    
    IF (v_count_in_exam > 0) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot update question already in exam';
    END IF;
END$$
DELIMITER ;

DROP TRIGGER IF EXISTS trg_check_question_in_exam_delete;
DELIMITER $$
CREATE TRIGGER trg_check_question_in_exam_delete
BEFORE DELETE ON `question`
FOR EACH ROW
BEGIN
    DECLARE v_count_in_exam INT;
    
    SELECT COUNT(*) INTO v_count_in_exam
    FROM exam_question
    WHERE question_id = OLD.question_id;
    
    IF (v_count_in_exam > 0) THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cannot delete question already in exam';
    END IF;
END$$
DELIMITER ;
UPDATE question SET content = 'Updated Content' WHERE question_id = 1;

DELETE FROM question WHERE question_id = 1;

-- Question 12: Lấy thông tin exam với duration được phân loại
SELECT 
    exam_id,
    code,
    title,
    CASE
        WHEN duration <= 30 THEN 'Short time'
        WHEN duration <= 60 THEN 'Medium time'
        ELSE 'Long time'
    END AS duration_type,
    duration,
    create_date
FROM exam;

-- Question 13: Thống kê số account trong mỗi group với phân loại
SELECT 
    g.group_id,
    g.group_name,
    COUNT(ga.account_id) AS user_count,
    CASE
        WHEN COUNT(ga.account_id) <= 5 THEN 'few'
        WHEN COUNT(ga.account_id) <= 20 THEN 'normal'
        ELSE 'higher'
    END AS the_number_user_amount
FROM `group` g
LEFT JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id, g.group_name;

-- Question 14: Thống kê số user trong mỗi phòng ban
SELECT 
    d.department_id,
    d.department_name,
    CASE
        WHEN COUNT(a.account_id) = 0 THEN 'Không có User'
        ELSE CAST(COUNT(a.account_id) AS CHAR)
    END AS user_count
FROM department d
LEFT JOIN account a ON d.department_id = a.department_id
GROUP BY d.department_id, d.department_name;