package com.vti.backend;

import com.vti.entity.*;

public class Exercise5 {
    
    // Question 1: Inheritance - Tạo các class CongNhan, KySu, NhanVien kế thừa CanBo
    public void question1() {
        System.out.println("=== Question 1: Inheritance ===");
        
        // Tạo các cán bộ
        var congNhan = new CongNhan("Nguyễn Văn A", 30, "Nam", "Hà Nội", 5);
        var kySu = new KySu("Trần Thị B", 28, "Nữ", "TP.HCM", "Công nghệ thông tin");
        var nhanVien = new NhanVien("Lê Văn C", 25, "Nam", "Đà Nẵng", "Kế toán");
        
        System.out.println(congNhan);
        System.out.println(kySu);
        System.out.println(nhanVien);
        System.out.println();
    }
    
    // Question 2: Quản lý cán bộ
    public void question2() {
        System.out.println("=== Question 2: Quản lý cán bộ ===");
        
        var qlcb = new QLCB();
        
        // Thêm mới cán bộ
        qlcb.themCanBo(new CongNhan("Nguyễn Văn An", 35, "Nam", "Hà Nội", 7));
        qlcb.themCanBo(new KySu("Trần Thị Bình", 30, "Nữ", "TP.HCM", "Xây dựng"));
        qlcb.themCanBo(new NhanVien("Lê Văn Cường", 28, "Nam", "Đà Nẵng", "Nhân sự"));
        qlcb.themCanBo(new CongNhan("Phạm Thị Dung", 32, "Nữ", "Hải Phòng", 6));
        
        // Hiển thị danh sách
        qlcb.hienThiDanhSach();
        
        // Tìm kiếm theo tên
        System.out.println("\n--- Tìm kiếm 'Nguyễn' ---");
        var ketQua = qlcb.timKiemTheoTen("Nguyễn");
        ketQua.forEach(System.out::println);
        
        // Xóa cán bộ
        System.out.println("\n--- Xóa cán bộ 'Lê Văn Cường' ---");
        qlcb.xoaCanBo("Lê Văn Cường");
        qlcb.hienThiDanhSach();
        
        System.out.println("\n*** Để chạy menu tương tác, gọi qlcb.menu() ***");
        System.out.println();
    }
    
    // Question 3: Constructor inheritance
    public void question3() {
        System.out.println("=== Question 3: Constructor Inheritance ===");
        
        // Khởi tạo HighSchoolStudent với các giá trị yêu cầu
        var student = new HighSchoolStudent(1, "Nam", "Chuyên Văn", "Đại học công nghệ");
        
        System.out.println("Created HighSchoolStudent:");
        System.out.println(student);
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("Class: " + student.getClazz());
        System.out.println("Desired University: " + student.getDesiredUniversity());
        System.out.println();
    }
}