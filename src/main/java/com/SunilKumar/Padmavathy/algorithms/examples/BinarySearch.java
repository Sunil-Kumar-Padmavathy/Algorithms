package com.SunilKumar.Padmavathy.algorithms.examples;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class BinarySearch {

	/*Refer https://en.wikipedia.org/wiki/Binary_search_algorithm
	to learn more about binary search*/
	
	
	public static void main(String[] args) {
		Scanner scanner= new Scanner(System.in);
		System.out.println("Enter a starting number of the array");
		int startElement = scanner.nextInt();
		System.out.println("Enter a ending number of the array");
		int endingElement = scanner.nextInt();
		int[] arr = IntStream.range(startElement, endingElement+1).toArray();
		BinarySearch binarySearch = new BinarySearch();
		
		
		System.out.println(Arrays.toString((arr)));
		
		System.out.println("Enter a number: ");
		int searchElement = scanner.nextInt();
		scanner.close();
		
		binarySearch.findElement(arr,searchElement);//call method to identify the search element
	
	}
	
	int findElement(int[] inputArray, int searchElement){
		System.out.println("\nsearchElement "+searchElement);
		int leftElement=0;						//set L=0
		int rightElement=inputArray.length-1;   //set R=n-1
		int loopCount=1; // we find the middle index in the next step, hence count starts with 1
		int indexElement=  (int) getIndexElement(leftElement, rightElement); //find the middle index before starting the iteration
		System.out.println("indexElement element before while loop starts -->"+indexElement);
		while(inputArray[indexElement]!=searchElement) { // as soon as the element is found the loop quits and prints the index at which the search element was found
			System.out.println("\nStill searching....");
			if(inputArray[indexElement] < searchElement) {// if the array Element is less than search element then increment the middleElement, else decrement it
				leftElement= indexElement+1;
				indexElement=(int) getIndexElement(leftElement, rightElement);
				System.out.println("indexElement "+indexElement +" is smaller than searchelement "+searchElement);
				loopCount++;
			}
			else if(indexElement!=inputArray.length-1 && inputArray[indexElement] > searchElement){
				rightElement=indexElement-1;
				indexElement=(int) getIndexElement(leftElement, rightElement);
				System.out.println("indexElement "+indexElement +" is larger than searchelement "+searchElement);
				loopCount++;
			}
		}
		System.out.println("\nElement found at index "+indexElement);
		System.out.println("Total iterations "+loopCount);
		return indexElement;   //the index of the search element identified and being returned
	}

	private double getIndexElement(int leftElement, int rightElement) {
		System.out.println("\ngetIndexElement method with leftElement "+leftElement+" and rightElement "+rightElement);
		return Math.floor((leftElement+rightElement)/2);
	}
	
	
	   
}
