package com.SunilKumar.Padmavathy.algorithms.examples;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Stream;

public class BubbleSort {
	public static void main(String[] args) {
		// int arr[]= {-20,400,1,-11,60,5,61,1000};
		int arr[] = { 9000, -20, 72737363, 400, -38383838, 1, -11, 60, 8889, 5, 61, -73837, 0, 1000 };
		BubbleSort bubbleSort = new BubbleSort();
		
		System.out.println("Time start WITHOUT stream-->" + LocalDateTime.now()+"\n");
		System.out.println(Arrays.toString(bubbleSort.sort(arr)));
		System.out.println("\nTime end WITHOUT stream ---->" + LocalDateTime.now() + "\n\nTime Start WITH Stream-->"
				+ LocalDateTime.now());
		System.out.println("\n\navailable number of cores-->" + Runtime.getRuntime().availableProcessors());
		Stream.of(Arrays.toString(bubbleSort.sort(arr))).forEach(System.out::println);
		System.out.println("\n\nTime end WITH Stream---->" + LocalDateTime.now());
	}

	private  int[] sort(int arr[]) {
		for (int i = 0; i < arr.length - 1; i++) {
			//System.out.println("\nVALUE OF i-->" + i);
			for (int j = 0; j < arr.length - 1 - i; j++) {
				//System.out.println("VALUE OF J-->" + j);
				//System.out.println("j th element----->" + arr[j]);
				if (arr[j] > arr[j + 1]) {
					//System.out.println("j+1 th  element----->" + arr[j + 1] + " SWAPPED");
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			

		}
		return arr;
	}

}
