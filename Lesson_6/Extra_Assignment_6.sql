USE project_management;

-- Exercise 1:
-- Viết triggers để tránh trường hợp người dùng nhập thông tin module Project không hợp lệ
DELIMITER $$
CREATE TRIGGER trg_validate_module_insert
BEFORE INSERT ON project_modules
FOR EACH ROW
BEGIN
    DECLARE project_start_date DATE;
    DECLARE project_completed_on DATE;
    
    SELECT p.project_start_date, p.project_completed_on 
    INTO project_start_date, project_completed_on
    FROM projects p 
    WHERE p.project_id = NEW.project_id;
    
    -- Kiểm tra 2 điều kiện đề bài yêu cầu
    IF NEW.project_modules_date < project_start_date THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Module date cannot be before project start date';
    END IF;
    
    IF NEW.project_modules_completed_on IS NOT NULL 
       AND project_completed_on IS NOT NULL 
       AND NEW.project_modules_completed_on > project_completed_on THEN
        SIGNAL SQLSTATE '45000' 
        SET MESSAGE_TEXT = 'Module completion date cannot be after project completion date';
    END IF;
END$$
DELIMITER ;

-- Exercise 2: View
-- Trong database phần Assignment 3, Tạo 1 VIEW để lấy ra tất cả các thực tập sinh là ET, 
-- 1 ET thực tập sinh là những người đã vượt qua bài test đầu vào và thỏa mãn số điểm như sau:
-- ET_IQ + ET_Gmath>=20 
-- ET_IQ>=8
-- ET_Gmath>=8 ET_English>=18

USE fresher_management;

CREATE VIEW vw_qualified_et_trainees AS
SELECT *
FROM trainee
WHERE et_iq + et_gmath >= 20
	AND et_iq >= 8
    AND et_gmath >= 8
    AND et_english >= 18;
    