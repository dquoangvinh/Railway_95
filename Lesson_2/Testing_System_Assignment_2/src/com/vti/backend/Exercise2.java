package com.vti.backend;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.entity.Position;

public class Exercise2 {

	// Question 1: Print integer using printf
	public static void question1() {
		var number = 5;
		System.out.printf("Number: %d%n", number);
	}

	// Question 2: Format large number with commas
	public static void question2() {
		var number = 100000000;
		System.out.printf("Formatted number: %,d%n", number);
	}

	// Question 3: Format float with 4 decimal places
	public static void question3() {
		var number = 5.567098;
		System.out.printf("Formatted float: %.4f%n", number);
	}

	// Question 4: Format student name
	public static void question4() {
		var firstName = "Nguyễn Văn A";
		System.out.printf("Tên tôi là \"%s\" và tôi đang độc thân.%n", firstName);
	}

	// Question 5: Format current date and time
	public static void question5() {
		var now = LocalDateTime.now();
		var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH'h':mm'p':ss's'");
		System.out.printf("Current time: %s%n", now.format(formatter));
	}

	// Question 6: Format account info as table
	public static void question6() {
		// Sample data
		var accounts = getSampleAccounts();

		// Print table header
		System.out.printf("""
			%-20s %-25s %-15s
			================================================================
			""", "Email", "Full Name", "Department");

		// Print account data
		for (Account account : accounts) {
			var deptName = (account.getDepartment() == null) ? "No Department" : account.getDepartment().getName();
			System.out.printf("%-20s %-25s %-15s%n", account.getEmail(), account.getFullName(), deptName);
		}
	}

	private static Account[] getSampleAccounts() {
		var departments = new Department[] { new Department(1, "Sale"), new Department(2, "Marketing") };

		return new Account[] {
				new Account(1, "nguyenvana@gmail.com", "userA", "Nguyen Van A", departments[0],
						new Position(1, Position.PositionName.Dev), java.time.LocalDate.now()),
				new Account(2, "nguyenvanb@gmail.com", "userB", "Nguyen Van B", null,
						new Position(2, Position.PositionName.Test), java.time.LocalDate.now()),
				new Account(3, "nguyenvanc@gmail.com", "userC", "Nguyen Van C", departments[1],
						new Position(3, Position.PositionName.PM), java.time.LocalDate.now()) };
	}
}