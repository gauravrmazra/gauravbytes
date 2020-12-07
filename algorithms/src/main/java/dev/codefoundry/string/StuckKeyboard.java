package dev.codefoundry.string;

public class StuckKeyboard {
	public boolean solve(String typed, String target) {
        if (typed == null || target == null || typed.length() < target.length()) return false;
        
        int i = 0;
        int j = 0;
        int countA = 1;
        int countB = 1;
        
        char c;
        char d;
        while(i < typed.length()) {
            c = typed.charAt(i);
            if (i + 1 < typed.length() && typed.charAt(i) == typed.charAt(i + 1)) {
                int end = eat(typed, i);
                countA = 1 + end - i;
                i = end;
            }
            
            if (j >= target.length()) return false;
            
            d = target.charAt(j);
            if (j + 1 < target.length() && target.charAt(j) == target.charAt(j + 1)) {
                int end = eat(target, j);
                countB = 1 + end - j;
                j = end;
            }
            
            if (countB > countA || c != d) return false;
            
            j++;
            i++;
            
            countA = 1;
            countB = 1;
        }
        
        if (i != typed.length()) return false;
        
        
        return true;
    }
    
    private int eat(String s, int start) {
        while(start + 1 < s.length() && s.charAt(start) == s.charAt(start + 1)) start++;
        
        return start;
    }
    
    public static void main(String[] args) {
		System.out.println(new StuckKeyboard().solve("abc", "ab"));
	}
}
