package com.gauravbytes.algorithms.array.rotation;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class TimeComplexityNoSpaceComplexity implements ArrayRotation {
	@Override
	public int[] rotate(int[] arr, int distance, int length) {
		for (int i = 0; i < distance; i++) {
			leftRotate(arr, length);
		}
		return arr;
	}
	
	public void leftRotate(int[] arr, int arraySize) {
		int i, temp = arr[0];
		
		for (i = 0; i < arraySize - 1; i++) {
			arr[i] = arr[i + 1];
		}
		arr[i] = temp;
	}
}