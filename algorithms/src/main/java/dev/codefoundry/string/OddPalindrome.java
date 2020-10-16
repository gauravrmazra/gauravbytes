package dev.codefoundry.string;

public class OddPalindrome {
	public boolean solve(String s) {
		if (s.length() == 0 || s.length() == 1)
			return true;

		boolean hasOddPalinDrome = false;
		// aa
		for (int i = 0; i < s.length(); i++) {
			int p = i, q = i;
			int r = s.length() - 1;

			while (p >= 0 && q < r) {
				if (s.charAt(p) == s.charAt(q)) {
					if (p > 0) {
						p--;
					}

					if (q < r) {
						q++;
					}
				} else {
					break;
				}
			}
			
			int len = q - 1 - p;
			if (len % 2 == 0) {
				return false;
			} else {
				hasOddPalinDrome = true;
			}
		}
		return hasOddPalinDrome;
	}
	
	public static void main(String[] args) {
		System.out.println(new OddPalindrome().solve("aba"));
	}
}
