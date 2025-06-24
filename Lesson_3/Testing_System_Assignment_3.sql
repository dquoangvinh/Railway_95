-- Question 1: Viết lệnh để lấy ra danh sách nhân viên và thông tin phòng ban của họ 
SELECT a.*, d.department_name
FROM `account` a
LEFT JOIN department d ON a.department_id = d.department_id;

-- Question 2: Viết lệnh để lấy ra thông tin các account được tạo sau ngày 20/12/2010  
SELECT *
FROM `account`
WHERE create_date > '2010-12-20';

-- Question 3: Viết lệnh để lấy ra tất cả các developer  
SELECT a.*
FROM `account` a
JOIN `position` p ON a.position_id = p.position_id
WHERE p.position_name = 'Dev';

-- Question 4: Viết lệnh để lấy ra danh sách các phòng ban có > 3 nhân viên 
SELECT d.department_name, COUNT(a.account_id) AS employee_count
FROM department d
LEFT JOIN `account` a ON d.department_id = a.department_id
GROUP BY d.department_id, d.department_name
HAVING COUNT(a.account_id) > 3;

-- Question 5: Viết lệnh để lấy ra danh sách câu hỏi được sử dụng trong đề thi nhiều nhất 
SELECT q.question_id, q.content, COUNT(*) AS exam_count
FROM question q
JOIN exam_question eq ON q.question_id = eq.question_id
GROUP BY q.question_id, q.content
HAVING COUNT(*) = (
    SELECT COUNT(*)
    FROM question q
    JOIN exam_question eq ON q.question_id = eq.question_id
    GROUP BY q.question_id
    ORDER BY COUNT(eq.exam_id) DESC
    LIMIT 1
);

-- Question 6: Thống kê mỗi category được sử dụng trong bao nhiêu question
SELECT cq.category_name, COUNT(q.question_id) AS question_count
FROM category_question cq
LEFT JOIN question q ON cq.category_id = q.category_id
GROUP BY cq.category_id, cq.category_name;

-- Question 7: Thống kê mỗi question được sử dụng trong bao nhiêu exam
SELECT q.question_id, q.content, COUNT(eq.exam_id) AS exam_count
FROM question q
LEFT JOIN exam_question eq ON q.question_id = eq.question_id
GROUP BY q.question_id, q.content;

-- Question 8: Question có nhiều câu trả lời nhất
SELECT q.question_id, q.content, COUNT(a.answer_id) AS answer_count
FROM question q
LEFT JOIN answer a ON q.question_id = a.question_id
GROUP BY q.question_id, q.content
HAVING COUNT(a.answer_id) = (
    SELECT COUNT(a.answer_id)
    FROM question q
    LEFT JOIN answer a ON q.question_id = a.question_id
    GROUP BY q.question_id
    ORDER BY COUNT(a.answer_id) DESC
    LIMIT 1
);

-- Question 9: Thống kê số lượng account trong mỗi group
SELECT g.group_name, COUNT(ga.account_id) AS account_count
FROM `group` g
LEFT JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id, g.group_name;

-- Question 10: Chức vụ có ít người nhất
SELECT p.position_name, COUNT(a.account_id) AS employee_count
FROM `position` p
LEFT JOIN `account` a ON p.position_id = a.position_id
GROUP BY p.position_id, p.position_name
HAVING COUNT(a.account_id) = (
    SELECT COUNT(a.account_id)
    FROM `position` p
    LEFT JOIN account a ON p.position_id = a.position_id
    GROUP BY p.position_id
    ORDER BY COUNT(a.account_id) ASC
    LIMIT 1
);

-- Question 11: Thống kê mỗi phòng ban có bao nhiêu dev, test, scrum master, PM
SELECT 
    d.department_name,
    SUM(CASE WHEN p.position_name = 'Developer' THEN 1 ELSE 0 END) AS dev_count,
    SUM(CASE WHEN p.position_name = 'Test' THEN 1 ELSE 0 END) AS test_count,
    SUM(CASE WHEN p.position_name = 'Scrum Master' THEN 1 ELSE 0 END) AS scrum_count,
    SUM(CASE WHEN p.position_name = 'PM' THEN 1 ELSE 0 END) AS pm_count
FROM department d
LEFT JOIN `account` a ON d.department_id = a.department_id
LEFT JOIN `position` p ON a.position_id = p.position_id
GROUP BY d.department_id, d.department_name;

-- Question 12: Lấy thông tin chi tiết của câu hỏi bao gồm: thông tin cơ bản của question, 
-- loại câu hỏi, ai là người tạo ra câu hỏi, câu trả lời là gì, … 
SELECT 
    q.question_id,
    q.content AS question_content,
    tq.type_name,
    cq.category_name,
    acc.full_name AS creator_name,
    q.create_date,
    a.content AS answer_content,
    a.is_correct
FROM question q
LEFT JOIN type_question tq ON q.type_id = tq.type_id
LEFT JOIN category_question cq ON q.category_id = cq.category_id
LEFT JOIN `account` acc ON q.creator_id = acc.account_id
LEFT JOIN answer a ON q.question_id = a.question_id;

-- Question 13: Lấy ra số lượng câu hỏi của mỗi loại tự luận hay trắc nghiệm 
SELECT tq.type_name, COUNT(q.question_id) AS question_count
FROM type_question tq
LEFT JOIN question q ON tq.type_id = q.type_id
GROUP BY tq.type_id, tq.type_name;

-- Question 14: Group không có account nào (cách 1)
SELECT g.*
FROM `group` g
LEFT JOIN group_account ga ON g.group_id = ga.group_id
WHERE ga.account_id IS NULL;

-- Question 15: Group không có account nào (cách 2)
SELECT g.*
FROM `group` g
WHERE g.group_id NOT IN (
    SELECT DISTINCT group_id 
    FROM group_account 
    WHERE group_id IS NOT NULL
);

-- Question 16: Question không có answer nào
SELECT q.*
FROM question q
LEFT JOIN answer a ON q.question_id = a.question_id
WHERE a.answer_id IS NULL;

-- Question 17a: Account thuộc nhóm thứ 1
SELECT a.*
FROM `account` a
JOIN group_account ga ON a.account_id = ga.account_id
WHERE ga.group_id = 1;

-- Question 17b: Account thuộc nhóm thứ 2
SELECT a.*
FROM `account` a
JOIN group_account ga ON a.account_id = ga.account_id
WHERE ga.group_id = 2;

-- Question 17c: Ghép 2 kết quả không trùng lặp
SELECT a.*
FROM account a
JOIN group_account ga ON a.account_id = ga.account_id
WHERE ga.group_id = 1

UNION

SELECT a.*
FROM account a
JOIN group_account ga ON a.account_id = ga.account_id
WHERE ga.group_id = 2;

-- Question 18a: a)	Lấy các group có lớn hơn 5 thành viên 
SELECT g.*, COUNT(ga.account_id) AS member_count
FROM `group` g
LEFT JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id, g.group_name, g.creator_id, g.create_date
HAVING COUNT(ga.account_id) > 5;

-- Question 18b: b)	Lấy các group có nhỏ hơn 7 thành viên 
SELECT g.*, COUNT(ga.account_id) AS member_count
FROM `group` g
LEFT JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id, g.group_name, g.creator_id, g.create_date
HAVING COUNT(ga.account_id) < 7;

-- Question 18c: c)	Ghép 2 kết quả từ câu a) và câu b) 
SELECT g.*, COUNT(ga.account_id) AS member_count
FROM `group` g
LEFT JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id, g.group_name, g.creator_id, g.create_date
HAVING COUNT(ga.account_id) > 5

UNION

SELECT g.*, COUNT(ga.account_id) AS member_count
FROM `group` g
LEFT JOIN group_account ga ON g.group_id = ga.group_id
GROUP BY g.group_id, g.group_name, g.creator_id, g.create_date
HAVING COUNT(ga.account_id) < 7;