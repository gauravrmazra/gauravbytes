package cc.gaurav.hash;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class AnagramDifference {
    static class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }
    }
	public static void main(String[] args) {
        Comparator<Pair<Integer, Integer>> c = Comparator.comparing(Pair::getValue, Comparator.reverseOrder());
        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>();
		System.out.println(new AnagramDifference().solve("cia", "aci"));
	}
		
	public int solve(String s0, String s1) {
        Map<Character, Set<Integer>> s0Table = table(s0);
        Map<Character, Set<Integer>> s1Table = table(s1);
        
        StringBuilder s0B = new StringBuilder();
        s0B.append(s0);
        
        StringBuilder s1B = new StringBuilder();
        s1B.append(s1);
        int swap = 0;

        Set<Integer> indexes;
        for (int i = 0; i < s0.length(); i++) {
            System.out.println(s1Table);
            System.out.println(s0.charAt(i));
            indexes = s1Table.get(s0.charAt(i));
            
            if (!indexes.contains(i)) {
                swap++;
                for (Integer idx : indexes) {
                    if (s0.charAt(idx) != s1B.charAt(idx)) {
                    	indexes.remove(idx);
                    	
                    	char ch = s1B.charAt(i);
                    	char ch1 = s0.charAt(i);
                    	
                    	Set<Integer> idxes = s1Table.get(s1B.charAt(i));
                        idxes.remove(i);
                        idxes.add(idx);
                        indexes.add(i);
                        
                        s1B.setCharAt(idx, ch);
                        s1B.setCharAt(i, ch1);
                        
                        break;
                    }
                }
            }
        }

        return swap;
    }

    private Map<Character, Set<Integer>> table(String s) {
        Map<Character, Set<Integer>> t = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            t.computeIfAbsent(s.charAt(i), key -> new HashSet<>()).add(i);
        }
        return t;
    }
}
