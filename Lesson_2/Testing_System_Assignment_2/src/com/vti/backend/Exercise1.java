package com.vti.backend;

import java.time.LocalDate;
import com.vti.entity.*;

public class Exercise1 {
    // Sample data
    private static Account[] accounts;
    private static Department[] departments;
    private static Group[] groups;
    
    static {
        initSampleData();
    }
    
    private static void initSampleData() {
        // Create departments
        departments = new Department[] {
            new Department(1, "Sale"),
            new Department(2, "Marketing"), 
            new Department(3, "IT")
        };
        
        // Create groups
        groups = new Group[] {
            new Group(1, "Java Fresher", null, LocalDate.now()),
            new Group(2, "C# Fresher", null, LocalDate.now()),
            new Group(3, "Testing Team", null, LocalDate.now())
        };
        
        // Create accounts
        accounts = new Account[] {
            new Account(1, "nguyenvana@gmail.com", "userA", "Nguyen Van A", departments[0], 
                       new Position(1, Position.PositionName.Dev), LocalDate.now()),
            new Account(2, "nguyenvanb@gmail.com", "userB", "Nguyen Van B", null, 
                       new Position(2, Position.PositionName.Test), LocalDate.now()),
            new Account(3, "nguyenvanc@gmail.com", "userC", "Nguyen Van C", departments[1], 
                       new Position(3, Position.PositionName.PM), LocalDate.now())
        };
        
        // Set groups for accounts
        accounts[1].setGroups(new Group[] {groups[0], groups[1], groups[2]});
        groups[0].setAccounts(new Account[] {accounts[0], accounts[1]});
    }
    
    // Question 1: Check department of account 2
    public static void question1() {
        var account2 = accounts[1];
        if (account2.getDepartment() == null) {
            System.out.println("Nhân viên này chưa có phòng ban");
        } else {
            System.out.println("Phòng ban của nhân viên này là " + account2.getDepartment().getName());
        }
    }
    
    // Question 2: Check groups of account 2
    public static void question2() {
        var account2 = accounts[1];
        var userGroups = account2.getGroups();
        
        if (userGroups == null || userGroups.length == 0) {
            System.out.println("Nhân viên này chưa có group");
        } else if (userGroups.length <= 2) {
            System.out.println("Group của nhân viên này là Java Fresher, C# Fresher");
        } else if (userGroups.length == 3) {
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        } else {
            System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");
        }
    }
    
    // Question 3: Ternary operator for Question 1
    public static void question3() {
        var account2 = accounts[1];
        var result = (account2.getDepartment() == null) 
            ? "Nhân viên này chưa có phòng ban" 
            : "Phòng ban của nhân viên này là " + account2.getDepartment().getName();
        System.out.println(result);
    }
    
    // Question 4: Ternary operator for position check
    public static void question4() {
        var account1 = accounts[0];
        var result = (account1.getPosition().getName() == Position.PositionName.Dev) 
            ? "Đây là Developer" 
            : "Người này không phải là Developer";
        System.out.println(result);
    }
    
    // Question 5: Switch expression for group member count
    public static void question5() {
        var memberCount = groups[0].getAccounts().length;
        var result = switch (memberCount) {
            case 1 -> "Nhóm có một thành viên";
            case 2 -> "Nhóm có hai thành viên";
            case 3 -> "Nhóm có ba thành viên";
            default -> "Nhóm có nhiều thành viên";
        };
        System.out.println(result);
    }
    
    // Question 6: Switch expression for Question 2
    public static void question6() {
        var account2 = accounts[1];
        var userGroups = account2.getGroups();
        var groupCount = (userGroups == null) ? 0 : userGroups.length;
        
        var result = switch (groupCount) {
            case 0 -> "Nhân viên này chưa có group";
            case 1, 2 -> "Group của nhân viên này là Java Fresher, C# Fresher";
            case 3 -> "Nhân viên này là người quan trọng, tham gia nhiều group";
            default -> "Nhân viên này là người hóng chuyện, tham gia tất cả các group";
        };
        System.out.println(result);
    }
    
    // Question 7: Switch expression for Question 4
    public static void question7() {
        var account1 = accounts[0];
        var position = account1.getPosition().getName();
        
        var result = switch (position) {
            case Dev -> "Đây là Developer";
            default -> "Người này không phải là Developer";
        };
        System.out.println(result);
    }
    
    // Question 8: Foreach - Print account info
    public static void question8() {
        for (Account account : accounts) {
            var deptName = (account.getDepartment() == null) ? "Chưa có phòng ban" : account.getDepartment().getName();
            System.out.printf("Email: %s, FullName: %s, Department: %s%n", 
                            account.getEmail(), account.getFullName(), deptName);
        }
    }
    
    // Question 9: Foreach - Print department info
    public static void question9() {
        for (Department dept : departments) {
            System.out.printf("ID: %d, Name: %s%n", dept.getId(), dept.getName());
        }
    }
    
    // Question 10: For loop with format
    public static void question10() {
        for (int i = 0; i < accounts.length; i++) {
            var account = accounts[i];
            var deptName = (account.getDepartment() == null) ? "Chưa có phòng ban" : account.getDepartment().getName();
            
            System.out.println("""
                Thông tin account thứ %d là:
                Email: %s
                Full name: %s
                Phòng ban: %s
                """.formatted(i + 1, account.getEmail(), account.getFullName(), deptName));
        }
    }
    
    // Question 11: For loop departments with format
    public static void question11() {
        for (int i = 0; i < departments.length; i++) {
            System.out.println("""
                Thông tin department thứ %d là:
                Id: %d
                Name: %s
                """.formatted(i + 1, departments[i].getId(), departments[i].getName()));
        }
    }
    
    // Question 12: Print first 2 departments
    public static void question12() {
        for (int i = 0; i < 2 && i < departments.length; i++) {
            System.out.println("""
                Thông tin department thứ %d là:
                Id: %d
                Name: %s
                """.formatted(i + 1, departments[i].getId(), departments[i].getName()));
        }
    }
    
    // Question 13: Print all accounts except account 2
    public static void question13() {
        for (int i = 0; i < accounts.length; i++) {
            if (i != 1) { // Skip account 2 (index 1)
                var account = accounts[i];
                var deptName = (account.getDepartment() == null) ? "Chưa có phòng ban" : account.getDepartment().getName();
                System.out.printf("Email: %s, FullName: %s, Department: %s%n", 
                                account.getEmail(), account.getFullName(), deptName);
            }
        }
    }
    
    // Question 14: Print accounts with id < 4
    public static void question14() {
        for (Account account : accounts) {
            if (account.getId() < 4) {
                var deptName = (account.getDepartment() == null) ? "Chưa có phòng ban" : account.getDepartment().getName();
                System.out.printf("Email: %s, FullName: %s, Department: %s%n", 
                                account.getEmail(), account.getFullName(), deptName);
            }
        }
    }
    
    // Question 15: Print even numbers <= 20
    public static void question15() {
        for (int i = 2; i <= 20; i += 2) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    
    // Question 16: While loops for questions 10-15
    public static void question16() {
        System.out.println("""
            === Question 16: While loops ===
            
            Question 10 with while:
            """);
        
        int i = 0;
        while (i < accounts.length) {
            var account = accounts[i];
            var deptName = (account.getDepartment() == null) ? "Chưa có phòng ban" : account.getDepartment().getName();
            
            System.out.println("""
                Thông tin account thứ %d là:
                Email: %s
                Full name: %s
                Phòng ban: %s
                """.formatted(i + 1, account.getEmail(), account.getFullName(), deptName));
            i++;
        }
        
        System.out.println("""
            
            Question 11 with while:
            """);
        i = 0;
        while (i < departments.length) {
            System.out.println("""
                Thông tin department thứ %d là:
                Id: %d
                Name: %s
                """.formatted(i + 1, departments[i].getId(), departments[i].getName()));
            i++;
        }
        
        System.out.println("""
            
            Question 12 with while:
            """);
        i = 0;
        while (i < 2 && i < departments.length) {
            System.out.println("""
                Thông tin department thứ %d là:
                Id: %d
                Name: %s
                """.formatted(i + 1, departments[i].getId(), departments[i].getName()));
            i++;
        }
        
        System.out.println("""
            
            Question 13 with while:
            """);
        i = 0;
        while (i < accounts.length) {
            if (i != 1) {
                var account = accounts[i];
                var deptName = (account.getDepartment() == null) ? "Chưa có phòng ban" : account.getDepartment().getName();
                System.out.printf("Email: %s, FullName: %s, Department: %s%n", 
                                account.getEmail(), account.getFullName(), deptName);
            }
            i++;
        }
        
        System.out.println("""
            
            Question 14 with while:
            """);
        i = 0;
        while (i < accounts.length) {
            if (accounts[i].getId() < 4) {
                var account = accounts[i];
                var deptName = (account.getDepartment() == null) ? "Chưa có phòng ban" : account.getDepartment().getName();
                System.out.printf("Email: %s, FullName: %s, Department: %s%n", 
                                account.getEmail(), account.getFullName(), deptName);
            }
            i++;
        }
        
        System.out.println("""
            
            Question 15 with while:
            """);
        i = 2;
        while (i <= 20) {
            System.out.print(i + " ");
            i += 2;
        }
        System.out.println();
    }
    
    // Question 17: Do-while loops for questions 10-15
    public static void question17() {
        System.out.println("""
            === Question 17: Do-while loops ===
            
            Question 10 with do-while:
            """);
        
        int i = 0;
        if (accounts.length > 0) {
            do {
                var account = accounts[i];
                var deptName = (account.getDepartment() == null) ? "Chưa có phòng ban" : account.getDepartment().getName();
                
                System.out.println("""
                    Thông tin account thứ %d là:
                    Email: %s
                    Full name: %s
                    Phòng ban: %s
                    """.formatted(i + 1, account.getEmail(), account.getFullName(), deptName));
                i++;
            } while (i < accounts.length);
        }
        
        System.out.println("""
            
            Question 11 with do-while:
            """);
        i = 0;
        if (departments.length > 0) {
            do {
                System.out.println("""
                    Thông tin department thứ %d là:
                    Id: %d
                    Name: %s
                    """.formatted(i + 1, departments[i].getId(), departments[i].getName()));
                i++;
            } while (i < departments.length);
        }
        
        System.out.println("""
            
            Question 12 with do-while:
            """);
        i = 0;
        if (departments.length > 0) {
            do {
                System.out.println("""
                    Thông tin department thứ %d là:
                    Id: %d
                    Name: %s
                    """.formatted(i + 1, departments[i].getId(), departments[i].getName()));
                i++;
            } while (i < 2 && i < departments.length);
        }
        
        System.out.println("""
            
            Question 13 with do-while:
            """);
        i = 0;
        if (accounts.length > 0) {
            do {
                if (i != 1) {
                    var account = accounts[i];
                    var deptName = (account.getDepartment() == null) ? "Chưa có phòng ban" : account.getDepartment().getName();
                    System.out.printf("Email: %s, FullName: %s, Department: %s%n", 
                                    account.getEmail(), account.getFullName(), deptName);
                }
                i++;
            } while (i < accounts.length);
        }
        
        System.out.println("""
            
            Question 14 with do-while:
            """);
        i = 0;
        if (accounts.length > 0) {
            do {
                if (accounts[i].getId() < 4) {
                    var account = accounts[i];
                    var deptName = (account.getDepartment() == null) ? "Chưa có phòng ban" : account.getDepartment().getName();
                    System.out.printf("Email: %s, FullName: %s, Department: %s%n", 
                                    account.getEmail(), account.getFullName(), deptName);
                }
                i++;
            } while (i < accounts.length);
        }
        
        System.out.println("""
            
            Question 15 with do-while:
            """);
        i = 2;
        do {
            System.out.print(i + " ");
            i += 2;
        } while (i <= 20);
        System.out.println();
    }
}