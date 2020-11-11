package dev.codefoundry.list;

/**
 * 
 * @author Gaurav Rai Mazra {@link https://codefoundry.dev}
 *
 *         Count occurrences of target in sorted array
 */
public class CountOccurrences {
	public int linearTimeSolve(int[] nums, int target) {
		int count = 0;
		for (int num : nums) {
			if (num == target) count++;
			else if (num > target) break;
		}
		return count;
	}
	
	public int logNSolve(int[] nums, int target) {
		int floor = floorKey(nums, target);
		int ceil = ceilKey(nums, target);
		return ceil - floor;
	}
	
	private int floorKey(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int mid;
		while(left < right) {
			mid = left + (right - left) / 2;
			if (nums[mid] >= target) {
				right = mid;
			} else {
				left += 1;
			}
		}
		
		return left;
	}
	
	private int ceilKey(int[] nums, int target) {
		int left = 0;
		int right = nums.length - 1;
		int mid;
		while(left < right) {
			mid = left + (right - left) / 2;
			if (nums[mid] > target) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		
		return left;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 2, 2, 2, 2, 2, 3, 4, 5, 6, 7, 7, 7, 7, 7, 7, 7, 8 };
		System.out.println(
				new CountOccurrences().linearTimeSolve(nums, 7));
		
		System.out.println(
				new CountOccurrences().logNSolve(nums, 7));
	
	}
}
