package com.vti.entity;

public class BankAccount {
    private String id;
    private String name;
    private int balance;
    
    public BankAccount(String id, String name, int balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }
    
    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public int getBalance() {
        return balance;
    }
    
    // Nạp tiền
    public void credit(int amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Đã nạp " + amount + " vào tài khoản " + id + ". Số dư hiện tại: " + balance);
        } else {
            System.out.println("Số tiền nạp phải lớn hơn 0!");
        }
    }
    
    // Rút tiền
    public boolean debit(int amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Đã rút " + amount + " từ tài khoản " + id + ". Số dư hiện tại: " + balance);
            return true;
        } else if (amount > balance) {
            System.out.println("Không đủ số dư! Số dư hiện tại: " + balance);
            return false;
        } else {
            System.out.println("Số tiền rút phải lớn hơn 0!");
            return false;
        }
    }
    
    // Chuyển tiền
    public boolean transferTo(BankAccount account, int amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            account.balance += amount;
            System.out.println("Đã chuyển " + amount + " từ " + this.id + " sang " + account.id);
            System.out.println("Số dư tài khoản " + this.id + ": " + this.balance);
            System.out.println("Số dư tài khoản " + account.id + ": " + account.balance);
            return true;
        } else if (amount > balance) {
            System.out.println("Không đủ số dư để chuyển! Số dư hiện tại: " + balance);
            return false;
        } else {
            System.out.println("Số tiền chuyển phải lớn hơn 0!");
            return false;
        }
    }
    
    @Override
    public String toString() {
        return "BankAccount{id='" + id + "', name='" + name + "', balance=" + balance + "}";
    }
}