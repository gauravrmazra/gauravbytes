package dev.codefoundry.list;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.BinaryOperator;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://www.codefoundry.dev}
 *
 * You are given a two-dimensional list of integers matrix 
 * where each row is sorted in ascending order. 
 * Return the smallest number that exists in every row. 
 * If there's no solution, return -1.
 * 
 */
public class SmallestIntersectingElement {
	
	public int solve2(int[][] matrix) {
		if (matrix.length == 0) return -1;
		Set<Integer> values = new HashSet<Integer>();
		values.addAll(toList(matrix[0]));
		
		for (int[] m : matrix) {
			values.retainAll(toList(m));
			
			if (values.size() == 0) {
				return -1;
			}
		}
		
		
		
		return values.stream().reduce(BinaryOperator.minBy((Integer a, Integer b) -> a - b)).orElse(-1);
	}
	
	private List<Integer> toList(int[] nums) {
		List<Integer> l = new ArrayList<Integer>(nums.length);
		for (int num : nums) {
			l.add(num);
		}
		
		return l;
	}
	
	public int solve(int[][] matrix) {
		int lowestValue = Integer.MAX_VALUE;
		boolean hasLowestValue = false;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (exists(matrix, matrix[i][j])) {
					hasLowestValue = true;
					lowestValue = lowestValue < matrix[i][j] ? lowestValue : matrix[i][j];
				}
			}
		}

		return hasLowestValue ? lowestValue : -1;
	}

	private boolean exists(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; i++) {
			if (!binarySearch(matrix[i], target)) {
				return false;
			}
		}

		return true;
	}

	public boolean binarySearch(int[] nums, int target) {
		int left = 0;
		int right = nums.length;
		int mid;
		while (left < right) {
			mid = left + (right - left) / 2;

			if (nums[mid] > target) {
				right = mid;
			} else if (nums[mid] < target) {
				left = mid + 1;
			} else {
				return true;
			}
		}
		return false;
	}
}
