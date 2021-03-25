package dev.codefoundry.string;

import java.util.Map;
import java.util.TreeMap;

/**
 * lazy Run Length Decoder based on Interval Tree
 * @author Gaurav Rai Mazra
 * {@link https://codefoundry.dev}
 *
 */
public class LazyRunLengthDecodingV2 {
	class Pair {
        String s;
        int end;

        public Pair(String s, int end) {
            this.s = s;
            this.end = end;
        }

        public String toString() {
            return this.s + ", " + this.end;
        }
    }
    private TreeMap<Integer, Pair> values = new TreeMap<>();
    private String s;
    
    public LazyRunLengthDecodingV2(String s) {
        this.s = s;
        parse();
    }

    private void parse() {
        int i = 0;
        int to = 0;
        while(i < s.length()) {
            if(Character.isDigit(s.charAt(i))) {
                int start = i;
                while(Character.isDigit(s.charAt(i))) {
                    i++;
                }
                String noAsString = s.substring(start, i);
                int intz = Integer.parseInt(noAsString);

                values.put(to, new Pair("" + s.charAt(i++), to + intz));
                to+= intz;
            }
            else {
                values.put(to, new Pair("" + s.charAt(i++), to++));
            }
        }
    }

    public String value(int i) {
        Map.Entry<Integer, Pair> entry = values.floorEntry(i);
        return entry.getValue().s;
    }

    public String valueInRange(String c, int i, int j) {
        Map.Entry<Integer, Pair> entry = values.floorEntry(i);
        while(i < j && entry != null) {
            if (entry.getKey() <= i && i <= entry.getValue().end) {
                if (entry.getValue().s.compareTo(c) >= 0) return entry.getValue().s;
                else {
                    i = entry.getValue().end;
                    entry = values.higherEntry(entry.getKey());
                }
            } else break;
        }
        return "?";
    }
}
