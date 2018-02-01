package com.gauravbytes.algorithms.array.rotation;

/**
 * 
 * @author Gaurav Rai Mazra
 *
 */
public class SpaceComplexityAlgorithm implements ArrayRotation {
	@Override
	public int[] rotate(int[] arr, int distance, int length) {
		int[] tempArr = new int[distance];
		for (int i = 0; i < distance; i++) {
			tempArr[i] = arr[i];
		}
		
		for (int i = distance; i < length; i++) {
			arr[i - distance] = arr[i];
		}
		
		for (int i = distance, j = 0; i > 0 && j < distance; i--, j++) {
			arr[length - i] = tempArr[j];
		}
		return arr;
	}	
}