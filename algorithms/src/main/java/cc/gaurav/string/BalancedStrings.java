package cc.gaurav.string;

public class BalancedStrings {
	public String solve(String s) {
		for (int windowSize = 1; windowSize <= s.length(); windowSize++) {
			for (int i = 0; i < s.length() - windowSize + 1; i++) {
				String k = s.substring(i, i + windowSize);
				
				int[] upper = new int[26];
				int[] lower = new int[26];
				for (int j = 0; j < k.length(); j++) {
					if (Character.isUpperCase(k.charAt(j))) {
						upper[k.charAt(j) - 'A']++;
					} else {
						lower[k.charAt(j) - 'a']++;
					}
					
					if (isBalanced(upper, lower)) {
						return k;
					}
				
				}
			}
		}
		
		return "-1";
	}
	
	private boolean isBalanced(int[] upper, int[] lower) {
		for (int i = 0; i < lower.length; i++) {
			if (lower[i] != 0 && upper[i] == 0) return false;
			
			if (upper[i] != 0 && lower[i] == 0) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		BalancedStrings bs = new BalancedStrings();
		
		System.out.println(bs.solve("azABaabza"));
		System.out.println(bs.solve("TacoCat"));
		System.out.println(bs.solve("AcZCbaBz"));
	}
}
