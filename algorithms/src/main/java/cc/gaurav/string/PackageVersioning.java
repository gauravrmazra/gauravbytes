package cc.gaurav.string;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://gaurav.cc}
 * 
 * For two package version (Major.Minor.Patch), return true if newer is bigger than the older package
 *
 */
public class PackageVersioning {
	public boolean solve(String older, String newer) {
        int t1, f1, t2, f2;
        for (t1 = 0, t2 = 0, f1 = 0, f2 = 0; f1 < older.length() || f2 < newer.length();) {
            if (older.charAt(f1) != '.' && f1 < older.length() - 1) {
                f1++;
            }
            
            if (newer.charAt(f2) != '.' && f2 < newer.length() - 1) {
                f2++;
            }
            
            if (older.charAt(f1) == '.' && newer.charAt(f2) == '.') {
                int oldNum = Integer.parseInt(older.substring(t1, f1));
                int newNum = Integer.parseInt(newer.substring(t2, f2));
                
                int diff = oldNum - newNum;
                if (diff < 0) {
                    return true;
                } else if (diff > 0) {
                    return false;
                } else {
                    f1++;
                    f2++;
                    t1 = f1;
                    t2 = f2;
                    
                }
            }
            
            if (f1 == older.length() - 1 && f2 == newer.length() - 1) {
            	int oldNum = Integer.parseInt(older.substring(t1));
                int newNum = Integer.parseInt(newer.substring(t2));
                
                return oldNum < newNum;
            }
        }
        return false;
    }
}
