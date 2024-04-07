package cc.gaurav.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Two sum solution
 * @author Gaurav Rai Mazra
 * {@link https://www.gaurav.cc}
 *
 */
public class TwoSumV1 {
	private List<Integer> values = new ArrayList<>();
	
	public void add(int val) {
		this.values.add(val);
	}
	
	public boolean find(int val) {
		if (this.values.isEmpty() || this.values.size() == 1) return false;
		
		Collections.sort(this.values);
		
		int start = 0;
		int end = this.values.size(); 
		
		int sum;
		while(start < end) {
			sum = this.values.get(start) + this.values.get(end);
			if (sum == val) {
				return true;
			} else if (sum > val) {
				end--;
			} else {
				start++;
			}
		}
		
		return false;
	}
}
