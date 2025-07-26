package com.vti.backend;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise4 {
    private static final Scanner scanner = new Scanner(System.in);
    
    // Question 1: Đếm số từ trong chuỗi
    public static void question1() {
        System.out.print("Nhập chuỗi: ");
        var input = scanner.nextLine().trim();
        var wordCount = input.isEmpty() ? 0 : input.split("\\s+").length;
        System.out.println("Số từ: " + wordCount);
    }
    
    // Question 2: Nối 2 chuỗi
    public static void question2() {
        System.out.print("Nhập chuỗi s1: ");
        var s1 = scanner.nextLine();
        System.out.print("Nhập chuỗi s2: ");
        var s2 = scanner.nextLine();
        System.out.println("Chuỗi sau khi nối: " + s1 + s2);
    }
    
    // Question 3: Viết hoa chữ cái đầu tên
    public static void question3() {
        System.out.print("Nhập tên: ");
        var name = scanner.nextLine().trim();
        var capitalized = name.isEmpty() ? "" : 
            Character.toUpperCase(name.charAt(0)) + name.substring(1).toLowerCase();
        System.out.println("Tên sau khi chuẩn hóa: " + capitalized);
    }
    
    // Question 4: In từng ký tự
    public static void question4() {
        System.out.print("Nhập tên: ");
        var name = scanner.nextLine();
        for (int i = 0; i < name.length(); i++) {
            System.out.printf("Ký tự thứ %d là: %c%n", i + 1, name.charAt(i));
        }
    }
    
    // Question 5: Nhập họ và tên
    public static void question5() {
        System.out.print("Nhập họ: ");
        var lastName = scanner.nextLine();
        System.out.print("Nhập tên: ");
        var firstName = scanner.nextLine();
        System.out.println("Họ và tên đầy đủ: " + lastName + " " + firstName);
    }
    
    // Question 6: Tách họ, tên đệm, tên
    public static void question6() {
        System.out.print("Nhập họ và tên đầy đủ: ");
        var fullName = scanner.nextLine().trim();
        var parts = fullName.split("\\s+");
        
        if (parts.length >= 3) {
            System.out.println("Họ là: " + parts[0]);
            System.out.println("Tên đệm là: " + String.join(" ", 
                Arrays.copyOfRange(parts, 1, parts.length - 1)));
            System.out.println("Tên là: " + parts[parts.length - 1]);
        }
    }
    
    // Question 7: Chuẩn hóa họ tên
    public static void question7() {
        System.out.print("Nhập họ và tên đầy đủ: ");
        var fullName = scanner.nextLine();
        
        // Chuẩn hóa khoảng trắng và viết hoa
        var normalized = Arrays.stream(fullName.trim().split("\\s+"))
            .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase())
            .reduce("", (a, b) -> a + (a.isEmpty() ? "" : " ") + b);
        
        System.out.println("Họ tên chuẩn hóa: " + normalized);
    }
    
    // Question 8-16: Các method khác (simplified)
    public static void question8(String[] groups) {
        Arrays.stream(groups)
            .filter(group -> group.contains("Java"))
            .forEach(System.out::println);
    }
    
    public static void question9(String[] groups) {
        Arrays.stream(groups)
            .filter("Java"::equals)
            .forEach(System.out::println);
    }
    
    public static boolean question10(String str1, String str2) {
        return str1.equals(new StringBuilder(str2).reverse().toString());
    }
    
    public static long question11(String str, char ch) {
        return str.chars().filter(c -> c == ch).count();
    }
    
    public static String question12(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    public static boolean question13(String str) {
        return str != null && str.chars().noneMatch(Character::isDigit);
    }
    
    public static String question14(String str, char oldChar, char newChar) {
        return str.replace(oldChar, newChar);
    }
    
    public static String question15(String str) {
        var words = str.trim().split("\\s+");
        var reversed = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            reversed[i] = words[words.length - 1 - i];
        }
        return String.join(" ", reversed);
    }
    
    public static void question16(String str, int n) {
        if (n <= 0 || str.length() % n != 0) {
            System.out.println("KO");
            return;
        }
        
        for (int i = 0; i < str.length(); i += n) {
            System.out.println(str.substring(i, i + n));
        }
    }
}
