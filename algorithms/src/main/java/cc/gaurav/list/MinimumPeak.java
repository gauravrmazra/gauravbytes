package cc.gaurav.list;
import java.util.ArrayList;
import java.util.Arrays;

public class MinimumPeak {
 
  // Function to return the list of
  // minimum peak elements
  static void minPeaks(ArrayList<Integer> list)
  {

      // Length of original list
      int n = list.size();

      // Initialize resultant list
      ArrayList<Integer> result
          = new ArrayList<>();

      // Traverse each element of list
      for (int i = 0; i < n; i++) {

          int min = Integer.MAX_VALUE;
          int index = -1;

          // Length of original list after
          // removing the peak element
          int size = list.size();

          // Traverse new list after removal
          // of previous min peak element
          for (int j = 0; j < size; j++) {

              // Update min and index,
              // if first element of
              // list > next element
              if (j == 0 && j + 1 < size) {

                  if (list.get(j) > list.get(j + 1)
                      && min > list.get(j)) {
                      min = list.get(j);
                      index = j;
                  }
              }

              else if (j == size - 1
                       && j - 1 >= 0) {

                  // Update min and index,
                  // if last elemnt of
                  // list > previous one
                  if (list.get(j)
                          > list.get(j - 1)
                      && min
                             > list.get(j)) {
                      min = list.get(j);
                      index = j;
                  }
              }

              // Update min and index, if
              // list has single element
              else if (size == 1) {

                  min = list.get(j);
                  index = j;
              }

              // Update min and index,
              // if current element >
              // adjacent elements
              else if (list.get(j)
                           > list.get(j - 1)
                       && list.get(j)
                              > list.get(j + 1)
                       && min
                              > list.get(j)) {

                  min = list.get(j);
                  index = j;
              }
          }

          // Remove current min peak
          // element from list
          list.remove(index);

          // Insert min peak into
          // resultant list
          result.add(min);
      }

      // Print resultant list
      System.out.println(result);
  }

  // Driver Code
  public static void main(String[] args)
  {
      // Given array arr[]
      ArrayList<Integer> arr = new ArrayList<>(
          Arrays.asList(4, 2, 5, 3, 1));

      // Function Call
      minPeaks(arr);
  }
}