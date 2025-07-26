package com.vti.frontend;

import com.vti.backend.Exercise2;
import java.util.Arrays;

public class Program2 {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 2: DEFAULT VALUE ===\n");
        
        System.out.println("Question 1:");
        var accounts = Exercise2.question1();
        
        Arrays.stream(accounts)
            .forEach(account -> System.out.printf(
                "Email: %s, Username: %s, FullName: %s, CreateDate: %s%n",
                account.getEmail(),
                account.getUsername(), 
                account.getFullName(),
                account.getCreateDate()
            ));
    }
}
