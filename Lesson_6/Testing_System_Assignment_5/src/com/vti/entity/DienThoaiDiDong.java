package com.vti.entity;

public abstract class DienThoaiDiDong {
    protected String hang;
    protected String mau;

    public DienThoaiDiDong() {}

    public DienThoaiDiDong(String hang, String mau) {
        this.hang = hang;
        this.mau = mau;
    }

    // 4 chức năng cơ bản
    public void goiDienThoai() {
        System.out.println("Gọi điện thoại");
    }

    public void ngheDienThoai() {
        System.out.println("Nghe điện thoại");
    }

    public void guiTinNhan() {
        System.out.println("Gửi tin nhắn văn bản");
    }

    public void nhanTinNhan() {
        System.out.println("Nhận tin nhắn văn bản");
    }

    // Getters and Setters
    public String getHang() { return hang; }
    public void setHang(String hang) { this.hang = hang; }

    public String getMau() { return mau; }
    public void setMau(String mau) { this.mau = mau; }
}
