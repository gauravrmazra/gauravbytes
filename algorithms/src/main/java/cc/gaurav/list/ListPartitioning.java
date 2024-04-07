package cc.gaurav.list;

import java.util.Arrays;

public class ListPartitioning {
	public String[] solve(String[] strs) {
		Arrays.parallelSort(strs, (String first, String second) -> {
			return rank(first) - rank(second);
		});
		
		return strs;
	}

	public int rank(String str) {
		switch (str) {
		case "red":
			return 0;
		case "green":
			return 1;
		case "blue":
			return 2;
		default:
			return -1;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(new ListPartitioning().solve(new String[] {"green", "blue", "red", "red"})));
	}
}
