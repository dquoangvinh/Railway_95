package com.vti.entity;

public class DienThoaiThongMinh extends DienThoaiDiDong implements IVuKhi {
    
    public DienThoaiThongMinh() {}

    public DienThoaiThongMinh(String hang, String mau) {
        super(hang, mau);
    }

    // Chức năng riêng của điện thoại thông minh
    public void suDung3G() {
        System.out.println("Sử dụng 3G");
    }

    public void chupHinh() {
        System.out.println("Chụp hình");
    }

    @Override
    public void tanCongVuKhi() {
        System.out.println("Điện thoại thông minh tấn công kẻ xấu");
    }
}
