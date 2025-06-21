-- Tạo database
DROP DATABASE IF EXISTS testing_system;
CREATE DATABASE testing_system;
USE testing_system;

-- Table 1: department
CREATE TABLE department (
	department_id INT AUTO_INCREMENT PRIMARY KEY,
	department_name VARCHAR(50) NOT NULL UNIQUE
);

-- Table 2: position
CREATE TABLE `position` (
	position_id INT AUTO_INCREMENT PRIMARY KEY,
	position_name VARCHAR(50) NOT NULL UNIQUE
);

-- Table 3: account
CREATE TABLE `account` (
	account_id INT AUTO_INCREMENT PRIMARY KEY,
	email VARCHAR(100) NOT NULL UNIQUE,
	username VARCHAR(50) NOT NULL UNIQUE,
	full_name VARCHAR(100) NOT NULL,
	department_id INT,
	position_id INT,
	create_date DATETIME DEFAULT NOW(),
	FOREIGN KEY (department_id) REFERENCES department(department_id),
	FOREIGN KEY (position_id) REFERENCES `position`(position_id)
);

-- Table 4: group
CREATE TABLE `group` (
	group_id INT AUTO_INCREMENT PRIMARY KEY,
	group_name VARCHAR(100) NOT NULL,
	creator_id INT,
	create_date DATETIME DEFAULT NOW(),
	FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
);

-- Table 5: group_account
CREATE TABLE group_account ( 
	group_id INT NOT NULL,
	account_id INT NOT NULL,
	join_date DATETIME DEFAULT NOW(),
	PRIMARY KEY (group_id, account_id),
	FOREIGN KEY (group_id) REFERENCES `group`(group_id),
	FOREIGN KEY (account_id) REFERENCES `account`(account_id)
);

-- Table 6: type_question
CREATE TABLE type_question (
	type_id INT AUTO_INCREMENT PRIMARY KEY,
	type_name ENUM('Essay', 'Multiple-Choice') NOT NULL UNIQUE
);

-- Table 7: category_question
CREATE TABLE category_question ( 
	category_id INT AUTO_INCREMENT PRIMARY KEY,
	category_name VARCHAR(100) NOT NULL UNIQUE
);

-- Table 8: question
CREATE TABLE question (
	question_id INT AUTO_INCREMENT PRIMARY KEY,
	content TEXT NOT NULL,
	category_id INT,
	type_id INT,
	creator_id INT,
	create_date DATETIME DEFAULT NOW(),
	FOREIGN KEY (category_id) REFERENCES category_question(category_id),
	FOREIGN KEY (type_id) REFERENCES type_question(type_id),
	FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
);

-- Table 9: answer 
CREATE TABLE `answer` ( 
	answer_id INT AUTO_INCREMENT PRIMARY KEY,
	content TEXT NOT NULL,
	question_id INT,
	is_correct BIT,
	FOREIGN KEY (question_id) REFERENCES `question`(question_id)
);

-- Table 10: exam
CREATE TABLE exam (  
	exam_id INT AUTO_INCREMENT PRIMARY KEY,
	`code` CHAR(10) NOT NULL UNIQUE,
	title VARCHAR(100) NOT NULL,
	category_id INT,
	duration INT CHECK (duration BETWEEN 60 AND 240),
	creator_id INT,
	create_date DATETIME DEFAULT NOW(),
	FOREIGN KEY (category_id) REFERENCES category_question(category_id),
	FOREIGN KEY (creator_id) REFERENCES `account`(account_id)
);

-- Table 11: exam_question 
CREATE TABLE exam_question (
	exam_id INT NOT NULL,
	question_id INT NOT NULL,
	PRIMARY KEY (exam_id, question_id),
	FOREIGN KEY (exam_id) REFERENCES exam(exam_id),
	FOREIGN KEY (question_id) REFERENCES question(question_id) 
);

-- INSERT department
INSERT INTO department(department_name)
VALUES
(N'Marketing'),
(N'Sale'),
(N'Bảo vệ'),
(N'Nhân sự'),
(N'Kỹ thuật'),
(N'Tài chính'),
(N'Phó giám đốc'),
(N'Giám đốc'),
(N'Thư ký'),
(N'No person'),
(N'Bán hàng');

-- INSERT position
INSERT INTO position (position_name)
VALUES
('Dev'),
('Test'),
('Scrum Master'),
('PM');

-- INSERT account
INSERT INTO `account`(email, username, full_name, department_id, position_id, create_date)
VALUES
('Email1@gmail.com', 'Username1', 'Nguyễn Thị Vân Anh', '5', '1', '2020-03-05'),
('Email2@gmail.com', 'Username2', 'Đặng Đình Nam Anh', '1', '2', '2020-03-05'),
('Email3@gmail.com', 'Username3', 'Nguyễn Kỳ Anh', '2', '2', '2020-03-07'),
('Email4@gmail.com', 'Username4', 'Phan Tiến Anh', '3', '4', '2020-03-08'),
('Email5@gmail.com', 'Username5', 'Phan Tuấn Anh', '4', '4', '2020-03-10'),
('Email6@gmail.com', 'Username6', 'Trần Tuấn Anh', '6', '3', '2020-04-05'),
('Email7@gmail.com', 'Username7', 'Lê Quốc Cường', '2', '2', NULL),
('Email8@gmail.com', 'Username8', 'Trần Đức Cường', '8', '1', '2020-04-07'),
('Email9@gmail.com', 'Username9', 'Bùi Phương Đông', '2', '2', '2020-04-07'),
('Email10@gmail.com', 'Username10', 'Tô Văn Đức', '10', '1', '2020-04-09'),
('Email11@gmail.com', 'Username11', 'Trần Tiến Dũng', '10', '1', DEFAULT),
('Email12@gmail.com', 'Username12', 'Nghiêm Hữu Xuân Giang', '10', '1', DEFAULT);

-- INSERT group
INSERT INTO `group` (group_name, creator_id, create_date)
VALUES
(N'Testing System', 5, '2019-03-05'),
(N'Development', 1, '2020-03-07'),
(N'VTI Sale 01', 2, '2020-03-09'),
(N'VTI Sale 02', 3, '2020-03-10'),
(N'VTI Sale 03', 4, '2020-03-28'),
(N'VTI Creator', 6, '2020-04-06'),
(N'VTI Marketing 01', 7, '2020-04-07'),
(N'Management', 8, '2020-04-08'),
(N'Chat with love', 9, '2020-04-09'),
(N'Vi Ti Ai', 10, '2020-04-10');

-- INSERT group_account
INSERT INTO `group_account` (group_id, account_id, join_date)
VALUES
(1, 1, '2019-03-05'),
(1, 2, '2020-03-07'),
(3, 3, '2020-03-09'),
(3, 4, '2020-03-10'),
(5, 5, '2020-03-28'),
(1, 3, '2020-04-06'),
(1, 7, '2020-04-07'),
(8, 3, '2020-04-08'),
(1, 9, '2020-04-09'),
(10, 10, '2020-04-10');

-- INSERT type_question
INSERT INTO type_question (type_name)
VALUES
('Essay'),
('Multiple-Choice');

-- INSERT category_question
INSERT INTO category_question (category_name)
VALUES
('Java'),
('ASP.NET'),
('ADO.NET'),
('SQL'),
('Postman'),
('Ruby'),
('Python'),
('C++'),
('C Sharp'),
('PHP');

-- INSERT question
INSERT INTO question (content, category_id, type_id, creator_id, create_date)
VALUES
(N'Câu hỏi về Java', 1, '1', '2', '2020-04-05'),
(N'Câu Hỏi về PHP', 10, '2', '2', '2020-04-05'),
(N'Hỏi về C#', 9, '2', '3', '2020-04-06'),
(N'Hỏi về Ruby', 6, '1', '4', '2020-04-06'),
(N'Hỏi về Postman', 5, '1', '5', '2020-04-06'),
(N'Hỏi về ADO.NET', 3, '2', '6', '2020-04-06'),
(N'Hỏi về ASP.NET', 2, '1', '7', '2020-04-06'),
(N'Hỏi về C++', 8, '1', '8', '2020-04-07'),
(N'Hỏi về SQL', 4, '2', '9', '2020-04-07'),
(N'Hỏi về Python', 7, '1', '10', '2020-04-07');

-- INSERT answer
INSERT INTO answer (content, question_id, is_correct)
VALUES
(N'Trả lời 01', 1, 0),
(N'Trả lời 02', 1, 1),
(N'Trả lời 03', 1, 0),
(N'Trả lời 04', 1, 1),
(N'Trả lời 05', 2, 1),
(N'Trả lời 06', 3, 1),
(N'Trả lời 07', 4, 0),
(N'Trả lời 08', 8, 0),
(N'Trả lời 09', 9, 1),
(N'Trả lời 10', 10, 1);

-- INSERT exam
INSERT INTO exam (`code`, title, category_id, duration, creator_id, create_date)
VALUES
('VTIQ001', N'Đề thi C#', 1, 60, '5', '2019-04-05'),
('VTIQ002', N'Đề thi PHP', 10, 60, '2', '2019-04-05'),
('VTIQ003', N'Đề thi C++', 9, 120, '2', '2019-04-07'),
('VTIQ004', N'Đề thi Java', 6, 60, '3', '2020-04-08'),
('VTIQ005', N'Đề thi Ruby', 5, 120, '4', '2020-04-10'),
('VTIQ006', N'Đề thi Postman', 3, 60, '6', '2020-04-05'),
('VTIQ007', N'Đề thi SQL', 2, 60, '7', '2020-04-05'),
('VTIQ008', N'Đề thi Python', 8, 60, '8', '2020-04-07'),
('VTIQ009', N'Đề thi ADO.NET', 4, 90, '9', '2020-04-07'),
('VTIQ010', N'Đề thi ASP.NET', 7, 90, '10', '2020-04-08');

-- INSERT exam_question
INSERT INTO exam_question(exam_id, question_id)
VALUES
(1, 5),
(2, 10),
(3, 4),
(4, 3),
(5, 7),
(6, 10),
(7, 2),
(8, 8),
(9, 1),
(10, 8);

-- Question 2: Lấy ra tất cả các phòng ban 
SELECT * FROM department;

-- Question 3: Lấy ra id của phòng ban "Sale" 
SELECT department_id 
FROM department
WHERE department_name = "Sale";

-- Question 4 Lấy ra thông tin account có full name dài nhất
SELECT * 
FROM `account`
WHERE CHAR_LENGTH(full_name) = (SELECT MAX(CHAR_LENGTH(full_name)) FROM `account`);

-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3 
SELECT * FROM `account`
WHERE department_id = 3
AND CHAR_LENGTH(full_name) = (SELECT MAX(CHAR_LENGTH(full_name)) 
                            FROM account 
                            WHERE department_id = 3);
                            
-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019 
SELECT group_name
FROM `group`
WHERE create_date < '2019-12-20';

-- Question 7: Lấy ra ID của question có >= 4 câu trả lời 
SELECT question_id
FROM answer
GROUP BY question_id
HAVING COUNT(answer_id) >= 4;

-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019 
SELECT `code`
FROM exam
WHERE duration >= 60 AND create_date > '2019-12-20';

-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT * FROM `group`
ORDER BY create_date DESC
LIMIT 5;                   

-- Question 10: Đếm số nhân viên thuộc department có id = 2 
SELECT COUNT(*) AS so_nhan_vien
FROM `account`         
WHERE department_id = 2;

-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT * FROM `account`
WHERE full_name LIKE 'D%o';

-- Question 12: Xóa tất cả các exam được tạo trước ngày 20/12/2019
DELETE FROM Exam
WHERE create_date < '2019-12-20';

-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi" 
DELETE FROM question
WHERE content LIKE 'câu hỏi%';

-- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành "loc.nguyenba@vti.com.vn"
UPDATE `account`
SET full_name = 'Nguyễn Bá Lộc',
	email = 'loc.nguyenba@vti.com.vn'
WHERE account_id = 5;

-- Question 15: update account có id = 5 sẽ thuộc group có id = 4 
UPDATE group_account
SET account_id = 5
WHERE group_id = 4;