package com.vti.backend;

import com.vti.entity.*;

public class Exercise4 {
    
    // Question 1: Encapsulation - Student class
    public void question1() {
        System.out.println("=== Question 1: Encapsulation - Student ===");
        
        // Tạo sinh viên với tên và quê quán, điểm học lực = 0
        var student1 = new StudentEx4("Nguyễn Văn An", "Hà Nội");
        var student2 = new StudentEx4("Trần Thị Bình", "TP.HCM");
        var student3 = new StudentEx4("Lê Văn Cường", "Đà Nẵng");
        
        System.out.println("--- Thông tin ban đầu ---");
        student1.inThongTin();
        
        // Set điểm cho sinh viên
        System.out.println("\n--- Set điểm ---");
        student1.setDiem(7.5);
        student2.setDiem(8.5);
        student3.setDiem(5.2);
        
        // Cộng thêm điểm
        System.out.println("\n--- Cộng thêm điểm ---");
        student1.congDiem(1.0); // 7.5 + 1.0 = 8.5 (Giỏi)
        student2.congDiem(0.5); // 8.5 + 0.5 = 9.0 (Giỏi)
        student3.congDiem(2.0); // 5.2 + 2.0 = 7.2 (Khá)
        
        // In thông tin tất cả sinh viên
        System.out.println("\n--- Thông tin tất cả sinh viên ---");
        student1.inThongTin();
        student2.inThongTin();
        student3.inThongTin();
        
        // Test các trường hợp đặc biệt
        System.out.println("\n--- Test các trường hợp đặc biệt ---");
        var student4 = new StudentEx4("Phạm Thị Dung", "Hải Phòng");
        student4.setDiem(3.5); // Yếu
        student4.inThongTin();
        
        student4.setDiem(5.8); // Trung bình
        student4.inThongTin();
        
        student4.setDiem(6.7); // Khá
        student4.inThongTin();
        
        System.out.println();
    }
    
    // Question 2: Tạo class theo thiết kế UML
    public void question2() {
        System.out.println("=== Question 2: UML Class Design ===");
        
        // Demo Circle class
        System.out.println("--- Demo Circle Class ---");
        var circle1 = new Circle(); // Default constructor
        System.out.println("Circle 1 (default): " + circle1);
        
        var circle2 = new Circle(5.0); // Constructor với radius
        System.out.println("Circle 2 (radius=5.0): " + circle2);
        
        var circle3 = new Circle(3.5, "blue"); // Constructor đầy đủ
        System.out.println("Circle 3 (radius=3.5, color=blue): " + circle3);
        
        // Test setter
        circle1.setRadius(2.8);
        circle1.setColor("green");
        System.out.println("Circle 1 after set: " + circle1);
        
        // Demo BankAccount class
        System.out.println("\n--- Demo BankAccount Class ---");
        var account1 = new BankAccount("ACC001", "Nguyễn Văn A", 1000000);
        var account2 = new BankAccount("ACC002", "Trần Thị B", 500000);
        
        System.out.println("Account 1: " + account1);
        System.out.println("Account 2: " + account2);
        
        // Test credit (nạp tiền)
        System.out.println("\n--- Test Credit (Nạp tiền) ---");
        account1.credit(200000);
        
        // Test debit (rút tiền)
        System.out.println("\n--- Test Debit (Rút tiền) ---");
        account1.debit(150000);
        account1.debit(2000000); // Test rút quá số dư
        
        // Test transfer (chuyển tiền)
        System.out.println("\n--- Test Transfer (Chuyển tiền) ---");
        account1.transferTo(account2, 300000);
        account1.transferTo(account2, 1500000); // Test chuyển quá số dư
        
        // Demo DateCustom class
        System.out.println("\n--- Demo DateCustom Class ---");
        var date1 = new DateCustom(29, 2, 2024); // Năm nhuận
        var date2 = new DateCustom(29, 2, 2023); // Năm không nhuận
        var date3 = new DateCustom(15, 8, 2000); // Năm nhuận
        var date4 = new DateCustom(25, 12, 2023); // Năm không nhuận
        
        System.out.println("Date 1: " + date1);
        System.out.println("Date 2: " + date2);
        System.out.println("Date 3: " + date3);
        System.out.println("Date 4: " + date4);
        
        // Test setter
        System.out.println("\n--- Test Date Setter ---");
        date4.setDay(1);
        date4.setMonth(1);
        date4.setYear(2000);
        System.out.println("Date 4 after set: " + date4);
        
        System.out.println();
    }
}