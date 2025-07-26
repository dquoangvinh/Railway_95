package com.vti.entity;

public abstract class User {
    private String name;
    private double salaryRatio;
    
    public User() {
    }
    
    public User(String name, double salaryRatio) {
        this.name = name;
        this.salaryRatio = salaryRatio;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getSalaryRatio() {
        return salaryRatio;
    }
    
    public void setSalaryRatio(double salaryRatio) {
        this.salaryRatio = salaryRatio;
    }
    
    public abstract double calculatePay();
    
    public void displayInfo() {
        System.out.println("Name: " + name + ", Salary Ratio: " + salaryRatio + ", Pay: " + calculatePay());
    }
}