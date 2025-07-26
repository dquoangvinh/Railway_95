package com.vti.entity;

public class StudentEx4 {
    private static int nextId = 1;
    private int id;
    private String name;
    private String hometown;
    private double diemHocLuc;
    
    public StudentEx4(String name, String hometown) {
        this.id = nextId++;
        this.name = name;
        this.hometown = hometown;
        this.diemHocLuc = 0.0;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getHometown() {
        return hometown;
    }
    
    public double getDiemHocLuc() {
        return diemHocLuc;
    }
    
    // Set điểm
    public void setDiem(double diem) {
        if (diem >= 0 && diem <= 10) {
            this.diemHocLuc = diem;
            System.out.println("Đã set điểm " + diem + " cho sinh viên " + name);
        } else {
            System.out.println("Điểm phải từ 0 đến 10!");
        }
    }
    
    // Cộng thêm điểm
    public void congDiem(double diem) {
        if (diem > 0 && (this.diemHocLuc + diem) <= 10) {
            this.diemHocLuc += diem;
            System.out.println("Đã cộng thêm " + diem + " điểm cho sinh viên " + name + 
                             ". Điểm hiện tại: " + this.diemHocLuc);
        } else {
            System.out.println("Không thể cộng điểm! Điểm tối đa là 10.");
        }
    }
    
    // Xếp loại học lực
    private String xepLoai() {
        if (diemHocLuc < 4.0) {
            return "Yếu";
        } else if (diemHocLuc < 6.0) {
            return "Trung bình";
        } else if (diemHocLuc < 8.0) {
            return "Khá";
        } else {
            return "Giỏi";
        }
    }
    
    // In thông tin sinh viên
    public void inThongTin() {
        System.out.println("=== THÔNG TIN SINH VIÊN ===");
        System.out.println("ID: " + id);
        System.out.println("Tên: " + name);
        System.out.println("Quê quán: " + hometown);
        System.out.println("Điểm học lực: " + diemHocLuc + " (" + xepLoai() + ")");
        System.out.println("==========================");
    }
    
    @Override
    public String toString() {
        return "StudentEx4{id=" + id + ", name='" + name + "', hometown='" + hometown + 
               "', diemHocLuc=" + diemHocLuc + " (" + xepLoai() + ")}";
    }
}