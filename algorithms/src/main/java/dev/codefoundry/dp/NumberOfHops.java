package dev.codefoundry.dp;

import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://codefoundry.dev}
 *
 */
public class NumberOfHops {

	public int solve1(int[] nums) {
		if (nums.length <= 1) 
            return 0; 
  
        if (nums[0] == 0) 
            return 0; 
  
        
        int maxReach = nums[0]; 
        int step = nums[0]; 
        int jump = 1; 
  
        for (int i = 1; i < nums.length; i++) { 
            if (i == nums.length - 1) 
                return jump; 
  
            maxReach = Math.max(maxReach, i + nums[i]); 
  
            step--; 
  
            if (step == 0) { 
                jump++; 
  
                if (i >= maxReach) 
                    return 0; 
  
                step = maxReach - i; 
            } 
        } 
  
        return 0; 
	}
	
	
	
	public int solve(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums[0] == 0)
			return 0;
		TreeSet<Integer> trees = new TreeSet<>();
		trees.add(hops(nums, 0, Integer.MAX_VALUE, trees));
		return trees.first();
	}

	private int hops(int[] nums, int index, int min, Set<Integer> trees) {
		if (index + nums[index] >= nums.length - 1) {
			return 1;
		}
		if (nums[index] == 0)
			return Integer.MAX_VALUE;

		for (int i = nums[index]; i >= 1; i--) {
			min = Math.min(min, hops(nums, index + i, 1, trees));

			if (min != Integer.MAX_VALUE)
				min++;

			trees.add(min);
		}

		return min;
	}

}
