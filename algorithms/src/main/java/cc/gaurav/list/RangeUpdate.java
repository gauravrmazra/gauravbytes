package cc.gaurav.list;

import java.util.Arrays;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://gaurav.cc}
 * You are given a list of integers nums and a two-dimensional list of integers operations. 
 * Each operation is of the following form: [L, R, X], which means that you should increment 
 * by X all the elements from indices L to R inclusive in the list (the list is 0-indexed).
 * Apply all operations and return the final list.
 *
 */
public class RangeUpdate {
	public int[] solve(int[] nums, int[][] operations) {
		if (operations.length == 0) {
			return nums;
		}

		int start = -1;
		int end = -1;
		int count = 0;

		int operationIndex = 0;
		int[] currentOperation = operations[0];
		while (start <= end) {
			if (start == -1 && end == -1) {
				if (operationIndex == operations.length)
					break;

				currentOperation = operations[operationIndex++];
				start = currentOperation[0];
				end = currentOperation[1];
				count = currentOperation[2];
			} else {
				if (start == end) {
					nums[start] = nums[start] + count;
					start = -1;
					end = -1;
					continue;
				}
				nums[start] = nums[start] + count;
				start++;
			}
		}

		return nums;
	}
	
	public int[] solve2(int[] nums, int[][] operations) {
		if (operations.length == 0) {
			return nums;
		}
		
		int[] additions = new int[nums.length];
		
		int start, end, count;
		for (int[] operation : operations) {
			start = operation[0];
			end = operation[1];
			count = operation[2];
			
			additions[start] += count;
			
			if (end + 1 < additions.length) {
				additions[end + 1] -= count;
			}
		}
		
		for (int i = 1; i < additions.length; i++) {
			additions[i] += additions[i - 1];
		}
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] += additions[i];
		}
		
		return nums;
	} 
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new RangeUpdate().solve2(new int[] {7, 3, 1, -10, 3}, new int[][] {
			new int[] { 0, 0, 3 },
			new int[] { 1, 3, 2 },
			new int[] { 2, 3, 5 }
		})));
	}
}
