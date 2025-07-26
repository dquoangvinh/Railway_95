package com.vti.entity;

public class HinhChuNhat {
    protected double chieuDai;
    protected double chieuRong;

    public HinhChuNhat() {}

    public HinhChuNhat(double chieuDai, double chieuRong) {
        this.chieuDai = chieuDai;
        this.chieuRong = chieuRong;
    }

    public double tinhChuVi() {
        System.out.println("Tính chu vi theo Hình Chữ Nhật");
        return 2 * (chieuDai + chieuRong);
    }

    public double tinhDienTich() {
        System.out.println("Tính diện tích theo Hình Chữ Nhật");
        return chieuDai * chieuRong;
    }

    // Getters and Setters
    public double getChieuDai() { return chieuDai; }
    public void setChieuDai(double chieuDai) { this.chieuDai = chieuDai; }

    public double getChieuRong() { return chieuRong; }
    public void setChieuRong(double chieuRong) { this.chieuRong = chieuRong; }
}
