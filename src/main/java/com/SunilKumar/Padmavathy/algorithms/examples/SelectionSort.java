package com.SunilKumar.Padmavathy.algorithms.examples;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class SelectionSort {
	public static void main(String[] args) {

		//List<Integer> unsortedList = new LinkedList<Integer>(Arrays.asList(23, 3, 56, 799, 10, 1, 190));
		List<Integer> unsortedList = new LinkedList<Integer>(Arrays.asList(190,-23, 3, -56, 7, 10, 0));
		System.out.println("Time start WITHOUT stream-->" + LocalDateTime.now());
		System.out.println("sorted List WITHOUT stream -->" + sort(unsortedList));
		System.out.println("\n\nTime end WITHOUT stream ---->" + LocalDateTime.now() + "\nTime Start WITH Stream-->"
				+ LocalDateTime.now());
		System.out.println("available number of cores-->" + Runtime.getRuntime().availableProcessors());
		sort(unsortedList).stream().forEach(System.out::println);
		System.out.println("Time end WITH Steam---->" + LocalDateTime.now());
	}

	private static Set<Integer> sort(List<Integer> inputList) {
		List<Integer> innerList = new ArrayList<>(inputList);
		Set<Integer> sortedSet = new LinkedHashSet<>();

		for (Integer outerLoopElement : inputList) {
			System.out.println("inputList-->" + inputList);
			System.out.println("\ninside outerLoop " + outerLoopElement);
			Integer lowestValue = outerLoopElement;
			System.out.println("innerList--> " + innerList);
			for (Integer innerLoopElement : innerList) {
				if (innerLoopElement < outerLoopElement) {
					System.out.println("inside innerLoop " + innerLoopElement);
					if (innerLoopElement <= lowestValue) {
						lowestValue = innerLoopElement;
						System.out.println("lowest value set " + lowestValue);
					}

				}

			}
			if (outerLoopElement >= lowestValue) {
				sortedSet.add(lowestValue);
				System.out.println("sortedSet value ----->" + sortedSet);
				innerList.remove(lowestValue);
				System.out.println("final inner list -->" + innerList);
			}

		}

		if (innerList.size() > 1) {
			sortedSet.addAll(sort(innerList));

		} else {
			sortedSet.addAll(innerList);

		}

		return sortedSet;
	}

}
