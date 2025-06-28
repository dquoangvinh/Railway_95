-- Question 1: Tạo view chứa danh sách nhân viên thuộc phòng ban Sale
CREATE OR REPLACE VIEW v_sale_employees AS 
SELECT a.*
FROM `account` a 
JOIN department d ON a.department_id = d.department_id 
WHERE d.department_name = 'Sale';

SELECT * FROM v_sale_employees;
-- Question 2: Tạo view chứa thông tin các account tham gia vào nhiều group nhất
CREATE OR REPLACE VIEW v_most_active_accounts AS 
WITH tmp_acc AS (
    SELECT 
        a.*, 
        COUNT(ga.group_id) as join_count
    FROM `account` a
    JOIN group_account ga ON a.account_id = ga.account_id
    GROUP BY a.account_id
)
SELECT * 
FROM tmp_acc 
WHERE join_count = (SELECT MAX(join_count) FROM tmp_acc);

SELECT * FROM v_most_active_accounts;

-- Question 3: Tạo view chứa câu hỏi có content quá dài (>300 ký tự) và xóa đi
CREATE OR REPLACE VIEW v_long_content_questions AS 
SELECT * 
FROM question 
WHERE LENGTH(content) > 300;

DELETE FROM question WHERE LENGTH(content) > 300;

-- Question 4: Tạo view chứa danh sách các phòng ban có nhiều nhân viên nhất
CREATE OR REPLACE VIEW v_largest_departments AS 
WITH dept_count AS (
    SELECT d.*, COUNT(a.account_id) as employee_count
    FROM department d
    LEFT JOIN `account` a ON d.department_id = a.department_id
    GROUP BY d.department_id
)
SELECT * 
FROM dept_count 
WHERE employee_count = (SELECT MAX(employee_count) FROM dept_count);

SELECT * FROM v_largest_departments;

-- Question 5: Tạo view chứa tất cả các câu hỏi do user họ Nguyen tạo
CREATE OR REPLACE VIEW v_nguyen_questions AS 
SELECT q.*
FROM question q
JOIN `account` a ON q.creator_id = a.account_id
WHERE a.full_name LIKE '%Nguyen%';

SELECT * FROM v_nguyen_questions;
