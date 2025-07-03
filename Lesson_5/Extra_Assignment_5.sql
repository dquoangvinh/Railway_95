-- Extra_Assignment_5.sql

-- Tạo database
DROP DATABASE IF EXISTS project_management;
CREATE DATABASE project_management;
USE project_management;

-- a) Tạo tables với constraints và thêm data

-- Table: Employee
CREATE TABLE employee (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_last_name VARCHAR(50) NOT NULL,
    employee_first_name VARCHAR(50) NOT NULL,
    employee_hire_date DATE NOT NULL,
    employee_status ENUM('Active', 'Inactive') DEFAULT 'Active',
    supervisor_id INT,
    social_security_number VARCHAR(11) UNIQUE,
    FOREIGN KEY (supervisor_id) REFERENCES employee(employee_id)
);

-- Table: Projects  
CREATE TABLE projects (
    project_id INT AUTO_INCREMENT PRIMARY KEY,
    manager_id INT NOT NULL,
    project_name VARCHAR(100) NOT NULL,
    project_start_date DATE NOT NULL,
    project_description TEXT,
    project_detail TEXT,
    project_completed_on DATE,
    FOREIGN KEY (manager_id) REFERENCES employee(employee_id)
);

-- Table: Project_Modules
CREATE TABLE project_modules (
    module_id INT AUTO_INCREMENT PRIMARY KEY,
    project_id INT NOT NULL,
    employee_id INT NOT NULL,
    project_modules_date DATE NOT NULL,
    project_modules_completed_on DATE,
    project_modules_description TEXT,
    FOREIGN KEY (project_id) REFERENCES projects(project_id),
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id)
);

-- Table: Work_Done
CREATE TABLE work_done (
    work_done_id INT AUTO_INCREMENT PRIMARY KEY,
    employee_id INT NOT NULL,
    module_id INT NOT NULL,
    work_done_date DATE,
    work_done_description TEXT,
    work_done_status ENUM('Pending', 'Completed') DEFAULT 'Pending',
    FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
    FOREIGN KEY (module_id) REFERENCES project_modules(module_id)
);

-- Thêm sample data
INSERT INTO employee (employee_last_name, employee_first_name, employee_hire_date, supervisor_id, social_security_number) VALUES
('Nguyen', 'Van A', '2020-01-15', NULL, '123-45-6789'),
('Tran', 'Thi B', '2021-03-20', 1, '987-65-4321'),
('Le', 'Van C', '2022-05-10', 1, '456-78-9012'),
('Pham', 'Thi D', '2023-02-28', 2, '321-65-9874');

INSERT INTO projects (manager_id, project_name, project_start_date, project_description, project_completed_on) VALUES
(1, 'Web Application', '2024-01-01', 'E-commerce website', '2024-03-15'),
(1, 'Mobile App', '2024-02-01', 'iOS/Android app', NULL),
(2, 'Data Migration', '2023-12-01', 'Legacy system migration', '2024-01-20');

INSERT INTO project_modules (project_id, employee_id, project_modules_date, project_modules_completed_on, project_modules_description) VALUES
(1, 2, '2024-02-01', '2024-02-05', 'Frontend Development'),
(1, 3, '2024-02-15', '2024-02-20', 'Backend API'),
(2, 2, '2024-03-01', NULL, 'UI Design'),
(2, 3, '2024-03-15', NULL, 'Database Design'),
(3, 4, '2024-01-10', '2024-01-15', 'Data Analysis');

INSERT INTO work_done (employee_id, module_id, work_done_date, work_done_description, work_done_status) VALUES
(2, 1, '2024-02-05', 'Complete login page', 'Completed'),
(3, 2, '2024-02-20', 'User authentication API', 'Completed'),
(2, 3, NULL, 'Design homepage', 'Pending'),
(3, 4, NULL, 'Create user tables', 'Pending'),
(4, 5, '2024-01-15', 'Extract customer data', 'Completed');

-- b) Stored procedure remove projects hoàn thành sau 3 tháng
DELIMITER $$
CREATE PROCEDURE sp_remove_completed_projects()
BEGIN
    -- Xóa trực tiếp, dùng ROW_COUNT() để đếm
    DELETE wd FROM work_done wd
    JOIN project_modules pm ON wd.module_id = pm.module_id
    JOIN projects p ON pm.project_id = p.project_id
    WHERE p.project_completed_on IS NOT NULL 
    AND p.project_completed_on < DATE_SUB(NOW(), INTERVAL 3 MONTH);
    SET @work_done_count = ROW_COUNT();
    
    DELETE pm FROM project_modules pm
    JOIN projects p ON pm.project_id = p.project_id
    WHERE p.project_completed_on IS NOT NULL 
    AND p.project_completed_on < DATE_SUB(NOW(), INTERVAL 3 MONTH);
    SET @modules_count = ROW_COUNT();
    
    DELETE FROM projects 
    WHERE project_completed_on IS NOT NULL 
    AND project_completed_on < DATE_SUB(NOW(), INTERVAL 3 MONTH);
    SET @projects_count = ROW_COUNT();
    
    -- In kết quả
    SELECT CONCAT('Removed - Projects: ', @projects_count, 
                 ', Modules: ', @modules_count, 
                 ', Work Done: ', @work_done_count) AS removal_summary;
END$$
DELIMITER ;

CALL sp_remove_completed_projects();

-- c) Stored procedure in ra modules đang được thực hiện
DELIMITER $$
CREATE PROCEDURE sp_get_ongoing_modules()
BEGIN
    SELECT 
        pm.module_id,
        pm.project_modules_description,
        CONCAT(e.employee_first_name, ' ', e.employee_last_name) AS employee_name
    FROM project_modules pm
    JOIN employee e ON pm.employee_id = e.employee_id
    WHERE pm.project_modules_completed_on IS NULL;
END$$
DELIMITER ;

CALL sp_get_ongoing_modules();

-- d) Hàm trả về nhân viên tham gia làm mà không ai giao việc
DELIMITER $$
CREATE FUNCTION fn_get_self_assigned_employee(employee_id_param INT)
RETURNS VARCHAR(200)
READS SQL DATA
DETERMINISTIC
BEGIN
    DECLARE result VARCHAR(200);
    
    SELECT CONCAT(e.employee_first_name, ' ', e.employee_last_name, ' (ID: ', e.employee_id, ')')
    INTO result
    FROM employee e
    WHERE e.employee_id = employee_id_param
    AND EXISTS (
        SELECT 1 FROM work_done wd
        WHERE wd.employee_id = employee_id_param
        AND NOT EXISTS (
            SELECT 1 FROM project_modules pm 
            WHERE pm.module_id = wd.module_id 
            AND pm.employee_id = employee_id_param
        )
    );
    
    RETURN COALESCE(result, 'No self-assigned work found');
END$$
DELIMITER ;

SELECT fn_get_self_assigned_employee(2);
