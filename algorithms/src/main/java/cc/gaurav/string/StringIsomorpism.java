package cc.gaurav.string;

public class StringIsomorpism {
	public boolean solve(String s, String t) {
if (s.length() != t.length()) return false;
        
        char[] table = new char[26];
        char[] table2 = new char[26];
        char in;
        char out;
        for (int i = 0; i < s.length(); i++) {
           in = table[s.charAt(i) - 'a'];
           out = table2[t.charAt(i) - 'a'];
           if (in - '0' == -48 && out - '0' == -48) {
        	   table[s.charAt(i) - 'a'] = t.charAt(i);
        	   table2[t.charAt(i) - 'a'] = s.charAt(i);
           } else if (in != t.charAt(i)) {
        	   return false;
           }
        }
        
        return true;
    }
	
	public static void main(String[] args) {
		System.out.println(new StringIsomorpism().solve("cocca", "momma"));
	}
}
