package com.vti.frontend;

import com.vti.backend.Exercise5;

public class Program5 {
    public static void main(String[] args) {
        System.out.println("===== TESTING SYSTEM ASSIGNMENT 4 - EXERCISE 5 =====");
        System.out.println("Demonstrating Inheritance\n");
        
        var exercise5 = new Exercise5();
        
        // Chạy các questions
        exercise5.question1(); // Inheritance basics
        exercise5.question2(); // Quản lý cán bộ
        exercise5.question3(); // Constructor inheritance
        
        System.out.println("===== END OF EXERCISE 5 DEMO =====");
        
        // Uncomment để chạy menu tương tác QLCB
        // System.out.println("\n*** Bạn có muốn chạy menu quản lý cán bộ? (y/n) ***");
        // Scanner scanner = new Scanner(System.in);
        // if (scanner.nextLine().equalsIgnoreCase("y")) {
        //     QLCB qlcb = new QLCB();
        //     qlcb.menu();
        // }
    }
}