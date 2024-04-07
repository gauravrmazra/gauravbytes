package cc.gaurav.bitmanupulation;

import java.util.Arrays;

public class LoneInteger {
	public int solve(int[] nums) {
		if (nums.length == 0)
			return 0;

		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i+=3) {
            if (i + 1 == nums.length) return nums[i];
            
            if ((nums[i] ^ nums[i + 1]) == 0 && (nums[i] ^ nums[i + 2]) == 0) {
                continue;
            }
            
            return nums[i];
        }
		return 0;
	}

	public static void main(String[] args) {
		System.out.println(new LoneInteger().solve(new int[] { 2, 2, 2, 9, 9, 9, 3, 7, 7, 7 }));
	}
}
