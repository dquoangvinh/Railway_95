package com.vti.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TuyenSinh implements ITuyenSinh {
    private List<ThiSinh> danhSachThiSinh = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void themMoiThiSinh() {
        System.out.println("\n=== THÊM MỚI THÍ SINH ===");
        System.out.print("Nhập số báo danh: ");
        String soBaoDanh = scanner.nextLine();
        
        System.out.print("Nhập họ tên: ");
        String hoTen = scanner.nextLine();
        
        System.out.print("Nhập địa chỉ: ");
        String diaChi = scanner.nextLine();
        
        System.out.print("Nhập mức ưu tiên: ");
        String mucUuTien = scanner.nextLine();
        
        System.out.println("Chọn khối thi:");
        System.out.println("1. Khối A (Toán, Lý, Hoá)");
        System.out.println("2. Khối B (Toán, Hoá, Sinh)");
        System.out.println("3. Khối C (Văn, Sử, Địa)");
        System.out.print("Lựa chọn: ");
        
        int khoi = scanner.nextInt();
        scanner.nextLine(); // consume newline
        
        ThiSinh thiSinh = switch (khoi) {
            case 1 -> new ThiSinhKhoiA(soBaoDanh, hoTen, diaChi, mucUuTien);
            case 2 -> new ThiSinhKhoiB(soBaoDanh, hoTen, diaChi, mucUuTien);
            case 3 -> new ThiSinhKhoiC(soBaoDanh, hoTen, diaChi, mucUuTien);
            default -> {
                System.out.println("Khối không hợp lệ!");
                yield null;
            }
        };
        
        if (thiSinh != null) {
            danhSachThiSinh.add(thiSinh);
            System.out.println("Thêm thí sinh thành công!");
        }
    }

    @Override
    public void hienThiThongTinThiSinh() {
        System.out.println("\n=== DANH SÁCH THÍ SINH ===");
        if (danhSachThiSinh.isEmpty()) {
            System.out.println("Không có thí sinh nào!");
            return;
        }
        
        for (var thiSinh : danhSachThiSinh) {
            thiSinh.hienThiThongTin();
            System.out.println();
        }
    }

    @Override
    public void timKiemTheoSoBaoDanh() {
        System.out.print("\nNhập số báo danh cần tìm: ");
        String soBaoDanh = scanner.nextLine();
        
        var thiSinh = danhSachThiSinh.stream()
                .filter(ts -> ts.getSoBaoDanh().equals(soBaoDanh))
                .findFirst()
                .orElse(null);
                
        if (thiSinh != null) {
            System.out.println("\n=== KẾT QUẢ TÌM KIẾM ===");
            thiSinh.hienThiThongTin();
        } else {
            System.out.println("Không tìm thấy thí sinh có số báo danh: " + soBaoDanh);
        }
    }

    @Override
    public void thoatChuongTrinh() {
        System.out.println("Cảm ơn bạn đã sử dụng hệ thống tuyển sinh!");
        System.exit(0);
    }
}
