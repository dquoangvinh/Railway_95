package com.vti.frontend;

import com.vti.backend.Exercise4;

public class Program4 {
    public static void main(String[] args) {
        System.out.println("===== TESTING SYSTEM ASSIGNMENT 4 - EXERCISE 4 =====");
        System.out.println("Demonstrating Encapsulation\n");
        
        var exercise4 = new Exercise4();
        
        // Chạy các questions
        exercise4.question1(); // Encapsulation với Student class
        exercise4.question2(); // UML Class Design (Circle, BankAccount, DateCustom)
        
        System.out.println("===== END OF EXERCISE 4 DEMO =====");
    }
}