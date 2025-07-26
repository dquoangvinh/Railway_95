package com.vti.frontend;

import com.vti.backend.Exercise5;
import com.vti.entity.Department;

public class Program5 {
    public static void main(String[] args) {
        System.out.println("=== EXERCISE 5: OBJECT'S METHOD ===\n");
        
        // Tạo dữ liệu test
        var departments = new Department[]{
            new Department(1, "Phòng A"),
            new Department(2, "Phòng B"),
            new Department(3, "Marketing"),
            new Department(4, "Sale")
        };
        
        System.out.println("Question 1 - Thông tin phòng ban thứ 1:");
        Exercise5.question1(departments);
        
        System.out.println("\nQuestion 2 - Thông tin tất cả phòng ban:");
        Exercise5.question2(departments);
        
        System.out.println("\nQuestion 3 - Địa chỉ phòng ban thứ 1:");
        Exercise5.question3(departments);
        
        System.out.println("\nQuestion 4 - Kiểm tra tên phòng ban thứ 1:");
        Exercise5.question4(departments);
        
        System.out.println("\nQuestion 5 - So sánh 2 phòng ban:");
        Exercise5.question5(departments);
        
        System.out.println("\nQuestion 6 - Sắp xếp phòng ban tăng dần:");
        Exercise5.question6();
        
        System.out.println("\nQuestion 7 - Sắp xếp trên 1 dòng:");
        Exercise5.question7();
    }
}
