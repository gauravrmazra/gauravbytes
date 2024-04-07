package cc.gaurav.string;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 
 * @author Gaurav Rai Mazra {@link https://gaurav.cc}
 * 
 *         Given a string s representing an arithmetic s-expression, evaluate
 *         and return it as an integer.
 * 
 *         An s-expression is an expression that's either an integer, like 5, or
 *         a recursive expression wrapped in parentheses like (+ (- 2 1) (* 2
 *         2)), which is equivalent to (2 - 1) + (2 * 2) = 5. Valid operations
 *         are +, -, /, and *.
 * 
 *         Note: / is integer division.
 *
 */
public class STypeExpressEvaluation {
	Deque<String> q = new LinkedList<>();

	public int solve(String s) {
		if (s.length() == 0)
			return 0;

		if (Character.isDigit(s.charAt(0)) && s.length() == 1)
			return Integer.parseInt(s.charAt(0) + "");

		for (int i = 0; i < s.length(); i++) {
			if (isValidOperator(s.charAt(i))) {
				if (isNegativeNumber(s, i)) {
					StringBuilder digits = new StringBuilder();
					digits.append(s.charAt(i++));
					while (i < s.length() && Character.isDigit(s.charAt(i))) {
						digits.append(s.charAt(i++));
					}
					i--;
					q.addLast(digits.toString());

				} else {
					q.addLast(s.charAt(i) + "");
				}

			} else if (Character.isDigit(s.charAt(i))) {
				StringBuilder digits = new StringBuilder();
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					digits.append(s.charAt(i++));
				}
				i--;
				q.addLast(digits.toString());

			} else if (s.charAt(i) == ')') {
				String right = q.pollLast();
				String left = q.pollLast();
				String operator = q.pollLast();
				q.pollLast();

				q.addLast(compute(left, right, operator));
			}
		}

		return Integer.parseInt(q.pollLast());
	}

	private boolean isNegativeNumber(String s, int i) {
		return s.charAt(i) == '-' && i + 1 < s.length() && Character.isDigit(s.charAt(i + 1));
	}

	private String compute(String left, String right, String operation) {
		int result = 0;
		switch (operation) {
		case "+":
			result = Integer.parseInt(left) + Integer.parseInt(right);
			break;
		case "-":
			result = Integer.parseInt(left) - Integer.parseInt(right);
			break;
		case "*":
			result = Integer.parseInt(left) * Integer.parseInt(right);
			break;
		case "/":
			result = Integer.parseInt(left) / Integer.parseInt(right);
			break;
		default:
			result = 0;
			break;
		}

		return String.valueOf(result);
	}

	private boolean isValidOperator(char c) {
		boolean valid = false;
		switch (c) {
		case '(':
			valid = true;
			break;
		case '-':
			valid = true;
			break;
		case '+':
			valid = true;
			break;
		case '/':
			valid = true;
			break;
		case '*':
			valid = true;
			break;
		default:
			valid = false;
			break;
		}
		return valid;
	}

}
