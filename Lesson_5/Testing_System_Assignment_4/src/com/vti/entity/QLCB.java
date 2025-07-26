package com.vti.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class QLCB {
    private ArrayList<CanBo> danhSachCanBo;
    
    public QLCB() {
        this.danhSachCanBo = new ArrayList<>();
    }
    
    // Thêm mới cán bộ
    public void themCanBo(CanBo canBo) {
        danhSachCanBo.add(canBo);
        System.out.println("Đã thêm cán bộ: " + canBo.getHoTen());
    }
    
    // Tìm kiếm theo họ tên
    public ArrayList<CanBo> timKiemTheoTen(String ten) {
        var ketQua = new ArrayList<CanBo>();
        for (var canBo : danhSachCanBo) {
            if (canBo.getHoTen().toLowerCase().contains(ten.toLowerCase())) {
                ketQua.add(canBo);
            }
        }
        return ketQua;
    }
    
    // Hiển thị thông tin danh sách cán bộ
    public void hienThiDanhSach() {
        if (danhSachCanBo.isEmpty()) {
            System.out.println("Danh sách cán bộ trống!");
            return;
        }
        
        System.out.println("=== DANH SÁCH CÁN BỘ ===");
        for (int i = 0; i < danhSachCanBo.size(); i++) {
            System.out.println((i + 1) + ". " + danhSachCanBo.get(i));
        }
    }
    
    // Xóa cán bộ theo tên
    public boolean xoaCanBo(String ten) {
        return danhSachCanBo.removeIf(canBo -> canBo.getHoTen().equalsIgnoreCase(ten));
    }
    
    // Menu quản lý
    public void menu() {
        var scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\n=== QUẢN LÝ CÁN BỘ ===");
            System.out.println("1. Thêm mới cán bộ");
            System.out.println("2. Tìm kiếm theo họ tên");
            System.out.println("3. Hiển thị danh sách cán bộ");
            System.out.println("4. Xóa cán bộ");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            
            var chon = scanner.nextInt();
            scanner.nextLine(); // clear buffer
            
            switch (chon) {
                case 1 -> themCanBoMoi(scanner);
                case 2 -> timKiem(scanner);
                case 3 -> hienThiDanhSach();
                case 4 -> xoaCanBoTheoTen(scanner);
                case 5 -> {
                    System.out.println("Thoát chương trình!");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }
    
    private void themCanBoMoi(Scanner scanner) {
        System.out.println("Chọn loại cán bộ:");
        System.out.println("1. Công nhân");
        System.out.println("2. Kỹ sư");
        System.out.println("3. Nhân viên");
        var loai = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Nhập họ tên: ");
        var hoTen = scanner.nextLine();
        System.out.print("Nhập tuổi: ");
        var tuoi = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nhập giới tính: ");
        var gioiTinh = scanner.nextLine();
        System.out.print("Nhập địa chỉ: ");
        var diaChi = scanner.nextLine();
        
        switch (loai) {
            case 1 -> {
                System.out.print("Nhập bậc (1-10): ");
                var bac = scanner.nextInt();
                themCanBo(new CongNhan(hoTen, tuoi, gioiTinh, diaChi, bac));
            }
            case 2 -> {
                System.out.print("Nhập ngành đào tạo: ");
                var nganh = scanner.nextLine();
                themCanBo(new KySu(hoTen, tuoi, gioiTinh, diaChi, nganh));
            }
            case 3 -> {
                System.out.print("Nhập công việc: ");
                var congViec = scanner.nextLine();
                themCanBo(new NhanVien(hoTen, tuoi, gioiTinh, diaChi, congViec));
            }
            default -> System.out.println("Loại cán bộ không hợp lệ!");
        }
    }
    
    private void timKiem(Scanner scanner) {
        System.out.print("Nhập tên cần tìm: ");
        var ten = scanner.nextLine();
        var ketQua = timKiemTheoTen(ten);
        
        if (ketQua.isEmpty()) {
            System.out.println("Không tìm thấy cán bộ nào!");
        } else {
            System.out.println("Kết quả tìm kiếm:");
            ketQua.forEach(System.out::println);
        }
    }
    
    private void xoaCanBoTheoTen(Scanner scanner) {
        System.out.print("Nhập tên cán bộ cần xóa: ");
        var ten = scanner.nextLine();
        
        if (xoaCanBo(ten)) {
            System.out.println("Đã xóa cán bộ: " + ten);
        } else {
            System.out.println("Không tìm thấy cán bộ: " + ten);
        }
    }
}