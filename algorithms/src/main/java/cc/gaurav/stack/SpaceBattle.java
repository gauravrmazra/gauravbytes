package cc.gaurav.stack;

import java.util.Deque;
import java.util.LinkedList;

public class SpaceBattle {
	public int[] solve(int[] nums) {
        Deque<Integer> q = new LinkedList<Integer>();
        for (int num : nums) {
        	if (q.isEmpty()) {
        		q.push(num);
        		continue;
        	}
        	
        	while(!q.isEmpty()) {
        		Integer topValue = q.peek();
        		// Negative number
        		if(num < 0) {
        			//Top value negative
        			if (topValue < 0) {
        				q.push(num);
        				break;
        			} else { // -Num +Topvalue
        				int positiveNum = -num;
        				// -Num and +TopValue
        				if (topValue == positiveNum) {
        					q.pop();
        					break;
        				} else if (topValue < positiveNum) { // topValue smaller than positiveNum
        					q.pop();
        					if (q.isEmpty()) {
        						q.push(num);
        						break;
        					}
        				} else {
        					break;
        				}
        			}
        		} else { //+NUM
        			q.push(num);
        			break;
        			
        		}
        	}
        }
        
        int[] result = new int[q.size()];
        int i = q.size();
        for (Integer v: q) {
        	result[--i] = v;
        }
        return result;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[] {7, 68, -54};
		System.out.println(new SpaceBattle().solve(nums));
	}
}
