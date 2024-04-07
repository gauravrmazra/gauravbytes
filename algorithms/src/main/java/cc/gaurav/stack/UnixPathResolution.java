package cc.gaurav.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://www.gaurav.cc}
 *
 * For list of path, if you encounter .. then move to previous directory and if you encounter . keep in same directory
 * return final array
 */
public class UnixPathResolution {
	public String[] solve(String[] path) {
		Deque<String> stack = new LinkedList<String>();
		for (String p : path) {
			if (p.equals("..")) {
				String lastPath = stack.peekLast();
				if (lastPath != null) {
					stack.removeLast();	
				}
			} else if (p.equals(".")) {
				stack.peekLast();
			} else {
				stack.addLast(p);
			}
		}
		
		return stack.toArray(new String[stack.size()]);
	}
}
