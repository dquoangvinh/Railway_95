package com.vti.backend;

import java.time.LocalDate;
import com.vti.entity.*;

public class Exercise6 {
    
    // Question 1: Method to print even positive integers < 10
    public static void printEvenPositiveNumbersLessThan10() {
        System.out.println("""
            === QUESTION 1 ===
            Các số chẵn nguyên dương nhỏ hơn 10:
            """);
        
        for (int i = 2; i < 10; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    // Question 2: Method to print account information
    public static void printAccountInfo() {
        var accounts = getSampleAccounts();
        
        System.out.println("""
            === QUESTION 2 ===
            Thông tin các account:
            """);
        
        for (Account account : accounts) {
            var deptName = (account.getDepartment() == null) ? "Chưa có phòng ban" : account.getDepartment().getName();
            System.out.printf("Email: %s, FullName: %s, Department: %s%n", 
                            account.getEmail(), account.getFullName(), deptName);
        }
    }
    
    // Question 3: Method to print positive integers < 10
    public static void printPositiveNumbersLessThan10() {
        System.out.println("""
            === QUESTION 3 ===
            Các số nguyên dương nhỏ hơn 10:
            """);
        
        for (int i = 1; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    // Helper method to get sample accounts
    private static Account[] getSampleAccounts() {
        var departments = new Department[] {
            new Department(1, "Sale"),
            new Department(2, "Marketing"),
            new Department(3, "IT")
        };
        
        return new Account[] {
            new Account(1, "nguyenvana@gmail.com", "userA", "Nguyen Van A", departments[0], 
                       new Position(1, Position.PositionName.Dev), LocalDate.now()),
            new Account(2, "nguyenvanb@gmail.com", "userB", "Nguyen Van B", null, 
                       new Position(2, Position.PositionName.Test), LocalDate.now()),
            new Account(3, "nguyenvanc@gmail.com", "userC", "Nguyen Van C", departments[1], 
                       new Position(3, Position.PositionName.PM), LocalDate.now())
        };
    }
}