package com.vti.entity;

public class ThiSinhKhoiB extends ThiSinh {
    private final String[] monThi = {"Toán", "Hoá", "Sinh"};

    public ThiSinhKhoiB() {}

    public ThiSinhKhoiB(String soBaoDanh, String hoTen, String diaChi, String mucUuTien) {
        super(soBaoDanh, hoTen, diaChi, mucUuTien);
    }

    @Override
    public void hienThiThongTin() {
        System.out.println("=== THÔNG TIN THÍ SINH KHỐI B ===");
        System.out.println("Số báo danh: " + soBaoDanh);
        System.out.println("Họ tên: " + hoTen);
        System.out.println("Địa chỉ: " + diaChi);
        System.out.println("Mức ưu tiên: " + mucUuTien);
        System.out.println("Khối thi: B - " + String.join(", ", monThi));
    }

    public String[] getMonThi() { return monThi; }
}
