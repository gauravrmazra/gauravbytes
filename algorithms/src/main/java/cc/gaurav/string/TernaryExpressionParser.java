package cc.gaurav.string;

import java.util.Stack;

public class TernaryExpressionParser {
	public boolean solve(String s) {
		if (s.length() < 5)
			return false;

		Stack<String> stack = new Stack<>();
		int i = 0;
		int j = s.length() - 1;

		String a;
		while (i < j) {
			if (Character.isAlphabetic(s.charAt(i))) {
				int start = i;
				while (i < s.length() && Character.isAlphabetic(s.charAt(i)))
					i++;

				a = s.substring(start, i);
				if (!stack.isEmpty() && stack.peek().equals(":") && i + 1 < s.length() && s.charAt(i) == ' '
						&& s.charAt(i + 1) == ':') {
					stack.pop(); // this is :
					String b = stack.pop(); // after q
					stack.pop(); // this is ?
					String ex = stack.pop(); // this is expression to eval

					if (Boolean.valueOf(ex)) {
						stack.push(b);
					} else {
						stack.push(a);
					}
					
					boolean shouldPop = stack.size() >= 5;
					while(shouldPop) {
						String y = stack.pop();
						String colon = stack.pop();
						String x = stack.pop();
						String que = stack.pop();
						String expr = stack.pop();
						if (colon.equals(":") && que.equals("?")) {
							if (Boolean.valueOf(expr)) {
								stack.push(x);
							} else {
								stack.push(y);
							}
							shouldPop = stack.size() >= 5;
							
						} else {
							stack.push(expr);
							stack.push(que);
							stack.push(x);
							stack.push(colon);
							stack.push(y);
							shouldPop = false;
						}
						
					}
				} else {
					stack.push(a);
				}
			} else if (s.charAt(i) == '?' || s.charAt(i) == ':') {
				stack.push("" + s.charAt(i));
				i++;
			} else {
				i++;
			}
		}

		if (stack.size() > 1) {
			while (stack.size() != 1) {
				String x = stack.pop(); // after :
				stack.pop(); // this is :
				String y = stack.pop(); // this is after ?
				stack.pop(); // this is ?
				String ex = stack.pop();

				if (Boolean.valueOf(ex)) {
					stack.push(y);
				} else {
					stack.push(x);
				}
			}
		}

		return Boolean.valueOf(stack.pop());
	}

	public static void main(String[] args) {
		String s = "true ? true ? false : false : true";
		System.out.println(new TernaryExpressionParser().solve(s));
	}
}
