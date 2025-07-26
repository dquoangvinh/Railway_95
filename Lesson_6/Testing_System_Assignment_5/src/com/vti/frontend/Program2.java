package com.vti.frontend;

import java.util.Scanner;
import com.vti.backend.Exercise2;

public class Program2 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n=== EXERCISE 2 - POLYMORPHISM ===");
            System.out.println("1. Tạo 10 học sinh và chia nhóm (Q1)");
            System.out.println("2. Cả lớp điểm danh (Q1)");
            System.out.println("3. Nhóm 1 học bài (Q1)");
            System.out.println("4. Nhóm 2 dọn vệ sinh (Q1)");
            System.out.println("5. Test Person/Student (Q2 Optional)");
            System.out.println("6. Test hình học (Q3)");
            System.out.println("7. Test MyMath Overloading (Q4 Optional)");
            System.out.println("8. Test điện thoại (Q5)");
            System.out.println("9. Exit");
            System.out.print("Please choose: ");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1 -> Exercise2.createStudents();
                case 2 -> Exercise2.diemDanhCaLop();
                case 3 -> Exercise2.nhom1HocBai();
                case 4 -> Exercise2.nhom2DonVeSinh();
                case 5 -> Exercise2.testPersonStudent();
                case 6 -> Exercise2.testHinhHoc();
                case 7 -> Exercise2.testMyMath();
                case 8 -> Exercise2.testDienThoai();
                case 9 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 9);
        
        scanner.close();
    }
}
