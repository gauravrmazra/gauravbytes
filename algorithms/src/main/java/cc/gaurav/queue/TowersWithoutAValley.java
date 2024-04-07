package cc.gaurav.queue;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;


public class TowersWithoutAValley {
  static class Pair {
    final int k;
    final int v;
  
    public Pair(int k, int v) {
      this.k = k;
      this.v = v;
    }
  }
  
  private int[] increasingPrefixSums(int[] nums) {
    int[] result = new int[nums.length];
    LinkedList<Pair> stack = new LinkedList<>();
    int currentSum = 0;

    int count;
    int num;
    for (int i = 0; i < nums.length; i++) {
      num = nums[i];
      count = 1;

      while(!stack.isEmpty() && stack.peek().k > num) {
        currentSum -= stack.peek().k * stack.peek().v;
        count += stack.peek().v;
        stack.pop();
      }
      stack.push(new Pair(num, count));
      currentSum += num * count;
      result[i] = currentSum;
    }

    return result;
  }

  public int solve(int[] nums) {
    List<Integer> numbers = new ArrayList<>();
    for (int num : nums) {
      numbers.add(num);
    }
    int[] left = increasingPrefixSums(nums);
    int[] right = increasingPrefixSums(nums);

    int max = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
      max = Math.max(max, left[i] + right[i] - nums[i]);
    }
    
    return max;
  }
}
