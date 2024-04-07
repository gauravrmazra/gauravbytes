package cc.gaurav.string;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://gaurav.cc}
 * 
 * Given a string of Parenthesis, return how many are not closed 
 *
 */
public class MinimumBracketAddition {
	public int solve(String s) {
        int requiredBrackets = 0;
        char lastBracket = ' ';
        int count = 0;
        
        // ))(()))((
        for (int i = 0; i < s.length(); i++) {
        	if(lastBracket == ' ') {
        		lastBracket = s.charAt(i);
        		requiredBrackets += count;
        		count = 1;
        	} else if (lastBracket == s.charAt(i)) {
        		count++;
        	} else if (lastBracket == '(' && s.charAt(i) == ')') {
        		count--;
        		
        		if (count == 0) {
        			lastBracket = ' ';
        		}
        	} else if (lastBracket == ')' && s.charAt(i) == '(') {
        		requiredBrackets += count;
        		lastBracket = '(';
        		count = 1;
        	}
        }
        
        requiredBrackets += count;
        return requiredBrackets;
    }
	
	public static void main(String[] args) {
		MinimumBracketAddition mba = new MinimumBracketAddition();
		System.out.println(mba.solve(")))((") == 5);
	}
}
