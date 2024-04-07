package cc.gaurav.sort;

import java.util.Arrays;

public class MergeSort {
	public void sort(int[] unsorted) {
		mergeSort(unsorted, 0, unsorted.length);
	}
	
	private void mergeSort(int[] elements, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;
			mergeSort(elements, start, mid);
			mergeSort(elements, mid + 1, end);
			
			merge(elements, start, mid, end);
		}
	}
	
	private void merge(int[] elements, int start, int mid, int end) {
		
		int[] left = new int[ mid + 1 - start];
		int[] right = new int[end - mid];
		
		for (int i = 0; i < left.length; i++) {
		  left[i] = elements[start + i];	
		}
		
		for (int i = 0; i < right.length; i++) {
			right[i] = elements[mid + i];
		}
		
		int m = 0;
		int n = 0;
		
		int k = start;
		while(m < left.length && n < right.length) {
			if (left[m] <= right[n]) {
				elements[k++] = left[m++];
			} else {
				elements[k++] = right[n++];
			}
		}
		
		while(m < left.length) {
			elements[k++] = left[m++];
		}
		
		while(n < right.length) {
			elements[k++] = right[n++];
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {1, 10, 2, 20, 1, 5, 6, 87, 12};
		new MergeSort().sort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
