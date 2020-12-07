package dev.codefoundry.stack;

import java.util.LinkedList;

public class RepeatedDeletionByK {
	public String solve(String s, int k) {
		if (s == null)
			return s;

		if (k == 1)
			return "";

		LinkedList<Character> stack = new LinkedList<>();

		Character c;
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (stack.isEmpty()) {
				stack.addLast(c);
			} else {
				if (stack.peekLast().equals(c)) {
					int j = k;
					LinkedList<Character> temp = new LinkedList<>();
					while (j-- > 0 && !stack.isEmpty() && stack.peekLast().equals(c)) {
						temp.addLast(stack.removeLast());
					}

					if (j != 0) {
						while (!temp.isEmpty()) {
							stack.addLast(temp.removeFirst());
						}

						stack.addLast(c);
					}
				} else {
					stack.addLast(c);
				}
			}
		}

		char[] result = new char[stack.size()];
		int i = 0;
		while (!stack.isEmpty()) {
			result[i++] = stack.removeFirst();
		}

		return new String(result);
	}

	public static void main(String[] args) {
		System.out.println(new RepeatedDeletionByK().solve("baaabbdddd", 3));
	}
}
