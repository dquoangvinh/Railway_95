package com.vti.frontend;

import java.util.Scanner;
import com.vti.backend.Exercise3;

public class Program3 {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n=== EXERCISE 3 - INNER CLASSES ===");
            System.out.println("1. Test CPU Inner Classes (Question 1)");
            System.out.println("2. Test Car Inner Class (Question 2)");
            System.out.println("3. Test Question 3 Output");
            System.out.println("4. Test Question 4 Output");
            System.out.println("5. Exit");
            System.out.print("Please choose: ");
            
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1 -> Exercise3.testCPU();
                case 2 -> Exercise3.testCar();
                case 3 -> Exercise3.testQuestion3Output();
                case 4 -> Exercise3.testQuestion4Output();
                case 5 -> System.out.println("Goodbye!");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 5);
        
        scanner.close();
    }
}
