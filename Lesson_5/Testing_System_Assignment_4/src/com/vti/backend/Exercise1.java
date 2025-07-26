package com.vti.backend;

import java.time.LocalDate;
import com.vti.entity.*;

public class Exercise1 {
    
    // Question 1: Tạo constructor cho Department
    public void question1() {
        System.out.println("=== Question 1: Department Constructors ===");
        
        // a) Constructor không có parameters
        var dept1 = new Department();
        dept1.setName("IT Department");
        System.out.println("Department 1: " + dept1);
        
        // b) Constructor có 1 parameter nameDepartment, default id = 0
        var dept2 = new Department("Marketing Department");
        System.out.println("Department 2: " + dept2);
        System.out.println();
    }
    
    // Question 2: Tạo constructor cho Account
    public void question2() {
        System.out.println("=== Question 2: Account Constructors ===");
        
        // a) Constructor không có parameters
        var acc1 = new Account();
        acc1.setUsername("user1");
        System.out.println("Account 1: " + acc1.getUsername());
        
        // b) Constructor với id, email, username, firstName, lastName
        var acc2 = new Account(1, "john@email.com", "john_doe", "John", "Doe");
        System.out.println("Account 2: " + acc2.getFullName());
        
        // c) Constructor với thêm Position, default createDate = now
        var position = new Position(1, Position.PositionName.Dev);
        var acc3 = new Account(2, "jane@email.com", "jane_doe", "Jane", "Doe", position);
        System.out.println("Account 3: " + acc3.getFullName() + " - " + acc3.getCreateDate());
        
        // d) Constructor với thêm Position và createDate
        var customDate = LocalDate.of(2023, 1, 15);
        var acc4 = new Account(3, "bob@email.com", "bob_smith", "Bob", "Smith", position, customDate);
        System.out.println("Account 4: " + acc4.getFullName() + " - " + acc4.getCreateDate());
        System.out.println();
    }
    
    // Question 3: Tạo constructor cho Group
    public void question3() {
        System.out.println("=== Question 3: Group Constructors ===");
        
        // a) Constructor không có parameters
        var group1 = new Group();
        group1.setName("Empty Group");
        System.out.println("Group 1: " + group1.getName());
        
        // b) Constructor với GroupName, Creator, Account[] accounts, CreateDate
        var creator = new Account(1, "admin@email.com", "admin", "Admin", "User");
        var accounts = new Account[]{
            new Account(2, "user1@email.com", "user1", "User", "One"),
            new Account(3, "user2@email.com", "user2", "User", "Two")
        };
        var group2 = new Group("Development Team", creator, accounts, LocalDate.now());
        System.out.println("Group 2: " + group2.getName() + " with " + group2.getAccounts().length + " members");
        
        // c) Constructor với GroupName, Creator, String[] usernames, CreateDate
        var usernames = new String[]{"alice", "bob", "charlie"};
        var group3 = new Group("Test Team", creator, usernames, LocalDate.now());
        System.out.println("Group 3: " + group3.getName() + " with usernames:");
        for (var account : group3.getAccounts()) {
            System.out.println("  - " + account.getUsername());
        }
        System.out.println();
    }
}