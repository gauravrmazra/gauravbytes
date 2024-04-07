package cc.gaurav.algorithms.search.string;

import java.util.function.Consumer;

/**
 * 
 * @author Gaurav Rai Mazra
 * <a href="https://grai.dev">Gaurav's Portfolio</a>
 * <a href="https://www.gaurav.cc">Gaurav's Blog</a>
 */
public class NaiveStringSearchMain {
	public static class NaiveStringSearch {
		public void search(String input, String pattern, Consumer<Integer> indexConsumer) {
			int N = input.length();
			int M = pattern.length();
			
			if (M > N) return;
		
			
			/*
			 * for (int i = 0, j = 0; i < (N-M);) { if (pattern.charAt(j) != input.charAt(j
			 * + i)) { i++; j = 0; continue; }
			 * 
			 * if (j + 1 == M) { indexConsumer.accept(i);
			 * 
			 * j = 0; i++; } else j++;
			 * 
			 * }
			 */
			
			
			for (int i = 0; i < (N - M); i++) {
				for (int j = 0; j < M; j++) {
					if (pattern.charAt(j) != input.charAt(j + i))
						break;

					if (j + 1 == M) {
						indexConsumer.accept(i);
					}
				}
			}
			 
		}
	}
	
	public static void main(String[] args) {
		String input = "aababaAAAAaabba";
		String pattern = "aabb";

		NaiveStringSearch naiveSearch = new NaiveStringSearch();
		naiveSearch.search(input, pattern, System.out::println);
	}
}
