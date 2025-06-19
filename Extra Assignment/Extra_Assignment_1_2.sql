-- Tạo database
CREATE DATABASE FresherManagement;
USE FresherManagement;

-- Exercise 1:Design a table  
-- Question 1: Tạo table với các ràng buộc và kiểu dữ liệu 
CREATE TABLE Trainee (
    TraineeID INT AUTO_INCREMENT PRIMARY KEY,
    Full_Name VARCHAR(100) NOT NULL,
    Birth_Date DATE,
    Gender ENUM('male', 'female', 'unknown') DEFAULT 'unknown',
    ET_IQ TINYINT CHECK (ET_IQ >= 0 AND ET_IQ <= 20),
    ET_Gmath TINYINT CHECK (ET_Gmath >= 0 AND ET_Gmath <= 20),
    ET_English TINYINT CHECK (ET_English >= 0 AND ET_English <= 50),
    Training_Class VARCHAR(50),
    Evaluation_Notes TEXT
);

-- Question 2: thêm trường VTI_Account với điều kiện not null & unique 
ALTER TABLE Trainee 
ADD COLUMN VTI_Account VARCHAR(50) NOT NULL UNIQUE;

-- Exercise 2: Data Types 
CREATE TABLE Exercise2 (
    ID INT AUTO_INCREMENT PRIMARY KEY, 
    `Name` VARCHAR(100),                 
    `Code` CHAR(5),                      
    ModifiedDate DATETIME             
);  

-- Exercise 3: Data Types (2) 
CREATE TABLE Exercise3 (
    ID INT AUTO_INCREMENT PRIMARY KEY,  
    `Name` VARCHAR(100),                 
    BirthDate DATE,                   
    Gender TINYINT,                   
    IsDeletedFlag BIT                 
);