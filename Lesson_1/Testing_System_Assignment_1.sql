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