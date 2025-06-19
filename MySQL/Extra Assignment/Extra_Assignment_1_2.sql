-- Tạo database
CREATE DATABASE FresherManagement;
USE FresherManagement;

-- Tạo table Trainee
CREATE TABLE Trainee (
    TraineeID INT AUTO_INCREMENT PRIMARY KEY,
    Full_Name VARCHAR(100) NOT NULL,
    Birth_Date DATE,
    Gender ENUM('male', 'female', 'unknown') DEFAULT 'unknown',
    ET_IQ TINYINT UNSIGNED,
    ET_Gmath TINYINT UNSIGNED,
    ET_English TINYINT UNSIGNED,
    Training_Class VARCHAR(50),
    Evaluation_Notes TEXT
);

ALTER TABLE Trainee 
ADD COLUMN VTI_Account VARCHAR(50) NOT NULL UNIQUE; 