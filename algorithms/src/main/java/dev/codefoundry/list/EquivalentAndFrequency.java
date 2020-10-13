package dev.codefoundry.list;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://www.codefoundry.dev}
 * 
 * Given a list of integers, return true if same integer's frequency 
 * is same as its value
 *
 */
public class EquivalentAndFrequency {
	public boolean solve(int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        for (int num : nums) {
        	frequencies.put(num, frequencies.getOrDefault(num, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> freq : frequencies.entrySet()) {
            if (freq.getKey().equals(freq.getValue())) {
                return true;
            }
        }
        return false;
    }
}
