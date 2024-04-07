package cc.gaurav.string;

/**
 * 
 * @author Gaurav Rai Mazra {@link https://www.gaurav.cc} Consider a
 *         string consist of 1 and 0. You can delete character if the consective
 *         chars are not same Return the shortsest string length
 */
public class ShortestString {
	public int solve(String s) {
        // Write your code here
        int i = 0;
        int j = 1;
        int len = s.length();
        if (len == 1) {
            return len;
        }
        String str = s;
        while (i < str.length() && j < str.length()) {
            if (str.charAt(i) != str.charAt(j)) {
                str = str.substring(0, i) + str.substring(j + 1);
                i = 0;
                j = 1;
            } else {
            	i++;
                j++;	
            }
        }
    
        return str.length();
    }

	public static void main(String[] args) {
		System.out.println(new ShortestString().solve("11000"));
	}
}
