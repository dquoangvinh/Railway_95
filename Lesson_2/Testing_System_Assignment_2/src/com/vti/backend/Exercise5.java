package com.vti.backend;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import com.vti.entity.*;

public class Exercise5 {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Account> accountList = new ArrayList<>();
    private static List<Department> departmentList = new ArrayList<>();
    private static List<Group> groupList = new ArrayList<>();
    
    // Question 1: Input 3 integers
    public static void question1() {
        System.out.println("Nhập 3 số nguyên:");
        for (int i = 1; i <= 3; i++) {
            System.out.printf("Số thứ %d: ", i);
            var number = scanner.nextInt();
            System.out.printf("Bạn đã nhập: %d%n", number);
        }
    }
    
    // Question 2: Input 2 floats
    public static void question2() {
        System.out.println("Nhập 2 số thực:");
        for (int i = 1; i <= 2; i++) {
            System.out.printf("Số thực thứ %d: ", i);
            var number = scanner.nextDouble();
            System.out.printf("Bạn đã nhập: %.2f%n", number);
        }
        scanner.nextLine(); // Clear buffer
    }
    
    // Question 3: Input full name
    public static void question3() {
        System.out.print("Nhập họ và tên: ");
        var fullName = scanner.nextLine();
        System.out.printf("Họ và tên của bạn là: %s%n", fullName);
    }
    
    // Question 4: Input birth date
    public static void question4() {
        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        var dateStr = scanner.nextLine();
        try {
            var birthDate = LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.printf("Ngày sinh của bạn: %s%n", birthDate);
        } catch (DateTimeParseException e) {
            System.out.println("Định dạng ngày không hợp lệ!");
        }
    }
    
    // Question 5: Create account method
    public static Account createAccount() {
        System.out.println("""
            === TẠO ACCOUNT ===
            Vui lòng nhập thông tin:
            """);
        
        System.out.print("Nhập email: ");
        var email = scanner.nextLine();
        
        System.out.print("Nhập username: ");
        var username = scanner.nextLine();
        
        System.out.print("Nhập họ tên: ");
        var fullName = scanner.nextLine();
        
        System.out.println("Chọn vị trí (1-Dev, 2-Test, 3-ScrumMaster, 4-PM): ");
        var posChoice = scanner.nextInt();
        scanner.nextLine(); // Clear buffer
        
        var posName = switch (posChoice) {
            case 1 -> Position.PositionName.Dev;
            case 2 -> Position.PositionName.Test;
            case 3 -> Position.PositionName.Scrum_Master;
            case 4 -> Position.PositionName.PM;
            default -> Position.PositionName.Dev;
        };
        
        var account = new Account();
        account.setId(accountList.size() + 1);
        account.setEmail(email);
        account.setUsername(username);
        account.setFullName(fullName);
        account.setPosition(new Position(posChoice, posName));
        account.setCreateDate(LocalDate.now());
        
        accountList.add(account);
        System.out.println("Tạo account thành công!");
        return account;
    }
    
    // Question 6: Create department method
    public static Department createDepartment() {
        System.out.println("""
            === TẠO DEPARTMENT ===
            Vui lòng nhập thông tin:
            """);
        
        System.out.print("Nhập tên phòng ban: ");
        var name = scanner.nextLine();
        
        var dept = new Department(departmentList.size() + 1, name);
        departmentList.add(dept);
        System.out.println("Tạo department thành công!");
        return dept;
    }
    
    // Question 7: Input even number
    public static void question7() {
        int number;
        do {
            System.out.print("Nhập số chẵn: ");
            number = scanner.nextInt();
            if (number % 2 != 0) {
                System.out.println("Vui lòng nhập số chẵn!");
            }
        } while (number % 2 != 0);
        System.out.printf("Số chẵn bạn nhập: %d%n", number);
        scanner.nextLine(); // Clear buffer
    }
    
    // Question 8: Main menu system
    public static void question8() {
        boolean continueProgram = true;
        
        while (continueProgram) {
            System.out.print("""
                Mời bạn nhập vào chức năng muốn sử dụng:
                1. Tạo account
                2. Tạo department
                Lựa chọn: """);
            
            var choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            
            var validChoice = switch (choice) {
                case 1 -> { createAccount(); yield true; }
                case 2 -> { createDepartment(); yield true; }
                default -> { System.out.println("Mời bạn nhập lại"); yield false; }
            };
            
            if (!validChoice) continue;
            
            System.out.print("Bạn có muốn thực hiện chức năng khác không? (y/n): ");
            String continueChoice = scanner.nextLine();
            if (!continueChoice.equalsIgnoreCase("y")) {
                continueProgram = false;
            }
        }
    }
    
    // Question 9: Add group to account
    public static void addGroupToAccount() {
        if (accountList.isEmpty()) {
            System.out.println("Chưa có account nào!");
            return;
        }
        
        if (groupList.isEmpty()) {
            System.out.println("Chưa có group nào!");
            return;
        }
        
        // Step 1: Show usernames
        System.out.println("""
            === THÊM GROUP VÀO ACCOUNT ===
            Danh sách username:
            """);
        for (Account acc : accountList) {
            System.out.println("- " + acc.getUsername());
        }
        
        // Step 2: Input username
        System.out.print("Nhập username: ");
        var username = scanner.nextLine();
        
        Account selectedAccount = null;
        for (Account acc : accountList) {
            if (acc.getUsername().equals(username)) {
                selectedAccount = acc;
                break;
            }
        }
        
        if (selectedAccount == null) {
            System.out.println("Không tìm thấy username!");
            return;
        }
        
        // Step 3: Show groups
        System.out.println("""
            Danh sách group:
            """);
        for (Group group : groupList) {
            System.out.println("- " + group.getName());
        }
        
        // Step 4: Input group name
        System.out.print("Nhập tên group: ");
        var groupName = scanner.nextLine();
        
        Group selectedGroup = null;
        for (Group group : groupList) {
            if (group.getName().equals(groupName)) {
                selectedGroup = group;
                break;
            }
        }
        
        if (selectedGroup == null) {
            System.out.println("Không tìm thấy group!");
            return;
        }
        
        // Step 5: Add account to group
        System.out.printf("Đã thêm %s vào group %s%n", 
                         selectedAccount.getUsername(), selectedGroup.getName());
    }
    
    // Question 10: Extended menu
    public static void question10() {
        // Initialize some sample groups
        groupList.add(new Group(1, "Java Team", null, LocalDate.now()));
        groupList.add(new Group(2, "Testing Team", null, LocalDate.now()));
        
        boolean continueProgram = true;
        
        while (continueProgram) {
            System.out.print("""
                Mời bạn nhập vào chức năng muốn sử dụng:
                1. Tạo account
                2. Tạo department
                3. Thêm group vào account
                Lựa chọn: """);
            
            var choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            
            var validChoice = switch (choice) {
                case 1 -> { createAccount(); yield true; }
                case 2 -> { createDepartment(); yield true; }
                case 3 -> { addGroupToAccount(); yield true; }
                default -> { System.out.println("Mời bạn nhập lại"); yield false; }
            };
            
            if (!validChoice) continue;
            
            System.out.print("Bạn có muốn thực hiện chức năng khác không? (y/n): ");
            String continueChoice = scanner.nextLine();
            if (!continueChoice.equalsIgnoreCase("y")) {
                continueProgram = false;
            }
        }
    }
    
    // Question 11: Add account to random group
    public static void addAccountToRandomGroup() {
        if (accountList.isEmpty()) {
            System.out.println("Chưa có account nào!");
            return;
        }
        
        if (groupList.isEmpty()) {
            System.out.println("Chưa có group nào!");
            return;
        }
        
        // Step 1: Show usernames
        System.out.println("""
            === THÊM ACCOUNT VÀO GROUP NGẪU NHIÊN ===
            Danh sách username:
            """);
        for (Account acc : accountList) {
            System.out.println("- " + acc.getUsername());
        }
        
        // Step 2: Input username
        System.out.print("Nhập username: ");
        var username = scanner.nextLine();
        
        Account selectedAccount = null;
        for (Account acc : accountList) {
            if (acc.getUsername().equals(username)) {
                selectedAccount = acc;
                break;
            }
        }
        
        if (selectedAccount == null) {
            System.out.println("Không tìm thấy username!");
            return;
        }
        
        // Step 3: Random select group
        var random = new Random();
        var randomGroup = groupList.get(random.nextInt(groupList.size()));
        
        // Step 4: Add account to random group
        System.out.printf("Đã thêm %s vào group ngẫu nhiên: %s%n", 
                         selectedAccount.getUsername(), randomGroup.getName());
    }
    
    public static void question11() {
        // Initialize some sample groups
        if (groupList.isEmpty()) {
            groupList.add(new Group(1, "Java Team", null, LocalDate.now()));
            groupList.add(new Group(2, "Testing Team", null, LocalDate.now()));
            groupList.add(new Group(3, "DevOps Team", null, LocalDate.now()));
        }
        
        boolean continueProgram = true;
        
        while (continueProgram) {
            System.out.print("""
                Mời bạn nhập vào chức năng muốn sử dụng:
                1. Tạo account
                2. Tạo department
                3. Thêm group vào account
                4. Thêm account vào group ngẫu nhiên
                Lựa chọn: """);
            
            var choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer
            
            var validChoice = switch (choice) {
                case 1 -> { createAccount(); yield true; }
                case 2 -> { createDepartment(); yield true; }
                case 3 -> { addGroupToAccount(); yield true; }
                case 4 -> { addAccountToRandomGroup(); yield true; }
                default -> { System.out.println("Mời bạn nhập lại"); yield false; }
            };
            
            if (!validChoice) continue;
            
            System.out.print("Bạn có muốn thực hiện chức năng khác không? (y/n): ");
            String continueChoice = scanner.nextLine();
            if (!continueChoice.equalsIgnoreCase("y")) {
                continueProgram = false;
            }
        }
    }
}