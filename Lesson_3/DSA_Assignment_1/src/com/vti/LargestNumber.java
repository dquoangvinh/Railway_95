package com.vti;

import java.util.Scanner;

public class LargestNumber {
	public static void main(String[] args) {
		try (var scanner = new Scanner(System.in)) {
			var numbers = new double[3];

			for (int i = 0; i < 3; i++) {
				System.out.print("Nhập số thứ " + (i + 1) + ": ");
				numbers[i] = scanner.nextDouble();
			}

			var largest = Math.max(numbers[0], Math.max(numbers[1], numbers[2]));

			System.out.println("Số lớn nhất là: " + largest);
		}
	}
}
