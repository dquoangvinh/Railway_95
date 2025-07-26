package com.vti.backend;

public class Exercise3 {
    
    // Question 1: Khởi tạo lương Integer và convert ra float
    public static void question1() {
        Integer salary = 5000;
        var floatSalary = salary.floatValue();
        System.out.printf("Lương dạng float: %.2f%n", floatSalary);
    }
    
    // Question 2: Convert String thành int
    public static void question2() {
        var str = "1234567";
        var number = Integer.parseInt(str);
        System.out.println("String convert thành int: " + number);
    }
    
    // Question 3: Convert Integer thành int
    public static void question3() {
        Integer number = 1234567;
        int intValue = number;  // Auto-unboxing
        System.out.println("Integer convert thành int: " + intValue);
    }
}
