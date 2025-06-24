-- Tạo database
DROP DATABASE IF EXISTS fresher_management;
CREATE DATABASE fresher_management;
USE fresher_management;

-- Exercise 1:Design a table  
-- Question 1: Tạo table với các ràng buộc và kiểu dữ liệu 
CREATE TABLE trainee (
    trainee_id INT AUTO_INCREMENT PRIMARY KEY,
    full_name NVARCHAR(50) NOT NULL,
    birth_date DATE NOT NULL,
    gender ENUM('male', 'female', 'unknown') NOT NULL,
    et_iq INT CHECK (et_iq >= 0 AND et_iq <= 20),
    et_gmath INT CHECK (et_gmath >= 0 AND et_gmath <= 20),
    et_english INT CHECK (et_english >= 0 AND et_english <= 50),
    training_class VARCHAR(10) NOT NULL,
    evaluation_notes TEXT
);

-- Question 2: thêm trường VTI_Account với điều kiện not null & unique 
ALTER TABLE trainee 
ADD COLUMN vti_account VARCHAR(50) NOT NULL UNIQUE;

-- Exercise 2: Data Types 
CREATE TABLE exercise2 (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100),
    `code` CHAR(5),
    modified_date DATETIME
);

-- Exercise 3: Data Types (2) 
CREATE TABLE exercise3 (
    id INT AUTO_INCREMENT PRIMARY KEY,
    `name` VARCHAR(100),
    birth_date DATE,
    gender TINYINT,
    is_deleted_flag BIT
);