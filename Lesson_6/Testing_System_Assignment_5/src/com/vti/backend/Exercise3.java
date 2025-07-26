package com.vti.backend;

import com.vti.entity.*;

public class Exercise3 {

    // Question 1: CPU Inner classes
    public static void testCPU() {
        System.out.println("\n=== QUESTION 1: CPU INNER CLASSES ===");
        
        var cpu = new CPU(1000.0);
        var processor = cpu.new Processor(8, "Intel");
        var ram = cpu.new Ram(16, "Kingston");
        
        System.out.println("CPU Price: $" + cpu.getPrice());
        System.out.println("Processor Cache: " + processor.getCache());
        System.out.println("Ram Clock Speed: " + ram.getClockSpeed());
    }

    // Question 2: Car Inner class
    public static void testCar() {
        System.out.println("\n=== QUESTION 2: CAR INNER CLASS ===");
        
        var car = new Car("Mazda", "8WD");
        var engine = car.new Engine("Crysler");
        
        System.out.println("Car: " + car.getName() + " " + car.getType());
        System.out.println("Engine Type: " + engine.getEngineType());
    }

    // Question 3: Output analysis
    public static void testQuestion3Output() {
        System.out.println("\n=== QUESTION 3: OUTPUT ANALYSIS ===");
        System.out.println("Expected output:");
        
        var outerClass = new OuterClass();
        outerClass.show();
        
        var innerClass = outerClass.new InnerClass();
        innerClass.show();
    }

    // Question 4: Output analysis
    public static void testQuestion4Output() {
        System.out.println("\n=== QUESTION 4: OUTPUT ANALYSIS ===");
        System.out.println("Expected output:");
        
        var date = new NgayThangNam();
        date.ngay = 31;
        date.thang = 10;
        date.nam = 2017;
        
        var time = date.new GioPhutGiay();
        time.gio = 10;
        time.phut = 15;
        time.giay = 30;
        
        time.xuatThongTin();
    }
}
