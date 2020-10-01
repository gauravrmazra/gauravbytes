package dev.codefoundry.string;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://www.codefoundry.dev}
 * Consider a string consist of 1 and 0. You can delete character
 * if the consective chars are not same
 * Return the shortsest string length
 */
public class ShortestString {
	public int solve(String s) {
		int totalChars = s.length();
		boolean[] deleted = new boolean[totalChars];
		
		int i = 0, j = 1;
		
		while(i < totalChars && j < totalChars) {
			if (s.charAt(i) != s.charAt(j)) {
				deleted[i] = true;
				deleted[j] = true;
			}
		}
		
		int notDeleted = 0;
		for (boolean b : deleted) {
			if (!b) notDeleted++;
		}
		return notDeleted;
	}
	
	public static void main(String[] args) {
		//System.out.println(new ShortestString().solve("11000"));
		System.out.println('b' - 97);
	}
}
