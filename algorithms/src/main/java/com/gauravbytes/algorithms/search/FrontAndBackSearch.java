package com.gauravbytes.algorithms.search;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@linkplain https://lineofcode.in}
 *
 */
public class FrontAndBackSearch {
	public int search(final int[] arr, final int elementToSearch) {
		if (arr.length == 1 && elementToSearch == arr[0])
			return 0;

		int front = 0, back = arr.length - 1;
		while (front <= back) {
			if (elementToSearch == arr[front])
				return front;

			if (elementToSearch == arr[back])
				return back;

			front++;
			back--;
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 20, 10, 10 };
		int elementToSearch = 10;
		System.out.println("Element found at index: " + new FrontAndBackSearch().search(arr, elementToSearch));
	}
}
