package com.vti.backend;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import com.vti.entity.*;

public class Exercise3 {
    
    private static Exam getSampleExam() {
        var dept = new Department(1, "IT");
        var creator = new Account(1, "admin@company.com", "admin", "Administrator", 
                                    dept, new Position(1, Position.PositionName.PM), LocalDate.now());
        
        return new Exam(1, "JAVA_001", "Java Basic Exam", null, 60, creator, 
                       LocalDate.of(2024, 3, 15));
    }
    
    // Question 1: Format exam create date in Vietnamese
    public static void question1() {
        var exam = getSampleExam();
        var vietnameseFormatter = DateTimeFormatter.ofPattern("dd 'tháng' MM 'năm' yyyy", 
                                                                           Locale.of("vi", "VN"));
        System.out.printf("Exam: %s, Create Date: %s%n", 
                         exam.getTitle(), 
                         exam.getCreateDate().format(vietnameseFormatter));
    }
    
    // Question 2: Format date as Year-Month-Day-Hour-Minute-Second
    public static void question2() {
        var exam = getSampleExam();
        // Since LocalDate doesn't have time, we'll show date only
        var formatter = DateTimeFormatter.ofPattern("yyyy -- MM -- dd");
        System.out.printf("Exam created: %s%n", exam.getCreateDate().format(formatter));
    }
    
    // Question 3: Print only year
    public static void question3() {
        var exam = getSampleExam();
        var year = exam.getCreateDate().getYear();
        System.out.printf("Year: %d%n", year);
    }
    
    // Question 4: Print month and year
    public static void question4() {
        var exam = getSampleExam();
        var formatter = DateTimeFormatter.ofPattern("MM/yyyy");
        System.out.printf("Month/Year: %s%n", exam.getCreateDate().format(formatter));
    }
    
    // Question 5: Print MM-DD format
    public static void question5() {
        var exam = getSampleExam();
        var formatter = DateTimeFormatter.ofPattern("MM-dd");
        System.out.printf("MM-DD: %s%n", exam.getCreateDate().format(formatter));
    }
}