package cc.gaurav.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author Gaurav Rai Mazra
 * {@link https://www.gaurav.cc}
 * 
 * A rotation group for a string contains all of its unique rotations. 
 * For example, "123" can be rotated to "231" and "312" and they are all in 
 * the same rotation group.
 * 
 * Given a list of strings words, group each word by their rotation group, 
 * and return the total number of groups.
 *
 */
public class RotationGroups {
	
	public int solve(String[] words) {
        Set<Key> set = new HashSet<Key>();
        for (String word : words) {
            set.add(new Key(word));
        }
        
        return set.size();   
    }
	
	class Key {
		private final String value;
		
		private final String computedValue;
		
		private final int hash;
		
		public Key(String value) {
			this.value = value;
			this.computedValue = this.value + this.value;
			this.hash = hash(value);
		}
		
		private int hash(String value) {
			int hash = 0;
			for (char c : value.toCharArray()) {
				hash += (c - 0);
			}
			
			return hash;
		}
		
		@Override
		public int hashCode() {
			return this.hash;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj == null || !(obj instanceof Key)) return false;
			
			Key that = (Key) obj;
			
			return (that.computedValue).contains(this.value) || this.computedValue.contains(that.value);
			
		}
	}
}
