package com.vti.backend;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.vti.entity.*;

public class Exercise1 {
    private static List<News> newsList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int newsIdCounter = 1;

    public static void insertNews() {
        var news = new News();
        news.setID(newsIdCounter++);
        
        System.out.print("Enter Title: ");
        news.setTitle(scanner.nextLine());
        
        System.out.print("Enter Publish Date: ");
        news.setPublishDate(scanner.nextLine());
        
        System.out.print("Enter Author: ");
        news.setAuthor(scanner.nextLine());
        
        System.out.print("Enter Content: ");
        news.setContent(scanner.nextLine());
        
        int[] rates = new int[3];
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter rate " + (i + 1) + ": ");
            rates[i] = scanner.nextInt();
        }
        scanner.nextLine(); // consume newline
        
        news.setRates(rates);
        newsList.add(news);
        System.out.println("News added successfully!");
    }

    public static void viewListNews() {
        if (newsList.isEmpty()) {
            System.out.println("No news available!");
            return;
        }
        
        for (var news : newsList) {
            System.out.println("\n--- News ID: " + news.getID() + " ---");
            news.Display();
        }
    }

    public static void calculateAndDisplayAverageRate() {
        if (newsList.isEmpty()) {
            System.out.println("No news available!");
            return;
        }
        
        for (var news : newsList) {
            news.Calculate();
            System.out.println("\n--- News ID: " + news.getID() + " ---");
            news.Display();
        }
    }

    // Question 2: Tuyển sinh system
    private static TuyenSinh tuyenSinh = new TuyenSinh();

    public static void runTuyenSinhSystem() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        
        do {
            System.out.println("\n=== HỆ THỐNG TUYỂN SINH ====");
            System.out.println("1. Thêm mới thí sinh");
            System.out.println("2. Hiện thị thông tin thí sinh");
            System.out.println("3. Tìm kiếm theo số báo danh");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1 -> tuyenSinh.themMoiThiSinh();
                case 2 -> tuyenSinh.hienThiThongTinThiSinh();
                case 3 -> tuyenSinh.timKiemTheoSoBaoDanh();
                case 4 -> System.out.println("Thoát hệ thống tuyển sinh!");
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 4);
    }
}
