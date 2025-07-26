package com.vti.entity;

public class MyMath {
    
    // Overloaded sum methods cho các kiểu dữ liệu khác nhau
    public int sum(int a, int b) {
        System.out.println("Tổng 2 số int: " + a + " + " + b);
        return a + b;
    }
    
    public byte sum(byte a, byte b) {
        System.out.println("Tổng 2 số byte: " + a + " + " + b);
        return (byte)(a + b);
    }
    
    public float sum(float a, float b) {
        System.out.println("Tổng 2 số float: " + a + " + " + b);
        return a + b;
    }
    
    public double sum(double a, double b) {
        System.out.println("Tổng 2 số double: " + a + " + " + b);
        return a + b;
    }
    
    public long sum(long a, long b) {
        System.out.println("Tổng 2 số long: " + a + " + " + b);
        return a + b;
    }
}
