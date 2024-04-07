package cc.gaurav.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestIncreasingSubsequence {
	class Data {
        int index;
        List<Integer> values = new ArrayList<>();
        
        Data(int index) {
            this.index = index;
        }
        
        public void add(int num) {
            values.add(num);
        }
        
        @Override
        public String toString() {
        	return "[" + index + ", " + values.toString() + "]";
        }
    }
    public int solve(int[] nums) {
        Map<Integer, Data> linking = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            final int index = i;
            linking.computeIfAbsent(nums[i], key -> new Data(index)).add(nums[i]);
        }
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num < 0) {
                int parent = num - 1;
                if (Math.abs(parent) > Math.abs(num) &&  linking.containsKey(parent) && linking.get(parent).index < i) {
                    List<Integer> values = linking.get(parent).values;
                    values.add(num);
                    linking.get(num).values = values;
                } 
            } else {
                int parent = num - 1;
                if (linking.containsKey(parent) && linking.get(parent).index < i) {
                    List<Integer> values = linking.get(parent).values;
                    values.add(num);
                    linking.get(num).values = values;
                } 
            }
        }
        
        return linking.values().stream().mapToInt(value -> value.values.size()).max().orElse(0);
    }
    
    
    public static void main(String[] args) {
		System.out.println(new LongestIncreasingSubsequence().solve(new int[] {6, 1, 7, 2, 8, 3, 4, 5}));
	}
}
