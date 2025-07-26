package com.vti.entity;

public class HinhVuong extends HinhChuNhat {
    private double canh;

    public HinhVuong() {}

    public HinhVuong(double canh) {
        super(canh, canh);  // gọi constructor của HinhChuNhat
        this.canh = canh;
    }

    @Override
    public double tinhChuVi() {
        System.out.println("Tính chu vi theo Hình Vuông");
        return super.tinhChuVi();  // gọi method của HinhChuNhat
    }

    @Override
    public double tinhDienTich() {
        System.out.println("Tính diện tích theo Hình Vuông");
        return super.tinhDienTich();  // gọi method của HinhChuNhat
    }

    public double getCanh() { return canh; }
    public void setCanh(double canh) {
        this.canh = canh;
        this.chieuDai = canh;
        this.chieuRong = canh;
    }
}
