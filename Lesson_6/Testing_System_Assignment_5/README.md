# Testing System Assignment 5

## Structure
```
src/
├── com.vti.entity/          # Các class entity
│   ├── INews.java           # Interface cho News
│   ├── News.java            # Class News implement INews
│   ├── ThiSinh.java         # Abstract class Thí Sinh
│   ├── ThiSinhKhoiA.java    # Thí sinh khối A
│   ├── ThiSinhKhoiB.java    # Thí sinh khối B  
│   ├── ThiSinhKhoiC.java    # Thí sinh khối C
│   ├── ITuyenSinh.java      # Interface Tuyển Sinh
│   ├── TuyenSinh.java       # Class Tuyển Sinh implement ITuyenSinh
│   ├── IStudent.java        # Interface cho Student
│   ├── Student.java         # Class Student implement IStudent
│   ├── Person.java          # Class Person
│   ├── StudentPerson.java   # Class StudentPerson extends Person
│   ├── HinhChuNhat.java     # Class Hình Chữ Nhật
│   ├── HinhVuong.java       # Class Hình Vuông extends HinhChuNhat
│   ├── MyMath.java          # Class MyMath với overloading
│   ├── IVuKhi.java          # Interface Vũ Khí
│   ├── DienThoaiDiDong.java # Abstract class Điện Thoại Di Động
│   ├── DienThoaiThongMinh.java # Điện Thoại Thông Minh
│   ├── DienThoaiCoDien.java # Điện Thoại Cổ Điển
│   ├── CPU.java             # CPU với inner classes
│   ├── Car.java             # Car với inner class Engine
│   ├── OuterClass.java      # Demo cho Question 3
│   └── NgayThangNam.java    # Demo cho Question 4
├── com.vti.backend/         # Logic xử lý
│   ├── Exercise1.java       # Logic cho Exercise 1
│   ├── Exercise2.java       # Logic cho Exercise 2
│   └── Exercise3.java       # Logic cho Exercise 3
└── com.vti.frontend/        # Main programs với menu
    ├── Program1.java        # Demo Exercise 1
    ├── Program2.java        # Demo Exercise 2
    └── Program3.java        # Demo Exercise 3
```

## Exercise 1: Abstraction
- **Question 1**: News management system với interface INews
- **Question 2**: (Optional) Tuyển sinh system - Thí sinh dự thi đại học khối A, B, C

## Exercise 2: Polymorphism  
- **Question 1**: Student management với interface IStudent
- **Question 2**: (Optional) Person/Student với inheritance và học bổng logic
- **Question 3**: HinhChuNhat/HinhVuong với override và super
- **Question 4**: (Optional) MyMath với method overloading cho nhiều kiểu dữ liệu
- **Question 5**: Điện thoại di động với inheritance và interface

## Exercise 3: Inner Classes
- **Question 1**: CPU với Processor và Ram inner classes
- **Question 2**: Car với Engine inner class  
- **Question 3**: Output analysis với OuterClass/InnerClass
- **Question 4**: Output analysis với NgayThangNam/GioPhutGiay

## Features Implemented
✅ Interface và Implementation
✅ Inheritance và Polymorphism
✅ Abstract classes
✅ Inner classes (non-static)
✅ Method overriding với super keyword
✅ Method overloading với nhiều kiểu parameter
✅ Tất cả các bài Optional
✅ Modern Java features (var, switch expressions)
✅ Clean code structure với package separation

## How to Run
1. Chạy Program1.main() cho Exercise 1
2. Chạy Program2.main() cho Exercise 2  
3. Chạy Program3.main() cho Exercise 3

## Answers for Output Questions
**Question 3 Output**: "Đây là inner class" (printed twice)
**Question 4 Output**: 
```
Ngày: 31/10/2017
Giờ: 10:15:30
```
