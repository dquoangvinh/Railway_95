package com.vti.entity;

public class DienThoaiCoDien extends DienThoaiDiDong implements IVuKhi {
    
    public DienThoaiCoDien() {}

    public DienThoaiCoDien(String hang, String mau) {
        super(hang, mau);
    }

    // Chức năng riêng của điện thoại cổ điển
    public void ngheDaiRadio() {
        System.out.println("Nghe đài radio");
    }

    @Override
    public void tanCongVuKhi() {
        System.out.println("Điện thoại cổ điển tấn công kẻ xấu");
    }
}
