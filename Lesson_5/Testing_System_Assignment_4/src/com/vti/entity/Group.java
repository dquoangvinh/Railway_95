package com.vti.entity;

import java.time.LocalDate;

public class Group {
    private int id;
    private String name;
    private Account creator;
    private LocalDate createDate;
    private Account[] accounts;

    // Constructor không có parameters
    public Group() {
    }

    // Constructor với GroupName, Creator, accounts, CreateDate
    public Group(String name, Account creator, Account[] accounts, LocalDate createDate) {
        this.name = name;
        this.creator = creator;
        this.accounts = accounts;
        this.createDate = createDate;
    }

    // Constructor với GroupName, Creator, usernames, CreateDate
    public Group(String name, Account creator, String[] usernames, LocalDate createDate) {
        this.name = name;
        this.creator = creator;
        this.createDate = createDate;
        
        // Tạo Account từ usernames (chỉ có username, các thông tin khác = null)
        this.accounts = new Account[usernames.length];
        for (int i = 0; i < usernames.length; i++) {
            this.accounts[i] = new Account();
            this.accounts[i].setUsername(usernames[i]);
        }
    }

    // Constructor gốc
    public Group(int id, String name, Account creator, LocalDate createDate) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.createDate = createDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creator=" + creator +
                ", createDate=" + createDate +
                '}';
    }
}
