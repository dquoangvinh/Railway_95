package com.vti.frontend;

import java.util.Scanner;
import com.vti.backend.Exercise1;

public class Program1 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n=== EXERCISE 1 - ABSTRACTION ===");
            System.out.println("1. Insert news (Question 1)");
            System.out.println("2. View list news (Question 1)");
            System.out.println("3. Average rate (Question 1)");
            System.out.println("4. Tuyển sinh system (Question 2)");
            System.out.println("5. Exit");
            System.out.print("Please choose: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1 -> Exercise1.insertNews();
                case 2 -> Exercise1.viewListNews();
                case 3 -> Exercise1.calculateAndDisplayAverageRate();
                case 4 -> Exercise1.runTuyenSinhSystem();
                case 5 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
        
        scanner.close();
    }
}
