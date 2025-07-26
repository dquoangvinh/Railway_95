package com.vti.frontend;

import com.vti.backend.Exercise1;

public class Program1 {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 1: DATATYPE CASTING ===\n");
        
        System.out.println("Question 1:");
        Exercise1.question1();
        
        System.out.println("\nQuestion 2 & 3:");
        Exercise1.question3();
        
        System.out.println("\nQuestion 4:");
        var result = Exercise1.question4(10, 3);
        System.out.println("10 / 3 = " + result);
        
        var resultZero = Exercise1.question4(10, 0);
        System.out.println("10 / 0 = " + resultZero);
    }
}
