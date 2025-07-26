package com.vti.frontend;

import com.vti.backend.Exercise4;

public class Program4 {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 4: STRING ===\n");
        
        System.out.println("Demo một số questions từ Exercise4:\n");
        
        // Demo question 10
        System.out.println("Question 10 - Kiểm tra chuỗi đảo ngược:");
        var result10 = Exercise4.question10("word", "drow");
        System.out.println("'word' và 'drow' là đảo ngược: " + (result10 ? "OK" : "KO"));
        
        // Demo question 11
        System.out.println("\nQuestion 11 - Đếm ký tự 'a':");
        var count = Exercise4.question11("banana", 'a');
        System.out.println("Số lần xuất hiện 'a' trong 'banana': " + count);
        
        // Demo question 12
        System.out.println("\nQuestion 12 - Đảo ngược chuỗi:");
        var reversed = Exercise4.question12("Hello World");
        System.out.println("'Hello World' đảo ngược: " + reversed);
        
        // Demo question 13
        System.out.println("\nQuestion 13 - Kiểm tra không chứa số:");
        System.out.println("'abc' không chứa số: " + Exercise4.question13("abc"));
        System.out.println("'abc1' không chứa số: " + Exercise4.question13("abc1"));
        
        // Demo question 15
        System.out.println("\nQuestion 15 - Đảo ngược theo từ:");
        var wordReversed = Exercise4.question15("I am developer");
        System.out.println("'I am developer' đảo ngược theo từ: " + wordReversed);
        
        // Demo question 16
        System.out.println("\nQuestion 16 - Chia chuỗi:");
        Exercise4.question16("123456", 2);
        
        System.out.println("\nCác question khác yêu cầu input từ user, chạy riêng để test!");
    }
}
