package cc.gaurav.algorithms.search.string;

import java.util.function.Consumer;

/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="https://grai.dev">Gaurav's Portfolio</a>
 * <a href="https://www.gaurav.cc">Gaurav's Blog</a>
 */
public class KMPSearchMain {
	private static class KMPSearch {
		public void search(String input, String pattern, Consumer<Integer> indexConsumer) {
			if (input.length() < pattern.length())
				return;

			int N = input.length();
			int M = pattern.length();

			int[] lsp = computeAndGetLSP(pattern);

			int i = 0, j = 0;
			while (i < N) {

				if (input.charAt(i) == pattern.charAt(j)) {
					j++;
					i++;
				}

				// if all chars are matched then consume it
				if (j == M) {
					indexConsumer.accept((i - j));
					j = lsp[j - 1];
				}
				else if (i < N && pattern.charAt(j) != input.charAt(i)) {
					if (j != 0)
						j = lsp[j - 1];
					else
						i++;
				}
			}
		}

		private static final int[] computeAndGetLSP(String pattern) {
			int[] largestPrefixSuffix = new int[pattern.length()];
			// starting element will always have zero as LSP
			largestPrefixSuffix[0] = 0;

			for (int i = 1; i < pattern.length(); i++) {
				int j = largestPrefixSuffix[i - 1];
				while (j > 0 && pattern.charAt(i) != pattern.charAt(j))
					j = largestPrefixSuffix[j - 1];

				if (pattern.charAt(i) == pattern.charAt(j))
					j++;

				largestPrefixSuffix[i] = j;
			}

			return largestPrefixSuffix;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "aabaabaabaabaaabaabaabaaba";
		String pattern = "aabaabaab";

		KMPSearch kmp = new KMPSearch();
		kmp.search(input, pattern, System.out::println);

	}
}
