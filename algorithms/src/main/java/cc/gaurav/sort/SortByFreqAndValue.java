package cc.gaurav.sort;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class SortByFreqAndValue {
	public int[] solve(int[] nums) {
        Map<Integer, Integer> table = new HashMap<>();
        for (int num : nums) {
            table.merge(num, 1, (left, right) -> left + right);
        }
        
        return table.entrySet().stream()
        .map(entry -> new int[] { entry.getKey(), entry.getValue() })
        .sorted((int[] a, int[] b) -> Integer.compare(b[1], a[1]))
        .flatMapToInt(e -> IntStream.range(0, e[1]).map(i -> e[0]))
        .toArray();
    }
}
