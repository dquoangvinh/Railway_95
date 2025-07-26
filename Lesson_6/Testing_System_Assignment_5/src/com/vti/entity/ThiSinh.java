package com.vti.entity;

public abstract class ThiSinh {
    protected String soBaoDanh;
    protected String hoTen;
    protected String diaChi;
    protected String mucUuTien;

    public ThiSinh() {}

    public ThiSinh(String soBaoDanh, String hoTen, String diaChi, String mucUuTien) {
        this.soBaoDanh = soBaoDanh;
        this.hoTen = hoTen;
        this.diaChi = diaChi;
        this.mucUuTien = mucUuTien;
    }

    public abstract void hienThiThongTin();

    // Getters and Setters
    public String getSoBaoDanh() { return soBaoDanh; }
    public void setSoBaoDanh(String soBaoDanh) { this.soBaoDanh = soBaoDanh; }

    public String getHoTen() { return hoTen; }
    public void setHoTen(String hoTen) { this.hoTen = hoTen; }

    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }

    public String getMucUuTien() { return mucUuTien; }
    public void setMucUuTien(String mucUuTien) { this.mucUuTien = mucUuTien; }
}
