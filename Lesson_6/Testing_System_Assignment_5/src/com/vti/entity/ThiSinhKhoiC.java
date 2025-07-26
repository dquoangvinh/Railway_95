package com.vti.entity;

public class ThiSinhKhoiC extends ThiSinh {
    private final String[] monThi = {"Văn", "Sử", "Địa"};

    public ThiSinhKhoiC() {}

    public ThiSinhKhoiC(String soBaoDanh, String hoTen, String diaChi, String mucUuTien) {
        super(soBaoDanh, hoTen, diaChi, mucUuTien);
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("=== THÔNG TIN THÍ SINH KHỐI C ===");
        System.out.println("Số báo danh: " + soBaoDanh);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Địa chỉ: " + diaChi);
        System.out.println("Mức ưu tiên: " + mucUuTien);
        System.out.println("Khối thi: C - " + String.join(", ", monThi));
    }

    public String[] getMonThi() { return monThi; }
}
