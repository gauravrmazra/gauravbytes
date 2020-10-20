package dev.codefoundry.string;

public class OddPalindrome {
	public boolean solve(String s) {
		if (s.length() == 0 || s.length() == 1)
			return true;

		for (int i = 0; i < s.length(); i++) {
			int result = palin(i, i, s);

			if (result != 0 && result % 2 == 0)
				return false;

			result = palin(i, i + 1, s);

			if (result != 0 && result % 2 == 0)
				return false;

		}
		return true;
	}

	private int palin(int p, int q, String s) {
		while (p >= 0 && q < s.length() && s.charAt(p) == s.charAt(q)) {
			p--;
			q++;
		}

		return s.substring(p + 1, q).length();
	}
	
	public boolean solve2(String s) {
		for (int i = 0; i < s.length() -1 ; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new OddPalindrome().solve("aba"));
	}
}
