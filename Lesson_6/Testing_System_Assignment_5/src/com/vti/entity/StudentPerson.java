package com.vti.entity;

import java.util.Scanner;

public class StudentPerson extends Person {
    private String maSinhVien;
    private double diemTrungBinh;
    private String email;

    public StudentPerson() {}

    public StudentPerson(String ten, String gioiTinh, String ngaySinh, String diaChi, 
                        String maSinhVien, double diemTrungBinh, String email) {
        super(ten, gioiTinh, ngaySinh, diaChi);
        this.maSinhVien = maSinhVien;
        this.diemTrungBinh = diemTrungBinh;
        this.email = email;
    }

    @Override
    public void inputInfo() {
        super.inputInfo(); // Gọi method inputInfo của Person
        
        var scanner = new Scanner(System.in);
        System.out.print("Nhập mã sinh viên: ");
        this.maSinhVien = scanner.nextLine();
        
        System.out.print("Nhập điểm trung bình: ");
        this.diemTrungBinh = scanner.nextDouble();
        scanner.nextLine(); // consume newline
        
        System.out.print("Nhập email: ");
        this.email = scanner.nextLine();
    }

    @Override
    public void showInfo() {
        System.out.println("=== THÔNG TIN SINH VIÊN ===");
        System.out.println("Tên: " + ten);
        System.out.println("Giới tính: " + gioiTinh);
        System.out.println("Ngày sinh: " + ngaySinh);
        System.out.println("Địa chỉ: " + diaChi);
        System.out.println("Mã sinh viên: " + maSinhVien);
        System.out.println("Điểm trung bình: " + diemTrungBinh);
        System.out.println("Email: " + email);
        System.out.println("Học bổng: " + (duocHocBong() ? "Có" : "Không"));
    }

    public boolean duocHocBong() {
        return diemTrungBinh >= 8.0;
    }

    // Getters and Setters
    public String getMaSinhVien() { return maSinhVien; }
    public void setMaSinhVien(String maSinhVien) { this.maSinhVien = maSinhVien; }

    public double getDiemTrungBinh() { return diemTrungBinh; }
    public void setDiemTrungBinh(double diemTrungBinh) { this.diemTrungBinh = diemTrungBinh; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
