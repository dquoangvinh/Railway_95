package com.vti.backend;

import java.time.LocalDate;
import com.vti.entity.Account;

public class Exercise2 {
    
    // Question 1: Tạo array Account với 5 phần tử
    public static Account[] question1() {
        var accounts = new Account[5];
        
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account();
            accounts[i].setEmail("Email " + (i + 1));
            accounts[i].setUsername("User name " + (i + 1));
            accounts[i].setFullName("Full name " + (i + 1));
            accounts[i].setCreateDate(LocalDate.now());
        }
        
        return accounts;
    }
}
