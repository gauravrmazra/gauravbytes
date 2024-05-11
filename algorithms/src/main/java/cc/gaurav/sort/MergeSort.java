package cc.gaurav.sort;

import java.util.Arrays;

public class MergeSort {
	public void sort(int[] unsorted) {
		divide(unsorted, 0, unsorted.length - 1);
	}
	
	private static void divide(int[] arr, int lo, int hi) {
		if (lo < hi) {
		  int mid = (lo + hi) / 2;
		  divide(arr, lo, mid);
		  divide(arr, mid + 1, hi);
		  merge(arr, lo, mid, hi);
		}
	  }
  
	  private static void merge(int[] arr, int lo, int mid, int hi) {
		int leftSize = mid - lo + 1;
		int rightSize = hi - mid;
		int[] left = new int[leftSize];
		int[] right = new int[rightSize];
  
		for(int i = 0; i < leftSize; ++i) {
		  left[i] = arr[i + lo];
		}
  
		for (int i = 0; i < rightSize; ++i) {
		  right[i] = arr[mid + 1 + i];
		}
  
		int i = 0;
		int j = 0;
		int k = lo;
  
		while(i < leftSize && j < rightSize) {
		  if (left[i] <= right[j]) {
			arr[k++] = left[i++];
		  } else {
			arr[k++] = right[j++];
		  }
		}
  
		while(i < leftSize) {
		  arr[k++] = left[i++];
		}
  
		while(j < rightSize) {
		  arr[k++] = right[j++];
		}
	  }
	
	public static void main(String[] args) {
		int[] nums = new int[] {1, 10, 2, 20, 1, 5, 6, 87,22, 3};
		new MergeSort().sort(nums);
		System.out.println(Arrays.toString(nums));
	}
}
