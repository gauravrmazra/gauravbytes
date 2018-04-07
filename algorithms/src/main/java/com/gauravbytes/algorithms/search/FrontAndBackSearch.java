package com.gauravbytes.algorithms.search;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@linkplain https://lineofcode.in}
 *
 */
public class FrontAndBackSearch implements Search {
	public int search(final int[] arr, final int elementToSearch) {
		if (arr.length == 1 && elementToSearch == arr[0])
			return 0;

		int front = 0;
		int back = arr.length - 1;
		
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
}
