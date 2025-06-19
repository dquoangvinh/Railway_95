-- Tạo database
DROP DATABASE IF EXISTS TestingSystem;
CREATE DATABASE TestingSystem;
USE TestingSystem;

-- Table 1: Department
CREATE TABLE `Department` (
	DepartmentID INT AUTO_INCREMENT PRIMARY KEY,
	DepartmentName VARCHAR(50) NOT NULL UNIQUE
);

-- Table 2: Position
CREATE TABLE `Position` (
	PositionID INT AUTO_INCREMENT PRIMARY KEY,
	PositionName VARCHAR(50) NOT NULL UNIQUE
);

-- Table 3: Account
CREATE TABLE `Account` (
	AccountID INT AUTO_INCREMENT PRIMARY KEY,
	Email VARCHAR(100) NOT NULL UNIQUE,
	Username VARCHAR(50) NOT NULL UNIQUE,
	FullName VARCHAR(100) NOT NULL,
	DepartmentID INT,
	PositionID INT,
	CreateDate DATETIME DEFAULT NOW(),
	FOREIGN KEY (DepartmentID) REFERENCES `Department`(DepartmentID),
	FOREIGN KEY (PositionID) REFERENCES `Position`(PositionID)
);

-- Table 4: Group
CREATE TABLE `Group` (
	GroupID INT AUTO_INCREMENT PRIMARY KEY,
	GroupName VARCHAR(100) NOT NULL,
	CreatorID INT,
	CreateDate DATETIME DEFAULT NOW(),
	FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

-- Table 5: GroupAccount
CREATE TABLE `GroupAccount` ( 
	GroupID INT NOT NULL,
	AccountID INT NOT NULL,
	JoinDate DATETIME DEFAULT NOW(),
	PRIMARY KEY (GroupID, AccountID),
	FOREIGN KEY (GroupID) REFERENCES `Group`(GroupID),
	FOREIGN KEY (AccountID) REFERENCES `Account`(AccountID)
);

-- Table 6: TypeQuestion
CREATE TABLE `TypeQuestion` (
	TypeID INT AUTO_INCREMENT PRIMARY KEY,
	TypeName ENUM('Essay', 'Multiple-Choice') NOT NULL UNIQUE
);

-- Table 7: CategoryQuestion
CREATE TABLE `CategoryQuestion` ( 
	CategoryID INT AUTO_INCREMENT PRIMARY KEY,
	CategoryName VARCHAR(100) NOT NULL UNIQUE
);

-- Table 8: Question
CREATE TABLE `Question` (
	QuestionID INT AUTO_INCREMENT PRIMARY KEY,
	Content TEXT NOT NULL,
	CategoryID INT,
	TypeID INT,
	CreatorID INT,
	CreateDate DATETIME DEFAULT NOW(),
	FOREIGN KEY (CategoryID) REFERENCES `CategoryQuestion`(CategoryID),
	FOREIGN KEY (TypeID) REFERENCES `TypeQuestion`(TypeID),
	FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

-- Table 9: Answer 
CREATE TABLE `Answer` ( 
	AnswerID INT AUTO_INCREMENT PRIMARY KEY,
	Content TEXT NOT NULL,
	QuestionID INT,
	isCorrect BIT,
	FOREIGN KEY (QuestionID) REFERENCES `Question`(QuestionID)
);

-- Table 10: Exam
CREATE TABLE `Exam` (  
	ExamID INT  AUTO_INCREMENT PRIMARY KEY,
	`Code` CHAR(10) NOT NULL UNIQUE,
	Title VARCHAR(100) NOT NULL,
	CategoryID INT,
	Duration INT CHECK (Duration BETWEEN 60 AND 240),
	CreatorID INT,
	CreateDate DATETIME DEFAULT NOW(),
	FOREIGN KEY (CategoryID) REFERENCES `CategoryQuestion`(CategoryID),
	FOREIGN KEY (CreatorID) REFERENCES `Account`(AccountID)
);

-- Table 11: ExamQuestion 
CREATE TABLE `ExamQuestion` (
	ExamID INT NOT NULL,
	QuestionID INT NOT NULL,
	PRIMARY KEY (ExamID, QuestionID),
	FOREIGN KEY (ExamID) REFERENCES `Exam`(ExamID),
	FOREIGN KEY (QuestionID) REFERENCES `Question`(QuestionID) 
);

 