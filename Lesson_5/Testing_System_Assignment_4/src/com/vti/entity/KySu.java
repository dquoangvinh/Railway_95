package com.vti.entity;

public class KySu extends CanBo {
    private String nganh;
    
    public KySu() {
    }
    
    public KySu(String hoTen, int tuoi, String gioiTinh, String diaChi, String nganh) {
        super(hoTen, tuoi, gioiTinh, diaChi);
        this.nganh = nganh;
    }
    
    public String getNganh() {
        return nganh;
    }
    
    public void setNganh(String nganh) {
        this.nganh = nganh;
    }
    
    @Override
    public String toString() {
        return "Kỹ sư - " + super.toString() + ", Ngành: " + nganh;
    }
}