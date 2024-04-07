package cc.gaurav.str;

import java.util.Stack;

public class ParseBooleanExpression {

	public boolean solve(String s) {
        String ex = evalBrackets(s);
		return eval(ex, 0);
	}

	private String evalBrackets(String s) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if ('(' == s.charAt(i)) {
				stack.push(i);
			} else if (')' == s.charAt(i)) {
				int closing = i;
				int start = stack.pop();
				String currExp = s.substring(start + 1, closing);
				String result = "" + eval(currExp, 0);
				s = s.substring(0, start) + result + s.substring(closing + 1);
				i = start + result.length() - 1;
			}
		}

		return s;
	}

	private int eatEmptyChars(String expression, int idx) {
		while(idx < expression.length() && !Character.isAlphabetic(expression.charAt(idx))) idx++;

		return idx;
	}

	private int eatChars(String expression, int idx) {
		while(idx < expression.length() && Character.isAlphabetic(expression.charAt(idx))) idx++;

		return idx;
	}

	private boolean eval(String expression, int idx) {
		idx = eatEmptyChars(expression, idx);

		boolean result = expression.charAt(idx) == 't';
		
		idx = eatChars(expression, idx);
		
		if (idx == expression.length()) return result;

		idx = eatEmptyChars(expression, idx);

		boolean and = expression.charAt(idx) == 'a';
	
		idx = eatChars(expression, idx);

		return and ? result && eval(expression, idx) : result || eval(expression, idx);
	}
}
