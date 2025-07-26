package com.vti.backend;

import java.util.ArrayList;
import java.util.List;
import com.vti.entity.*;

public class Exercise2 {
    private static List<Student> students = new ArrayList<>();

    // Question 1: Student Management
    public static void createStudents() {
        students.clear();
        String[] names = {"Nguyễn Văn A", "Nguyễn Văn B", "Nguyễn Văn C", 
                         "Nguyễn Văn D", "Nguyễn Văn E", "Nguyễn Văn F",
                         "Nguyễn Văn G", "Nguyễn Văn H", "Nguyễn Văn I", "Nguyễn Văn J"};
        
        for (int i = 0; i < 10; i++) {
            int group = (i % 3) + 1; // Chia thành 3 nhóm
            students.add(new Student(i + 1, names[i], group));
        }
        System.out.println("Đã tạo 10 học sinh chia thành 3 nhóm!");
    }

    public static void diemDanhCaLop() {
        System.out.println("\n=== ĐIỂM DANH CẢ LỚP ===");
        for (var student : students) {
            student.diemDanh();
        }
    }

    public static void nhom1HocBai() {
        System.out.println("\n=== NHÓM 1 HỌC BÀI ===");
        students.stream()
                .filter(s -> s.getGroup() == 1)
                .forEach(Student::hocBai);
    }

    public static void nhom2DonVeSinh() {
        System.out.println("\n=== NHÓM 2 DỌN VỆ SINH ===");
        students.stream()
                .filter(s -> s.getGroup() == 2)
                .forEach(Student::diDonVeSinh);
    }

    // Question 3: Hình học
    public static void testHinhHoc() {
        System.out.println("\n=== TEST HÌNH HỌC ===");
        
        var hinhChuNhat = new HinhChuNhat(5, 3);
        System.out.println("Hình chữ nhật 5x3:");
        System.out.println("Chu vi: " + hinhChuNhat.tinhChuVi());
        System.out.println("Diện tích: " + hinhChuNhat.tinhDienTich());
        
        System.out.println();
        
        var hinhVuong = new HinhVuong(4);
        System.out.println("Hình vuông cạnh 4:");
        System.out.println("Chu vi: " + hinhVuong.tinhChuVi());
        System.out.println("Diện tích: " + hinhVuong.tinhDienTich());
    }

    // Question 5: Điện thoại
    public static void testDienThoai() {
        System.out.println("\n=== TEST ĐIỆN THOẠI ===");
        
        var dtThongMinh = new DienThoaiThongMinh("iPhone", "Đen");
        System.out.println("Điện thoại thông minh:");
        dtThongMinh.goiDienThoai();
        dtThongMinh.suDung3G();
        dtThongMinh.chupHinh();
        dtThongMinh.tanCongVuKhi();
        
        System.out.println();
        
        var dtCoDien = new DienThoaiCoDien("Nokia", "Xanh");
        System.out.println("Điện thoại cổ điển:");
        dtCoDien.goiDienThoai();
        dtCoDien.ngheDaiRadio();
        dtCoDien.tanCongVuKhi();
    }

    // Question 2 (Optional): Person/Student Management
    public static void testPersonStudent() {
        System.out.println("\n=== TEST PERSON/STUDENT ===");
        
        // Test Person
        var person = new Person();
        System.out.println("Nhập thông tin Person:");
        person.inputInfo();
        person.showInfo();
        
        System.out.println();
        
        // Test Student
        var student = new StudentPerson();
        System.out.println("Nhập thông tin Student:");
        student.inputInfo();
        student.showInfo();
    }

    // Question 4 (Optional): MyMath Method Overloading
    public static void testMyMath() {
        System.out.println("\n=== TEST MYMATH OVERLOADING ===");
        
        var myMath = new MyMath();
        
        // Test với các kiểu dữ liệu khác nhau
        System.out.println("Kết quả: " + myMath.sum(5, 10));
        System.out.println("Kết quả: " + myMath.sum((byte)3, (byte)7));
        System.out.println("Kết quả: " + myMath.sum(2.5f, 3.7f));
        System.out.println("Kết quả: " + myMath.sum(4.2, 5.8));
        System.out.println("Kết quả: " + myMath.sum(100L, 200L));
    }
}
