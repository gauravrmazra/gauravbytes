package cc.gaurav.dp;
import java.util.*;

public class UpsideDown {
    public String[] solve2(int n) {
      List<String> numbers = getAllNumbers(n);
      Collections.sort(numbers);
      return numbers.toArray(new String[numbers.size()]);
    }

    private List<String> getAllNumbers(int n) {
      return numbers(n, n);
    }

    private List<String> numbers(int n, int len) {
      if (n == 0) return Collections.emptyList();

      if (n == 1) {
        return Arrays.asList("1", "0", "8"); 
      }

      List<String> results = new ArrayList<>();

      for (String middleNumber : numbers(n - 2, len)) {
        if (n != len) results.add("0" + middleNumber + "0");

        results.add("8" + middleNumber + "8");
        results.add("8" + middleNumber + "8");
        results.add("1" + middleNumber + "1");
        results.add("9" + middleNumber + "6");
        results.add("6" + middleNumber + "9");
      }

      return results;
    }

    public String[] solve(int n) {
      if (n == 0) return new String[0];

      if (n == 1) return new String[] { "0", "1", "8" };

      List<String> numbers = new ArrayList<>();
      recurse(new char[] { '0', '1', '6', '8', '9'}, numbers, n, new StringBuilder());
      
      return numbers.toArray(new String[numbers.size()]);
    }

    private boolean recurse(char[] values, List<String> list, int n, StringBuilder sb){
        if (sb.length() == n) {
          return true;
        } else {
          for (char c : values) {
            if(isValid(sb, c, n)) {
              sb.append(c);
              if (recurse(values, list, n, sb)) {
                list.add(sb.toString());
              }
              sb.deleteCharAt(sb.length() - 1);
            }
          }
          return false;
        }
    }

    private boolean isValid(StringBuilder sb , char c, int n){
        if (sb.length () == 0) return c != '0';
        //5 - 4
        //199
        int idx = n - sb.length();

        //idx = idx - 1;

        if (idx < sb.length()) {
            if (sb.charAt(idx) == c) {
                return !(c == '6' || c== '9');
            } else if ((sb.charAt(idx) == '6' && c == '9') || (sb.charAt(idx) == '9' && c == '6')) {
              return n == sb.length() + 1 + idx;
            } else return false;
        }

        return true;
    }

    public static void main(String[] args) {
      UpsideDown up = new UpsideDown();

      System.out.println(up.isValid(new StringBuilder().append("116"), '9', 5));
    }
}