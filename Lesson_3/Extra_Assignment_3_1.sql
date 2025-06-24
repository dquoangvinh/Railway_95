-- Question 1: Thêm ít nhất 10 bản ghi vào table
INSERT INTO trainee (full_name, birth_date, gender, et_iq, et_gmath, et_english, training_class, evaluation_notes, vti_account)
VALUES 
('Nguyễn Văn An', '1998-05-15', 'male', 7, 16, 35, 'class01', 'Good analytical skills', 'an_nguyenvan'),
('Trần Thị Bình', '1999-05-21', 'female', 16, 18, 8, 'class02', 'Excellent in math', 'binh_tranthi'),
('Lê Văn Cường', '1997-12-03', 'male', 10, 6, 30, 'class01', 'Needs improvement in English', 'cuong_levan'),
('Phạm Thị Dung', '2000-12-28', 'female', 5, 19, 45, 'class03', 'Outstanding performance', 'dung_phamthi'),
('Hoàng Văn Eo', '1996-11-17', 'male', 7, 9, 4, 'class02', 'Struggling with IQ tests', 'eo_hoangvan'),
('Ngô Thị Phương', '1999-04-10', 'female', 14, 3, 38, 'class01', 'Good teamwork', 'phuong_ngothi'),
('Đỗ Văn Giang', '1998-09-22', 'male', 17, 16, 42, 'class03', 'Creative problem solver', 'giang_dovan'),
('Vũ Thị Hương', '2000-11-05', 'female', 13, 14, 37, 'class02', 'Consistent performer', 'huong_vuthi'),
('Mai Văn Ích', '1997-09-19', 'male', 12, 13, 32, 'class01', 'Hard worker', 'ich_maivan'),
('Trịnh Thị Kim', '1999-04-30', 'female', 19, 20, 48, 'class03', 'Exceptional student', 'kim_trinhthi');

-- Question 2: Viết lệnh để lấy ra tất cả các thực tập sinh đã vượt qua bài test đầu vào, nhóm chúng thành các tháng sinh khác nhau
SELECT MONTH(birth_date) AS birth_month, COUNT(*) AS total_trainees, GROUP_CONCAT(full_name) AS trainee_names 
FROM trainee 
WHERE et_iq >= 8 AND et_gmath >= 8 AND et_english >= 18 
GROUP BY MONTH(birth_date);

-- Question 3: Viết lệnh để lấy ra thực tập sinh có tên dài nhất, lấy ra các thông tin sau:
-- tên, tuổi, các thông tin cơ bản (như đã được định nghĩa trong table)
SELECT full_name, YEAR(CURDATE()) - YEAR(birth_date) AS age, et_iq, et_gmath, et_english, training_class
FROM trainee 
WHERE CHAR_LENGTH(full_name) = (SELECT MAX(CHAR_LENGTH(full_name)) FROM trainee);

-- Question 4: Viết lệnh để lấy ra tất cả các thực tập sinh là ET, 1 ET thực tập sinh 
-- là những người đã vượt qua bài test đầu vào và thỏa mãn số điểm như sau: et_iq + et_gmath >= 20, et_iq >= 8, et_gmath >= 8, et_english >= 18
SELECT * 
FROM trainee 
WHERE (et_iq + et_gmath) >= 20
    AND et_iq >= 8
    AND et_gmath >= 8
    AND et_english >= 18;

-- Question 5: Xóa thực tập sinh có trainee_id = 3
DELETE FROM trainee
WHERE trainee_id = 3;

-- Question 6: Thực tập sinh có trainee_id = 5 được chuyển sang lớp "2". Hãy cập nhật thông tin vào database
UPDATE trainee
SET training_class = '2'
WHERE trainee_id = 5;
