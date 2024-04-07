package cc.gaurav.string;

import java.util.Arrays;
import java.util.TreeSet;

public class AnagramSubstring {
	public int solve(String s0, String s1) {
		int[][] ob = new int[10][2];
		
		Arrays.stream(ob).flatMapToInt(Arrays::stream).toArray();
        if (s1.length() < s0.length()) return 0;
        
        if (s0.equals(s1)) return 1;
        
        int[] s0Table = prepareTable(s0, 0, s0.length());
        
        final int length = s1.length() - s0.length();
        int[] s1Table = null;
        int count = 0;
        for (int i = 0; i < length;) {
            if (s1Table == null) {
                s1Table = prepareTable(s1, i, i + s0.length());
            }
            
            if (Arrays.equals(s0Table, s1Table)) {
                count++;
                
                if (i + s0.length() < length && s1.charAt(i) == s1.charAt(i + s0.length())) {
                    i++;
                } else {
                	i += s0.length();
                }
            } else {
                s1Table = null;
                i += s0.length();
            }
        }
        
        return count;
    }
    
    private int[] prepareTable(String s, int start, int end) {
        int[] table = new int[26];
        for (int i = start; i < end; i++) {
            table[s.charAt(i) - 'a']++;
        }
        
        return table;
    }
    
    public static void main(String[] args) {
		System.out.println(new AnagramSubstring().solve("abc", "bcabxabc"));
	}
}
