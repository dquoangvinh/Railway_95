package com.vti.backend;

import com.vti.entity.*;

public class Exercise6 {
    
    // Question 1: Abstract class & abstract method
    public void question1() {
        System.out.println("=== Question 1: Abstract Phone ===");
        
        var phone = new VietnamesePhone();
        
        // Demo các chức năng
        System.out.println("--- Thêm liên hệ ---");
        phone.insertContact("Nguyễn Văn A", "0123456789");
        phone.insertContact("Trần Thị B", "0987654321");
        phone.insertContact("Lê Văn C", "0555666777");
        
        System.out.println("\n--- Hiển thị danh bạ ---");
        phone.displayAllContacts();
        
        System.out.println("\n--- Tìm kiếm liên hệ ---");
        phone.searchContact("Nguyễn");
        phone.searchContact("Hoàng");
        
        System.out.println("\n--- Cập nhật liên hệ ---");
        phone.updateContact("Trần Thị B", "0111222333");
        phone.displayAllContacts();
        
        System.out.println("\n--- Xóa liên hệ ---");
        phone.removeContact("Lê Văn C");
        phone.displayAllContacts();
        
        System.out.println();
    }
    
    // Question 2: Abstract User class
    public void question2() {
        System.out.println("=== Question 2: Abstract User ===");
        
        // Tạo các user khác nhau
        User[] users = {
            new Employee("John Employee", 2.5),
            new Manager("Jane Manager", 3.0),
            new Waiter("Bob Waiter", 1.8)
        };
        
        System.out.println("--- Thông tin các User ---");
        for (var user : users) {
            user.displayInfo();
        }
        
        System.out.println();
    }
    
    // Question 3: Employee, Manager, Waiter inheritance
    public void question3() {
        System.out.println("=== Question 3: User Types ===");
        
        var employee = new Employee("Alice", 2.0);
        var manager = new Manager("David", 4.0);
        var waiter = new Waiter("Charlie", 1.5);
        
        System.out.println("--- Chi tiết tính lương ---");
        System.out.printf("Employee '%s': %.1f x 420 = %.2f%n", 
                         employee.getName(), employee.getSalaryRatio(), employee.calculatePay());
        
        System.out.printf("Manager '%s': %.1f x 520 = %.2f%n",
                         manager.getName(), manager.getSalaryRatio(), manager.calculatePay());
        
        System.out.printf("Waiter '%s': %.1f x 220 = %.2f%n",
                         waiter.getName(), waiter.getSalaryRatio(), waiter.calculatePay());
        
        System.out.println("\n--- Hiển thị thông tin đầy đủ ---");
        employee.displayInfo();
        manager.displayInfo();
        waiter.displayInfo();
        
        System.out.println();
    }
}