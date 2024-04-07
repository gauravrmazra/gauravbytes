package cc.gaurav.string;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://www.gaurav.cc}
 * 
 * Given a string of parentheses, write a function to compute the 
 * minimum number of parentheses to be removed to make the string valid 
 * (i.e. each open parenthesis is eventually closed).
 *
 */
public class RemovingParenthesis {
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
		System.out.println(new RemovingParenthesis().solve("(()(") == 2);
	}
}
