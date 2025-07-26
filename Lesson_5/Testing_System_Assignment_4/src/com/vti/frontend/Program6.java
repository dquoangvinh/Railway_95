package com.vti.frontend;

import com.vti.backend.Exercise6;

public class Program6 {
    public static void main(String[] args) {
        System.out.println("===== TESTING SYSTEM ASSIGNMENT 4 - EXERCISE 6 =====");
        System.out.println("Demonstrating Abstraction\n");
        
        var exercise6 = new Exercise6();
        
        // Chạy các questions
        exercise6.question1(); // Abstract Phone
        exercise6.question2(); // Abstract User
        exercise6.question3(); // User inheritance with calculatePay
        
        System.out.println("===== END OF EXERCISE 6 DEMO =====");
    }
}