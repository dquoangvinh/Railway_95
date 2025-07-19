package com.vti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Exercise2 {
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);
		var list = new ArrayList<Integer>();

		System.out.println("""
				Enter array elements:""");
		while (true) {
			System.out.print("Enter value: ");
			list.add(scanner.nextInt());

			System.out.print("Continue? (Y/N): ");
			var choice = scanner.next().toUpperCase();

			var shouldContinue = switch (choice) {
			case "Y" -> true;
			case "N" -> false;
			default -> {
				System.out.println("Invalid choice, assuming N");
				yield false;
			}
			};

			if (!shouldContinue)
				break;
		}

		var arr = list.stream().mapToInt(i -> i).toArray();

		System.out.println("""

				Selection Sort Process:""");
		selectionSort(arr);

		System.out.printf("%nFinal sorted array: %s%n", Arrays.toString(arr));

		scanner.close();
	}

	private static void selectionSort(int[] arr) {
		var n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			var minIndex = i;

			// Tìm phần tử nhỏ nhất trong mảng chưa sắp xếp
			// j = i + 1: Bỏ qua phần đã sắp xếp, chỉ tìm trong phần chưa sắp xếp
			// j < n: Kiểm tra đến hết mảng để tìm phần tử nhỏ nhất
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}

			// Swap với phần tử đầu tiên của phần chưa sắp xếp
			var temp = arr[minIndex];
			arr[minIndex] = arr[i];
			arr[i] = temp;

			System.out.printf("Step %d: %s%n", i + 1, Arrays.toString(arr));
			// Tiếp tục với phần còn lại
		}
	}
}
// [64, 25, 12, 22, 11]