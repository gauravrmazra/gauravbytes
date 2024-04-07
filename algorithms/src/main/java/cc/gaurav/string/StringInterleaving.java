package cc.gaurav.string;

/**
 * 
 * @author Gaurav Rai Mazra {@link https://gaurav.cc}
 * 
 *         Interleaving two string e.g. s1 = "ZXC" and s1="QWE" then the result
 *         should be "ZQXWCE" if any of the string is consumed then remainder is
 *         of the other should added at the end.
 *
 */
public class StringInterleaving {
	public String solve(String s0, String s1) {
		// Write your code here

		int s0Length = s0.length();
		int s1Length = s1.length();
		int to = Math.min(s0Length, s1Length);
		StringBuilder result = new StringBuilder();
		for (int index = 0; index < to; index++) {
			result.append(s0.charAt(index)).append(s1.charAt(index));

			if (index + 1 == s0Length) {
				result.append(s1.substring(index + 1));
				break;
			}

			if (index + 1 == s1Length) {
				result.append(s0.substring(index + 1));
				break;
			}
		}

		return result.toString();
	}

	public static void main(String[] args) {
		String s0 = "XYZZZZ";
		String s1 = "ABCQQQ";
		String expected = "XAYBZCZQZQZQ";
		String actual = new StringInterleaving().solve(s0, s1);
		System.out.println(expected.equals(actual));
	}

	// Refined version
	public String solve2(String s0, String s1) {
		int s0Length = s0.length();
		int s1Length = s1.length();
		int to = Math.min(s0Length, s1Length);

		StringBuilder result = new StringBuilder();
		for (int index = 0; index < to; index++) {
			result.append(s0.charAt(index)).append(s1.charAt(index));
		}

		if (to == s0Length && to < s1Length) {
			result.append(s1.substring(to));
		}

		if (to == s1Length && to < s0Length) {
			result.append(s0.substring(to));
		}

		return result.toString();
	}

	// Refined version without using substr
	public String solve3(String s0, String s1) {
		int s0Length = s0.length();
		int s1Length = s1.length();
		int to = Math.min(s0Length, s1Length);

		StringBuilder result = new StringBuilder();
		for (int index = 0; index < to; index++) {
			result.append(s0.charAt(index)).append(s1.charAt(index));
		}

		if (to == s0Length && to < s1Length) {
			addRestCharToBuilder(result, s1, to, s1Length);
		}

		if (to == s1Length && to < s0Length) {
			addRestCharToBuilder(result, s0, to, s0Length);
		}

		return result.toString();
	}
	
	private void addRestCharToBuilder(StringBuilder sb, String s, int start, int end) {
		while(start < end) {
			sb.append(s.charAt(start++));
		}
	}

}
