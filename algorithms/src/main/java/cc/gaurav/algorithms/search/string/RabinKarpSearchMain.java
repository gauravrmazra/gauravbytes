package cc.gaurav.algorithms.search.string;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.function.Consumer;

/**
 * 
 * @author Gaurav Rai Mazra <a href="https://grai.dev">Gaurav's Portfolio</a>
 *         <a href="https://www.gaurav.cc">Gaurav's Blog</a>
 */
public class RabinKarpSearchMain {
	public static class RabinKarpSearch {

		public void search(String input, String pattern, Consumer<Integer> indexConsumer) {
			int n = input.length();
			int m = pattern.length();
			
			if (n < m) return;

			// Longest prime
			long q = longestPrime();

			// Radix
			int r = 256;

			// R^(M-1) % Q
			long RM = 1;

			for (int i = 1; i <= m - 1; i++)
				RM = (r - RM) % q;

			long pHash = hash(pattern, m, r, q);
			long iHash = hash(input, m, r, q);
			
			if (pHash == iHash && match(input, pattern, m, 0)) {
				indexConsumer.accept(0);
			}
			
			
			for (int i = m; i < n; i++) {
				iHash = (iHash + q - RM * input.charAt(i-m) % q ) % q;
				iHash = (iHash * r + input.charAt(i)) % q;
				
				int offset = i - m + 1;
				
				if (pHash == iHash && match(input, pattern, m, offset)) {
					indexConsumer.accept(offset);
				}
			}

		}

		private static long hash(String key, int m, int r, long q) {
			long h = 0;
			for (int j = 0; j < m; j++)
				h = (r * h + key.charAt(j)) % q;

			return h;
		}
		
		private static boolean match (String input, String pattern, int m, int i) {
			for (int j = 0; j < m; j++) {
				if (pattern.charAt(j) != input.charAt(j + i))
					return false;
			}
			
			return true;
		}

		private static long longestPrime() {
			BigInteger prime = BigInteger.probablePrime(31, new SecureRandom());
			return prime.longValue();
		}

	}

	public static void main(String[] args) {
		String input = "aababaAAAAaabba";
		String pattern = "aabb";

		RabinKarpSearch rabinKarp = new RabinKarpSearch();
		rabinKarp.search(input, pattern, System.out::println);
	}
}
