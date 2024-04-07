package cc.gaurav.bitmanupulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubMajorityVote {
	public int[] solve(int[] nums) {
        Map<Integer, Integer> votesCount = new HashMap<>();
        for (int num : nums) {
            votesCount.merge(num, 1, (left, right) -> left + right);
        }
        
        final int oneThird = nums.length / 3;
        
        return votesCount.entrySet().stream()
        .filter(entry -> entry.getValue() > oneThird)
        .mapToInt(entry -> entry.getKey()).sorted().toArray();
    }
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(new SubMajorityVote().solve(new int[] {2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6})));
	}
}
