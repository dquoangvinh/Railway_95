package com.vti.entity;

public class DateCustom {
    private int day;
    private int month;
    private int year;
    
    public DateCustom(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }
    
    public int getDay() {
        return day;
    }
    
    public void setDay(int day) {
        this.day = day;
    }
    
    public int getMonth() {
        return month;
    }
    
    public void setMonth(int month) {
        this.month = month;
    }
    
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public boolean isLeapYear() {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    
    @Override
    public String toString() {
        return String.format("%02d/%02d/%d", day, month, year) + 
               (isLeapYear() ? " (Năm nhuận)" : " (Năm không nhuận)");
    }
}