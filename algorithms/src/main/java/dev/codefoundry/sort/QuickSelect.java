package dev.codefoundry.sort;

import java.util.Arrays;

public class QuickSelect {
	private int quickSelect(int[] nums, int k) {
		int start = 0, end = nums.length - 1;
        while (start < end) {
            int pivot = partition(nums, start, end);
            if (pivot < k) start = pivot + 1; 
            else if (pivot > k) end = pivot - 1;
            else return nums[pivot];
        }
        return nums[start];
    }
    
	private int partition(int[] nums, int start, int end) {
        int pivot = start, temp;
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot]) start++;
            while (start <= end && nums[end] > nums[pivot]) end--;
            if (start > end) break;
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        temp = nums[end];
        nums[end] = nums[pivot];
        nums[pivot] = temp;
        return end;
    }
    
    public static void main(String[] args) {
		QuickSelect s = new QuickSelect();
		int[] nums = new int[] { 5, 3, 8, 2, 0};
		System.out.println(s.quickSelect(nums, 2));
		System.out.println(Arrays.toString(nums));
	}
}
