package cc.gaurav.tries;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://gaurav.cc}
 * 
 * Check if two tree's are exact same
 *
 */
public class TwinTrees {
	class Tree {
		int val;
		Tree left;
		Tree right;
	}
	
	public boolean solve(Tree first, Tree second) {
		if (first == null || second == null) {
			return first == null ? second == null : false;
		}
		
		Queue<Tree> firstQ = new LinkedList<>();
		Queue<Tree> secondQ = new LinkedList<>();
		firstQ.add(first);
		secondQ.add(second);
		
		while(!firstQ.isEmpty() || !secondQ.isEmpty()) {
			Tree f = firstQ.poll();
			Tree s = secondQ.poll();
			
			if (f == null && s == null) continue;
			
			if (f == null && s != null) {
				return false;
			}
			
			if (s == null && f != null) {
				return false;
			}
			
			if (f.val == s.val) {
				firstQ.add(f.left);
				secondQ.add(s.left);
				
				firstQ.add(f.right);
				secondQ.add(s.right);
				
			} else {
				return false;
			}
		}
		
		return true;
	}
}
