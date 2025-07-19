package com.vti;

import java.util.Arrays;
import java.util.Scanner;

public class Exercise1 {
	public static void main(String[] args) {
		var scanner = new Scanner(System.in);

		System.out.print("Enter number of elements: ");
		var n = scanner.nextInt();
		var arr = new int[n];

		System.out.println("""
				Enter array elements:""");
		for (int i = 0; i < n; i++) {
			System.out.printf("Element %d: ", i + 1);
			arr[i] = scanner.nextInt();
		}

		System.out.println("""

				Bubble Sort Process:""");
		bubbleSort(arr);

		System.out.printf("%nFinal sorted array: %s%n", Arrays.toString(arr));

		scanner.close();
	}

	private static void bubbleSort(int[] arr) {
		var n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			System.out.printf("Pass %d:%n", i + 1);
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					var temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			System.out.println(Arrays.toString(arr));
		}
	}
}
