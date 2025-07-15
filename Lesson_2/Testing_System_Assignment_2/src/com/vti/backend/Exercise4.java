package com.vti.backend;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Exercise4 {
    private static Random random = new Random();
    
    // Question 1: Random integer
    public static void question1() {
        var randomInt = random.nextInt();
        System.out.printf("Random integer: %d%n", randomInt);
    }
    
    // Question 2: Random float
    public static void question2() {
        var randomDouble = random.nextDouble();
        System.out.printf("Random double: %.6f%n", randomDouble);
    }
    
    // Question 3: Random student name
    public static void question3() {
        var studentNames = new String[] {
            "Nguyen Van A", "Tran Thi B", "Le Van C", 
            "Pham Thi D", "Hoang Van E", "Vu Thi F"
        };
        
        var randomIndex = random.nextInt(studentNames.length);
        System.out.printf("Random student: %s%n", studentNames[randomIndex]);
    }
    
    // Question 4: Random date between 24-07-1995 and 20-12-1995
    public static void question4() {
        var startDate = LocalDate.of(1995, 7, 24);
        var endDate = LocalDate.of(1995, 12, 20);
        
        var daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        var randomDays = ThreadLocalRandom.current().nextLong(0, daysBetween + 1);
        
        var randomDate = startDate.plusDays(randomDays);
        System.out.printf("Random date: %s%n", randomDate);
    }
    
    // Question 5: Random date within last year
    public static void question5() {
        var today = LocalDate.now();
        var oneYearAgo = today.minusYears(1);
        
        var daysBetween = ChronoUnit.DAYS.between(oneYearAgo, today);
        var randomDays = ThreadLocalRandom.current().nextLong(0, daysBetween + 1);
        
        var randomDate = oneYearAgo.plusDays(randomDays);
        System.out.printf("Random date in last year: %s%n", randomDate);
    }
    
    // Question 6: Random date in the past
    public static void question6() {
        var today = LocalDate.now();
        var farPast = LocalDate.of(1900, 1, 1);
        
        var daysBetween = ChronoUnit.DAYS.between(farPast, today);
        var randomDays = ThreadLocalRandom.current().nextLong(0, daysBetween);
        
        var randomDate = farPast.plusDays(randomDays);
        System.out.printf("Random date in past: %s%n", randomDate);
    }
    
    // Question 7: Random 3-digit number
    public static void question7() {
        var random3Digit = random.nextInt(900) + 100; // 100-999
        System.out.printf("Random 3-digit number: %d%n", random3Digit);
    }
}