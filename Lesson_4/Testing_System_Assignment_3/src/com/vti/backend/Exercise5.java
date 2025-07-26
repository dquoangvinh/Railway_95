package com.vti.backend;

import java.util.Arrays;
import java.util.Comparator;
import com.vti.entity.Department;

public class Exercise5 {
    
    // Question 1: In thông tin phòng ban thứ 1
    public static void question1(Department[] departments) {
        if (departments.length > 0) {
            System.out.println(departments[0].toString());
        }
    }
    
    // Question 2: In thông tin tất cả phòng ban
    public static void question2(Department[] departments) {
        Arrays.stream(departments)
            .map(Department::toString)
            .forEach(System.out::println);
    }
    
    // Question 3: In địa chỉ phòng ban thứ 1
    public static void question3(Department[] departments) {
        if (departments.length > 0) {
            System.out.println("Địa chỉ: " + departments[0].hashCode());
        }
    }
    
    // Question 4: Kiểm tra tên phòng ban thứ 1
    public static void question4(Department[] departments) {
        if (departments.length > 0) {
            var isPhongA = "Phòng A".equals(departments[0].getName());
            System.out.println("Phòng ban thứ 1 có tên là 'Phòng A': " + isPhongA);
        }
    }
    
    // Question 5: So sánh 2 phòng ban
    public static void question5(Department[] departments) {
        if (departments.length >= 2) {
            var isEqual = departments[0].getName().equals(departments[1].getName());
            System.out.println("2 phòng ban có tên giống nhau: " + isEqual);
        }
    }
    
    // Question 6: Sắp xếp phòng ban tăng dần theo tên
    public static void question6() {
        var departments = new Department[]{
            new Department(1, "Sale"),
            new Department(2, "Marketing"), 
            new Department(3, "Accounting"),
            new Department(4, "Boss of director"),
            new Department(5, "Waiting room")
        };
        
        Arrays.sort(departments, Comparator.comparing(Department::getName));
        
        System.out.println("Danh sách phòng ban theo thứ tự ABC:");
        Arrays.stream(departments)
            .map(Department::getName)
            .forEach(System.out::println);
    }
    
    // Question 7: In phòng ban trên 1 dòng
    public static void question7() {
        var departments = new Department[]{
            new Department(1, "Sale"),
            new Department(2, "Marketing"),
            new Department(3, "Accounting"), 
            new Department(4, "Boss of director"),
            new Department(5, "Waiting room")
        };
        
        Arrays.sort(departments, Comparator.comparing(Department::getName));
        
        var result = Arrays.stream(departments)
            .map(Department::getName)
            .reduce("", (a, b) -> a + (a.isEmpty() ? "" : " ") + b);
        
        System.out.println(result);
    }
}
