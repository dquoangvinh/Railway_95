package com.vti.backend;

import java.util.Random;

public class Exercise1 {
    
    // Question 1: Khai báo 2 số lương kiểu float và làm tròn
    public static void question1() {
        var salary1 = 5240.5f;
        var salary2 = 10970.055f;
        
        var roundedSalary1 = (int) salary1;
        var roundedSalary2 = (int) salary2;
        
        System.out.println("Lương Account 1 làm tròn: " + roundedSalary1);
        System.out.println("Lương Account 2 làm tròn: " + roundedSalary2);
    }
    
    // Question 2: Lấy ngẫu nhiên số có 5 chữ số
    public static int question2() {
        var random = new Random();
        var number = random.nextInt(100000); // 0-99999
        System.out.printf("Số ngẫu nhiên 5 chữ số: %05d%n", number);
        return number;
    }
    
    // Question 3: Lấy 2 số cuối của số ở Question 2
    public static void question3() {
        var number = question2();
        var lastTwoDigits = number % 100;
        System.out.println("2 số cuối: " + lastTwoDigits);
    }
    
    // Question 4: Method chia 2 số nguyên
    public static double question4(int a, int b) {
        return b != 0 ? (double) a / b : Double.NaN;
    }
}
