package cc.gaurav.queue;

public class TowersWithValleySegTree {

  static int peak, maxi = -1;

  // For storing segment tree
  static int[] seg = new int[4 * 500001];

  // Initialize segment tree
  static void built(int l, int r, int index, int a[]) {
    // Base Case
    if (l == r) {
      seg[index] = l;
      return;
    }

    // Get mid
    int m = l + (r - l) / 2;

    // Recurr from l to m
    built(l, m, 2 * index, a);

    // Recurr from m+1 to r
    built(m + 1, r, 2 * index + 1, a);

    if (a[seg[2 * index]] < a[seg[2 * index + 1]])
      seg[index] = seg[2 * index];
    else
      seg[index] = seg[2 * index + 1];
  }

  // Query to find minimum value index
  // between l and r
  static int query(int l, int r, int s, int e, int index, int a[]) {
    // If segment is invalid
    if (s > r || e < l)
      return -1;

    // If segment is inside the
    // desired segment
    if (s >= l && e <= r)
      return seg[index];

    // Find the mid
    int m = s + (e - s) / 2;

    // Recurr for the left
    int d1 = query(l, r, s, m, 2 * index, a);

    // Recurr for the right
    int d2 = query(l, r, m + 1, e, 2 * index + 1, a);

    // Update the query
    if (d1 == -1)
      return d2;
    if (d2 == -1)
      return d1;
    if (a[d1] < a[d2])
      return d1;
    else
      return d2;
  }

  // Function for finding the optimal peak
  static void optimalPeak(int l, int r, int value, int n, int a[]) {
    if (l > r)
      return;

    // Check if its the peak
    if (l == r) {

      // Update the value for the
      // maximum sum
      if (value + a[l] > maxi) {
        maxi = a[l] + value;
        peak = l;
        return;
      }
      return;
    }

    // Index of minimum element in
    // l and r
    int indexmini = query(l, r, 0, n - 1, 1, a);

    int value1 = a[indexmini] * (indexmini - l + 1);

    // Recurr right of minimum index
    optimalPeak(indexmini + 1, r, value + value1, n, a);

    // Update the max and peak value
    if (indexmini + 1 > r) {
      if (value + value1 > maxi) {
        maxi = value + value1;
        peak = indexmini;
      }
    }

    int value2 = a[indexmini] * (r - indexmini + 1);

    // Recurr left of minimum index
    optimalPeak(l, indexmini - 1, value + value2, n, a);

    // Update the max and peak value
    if (l > indexmini - 1) {
      if (value + value2 > maxi) {
        maxi = value + value2;
        peak = l;
      }
    }
  }

  // Print maximum sum and the array
  static void maximumSum(int a[], int n) {
    // Initialize segment tree
    built(0, n - 1, 1, a);

    // Get the peak
    optimalPeak(0, n - 1, 0, n, a);

    // Store the required array
    int[] ans = new int[n];
    ans[peak] = a[peak];

    // Update the ans[]
    for (int i = peak + 1; i < n; i++) {
      ans[i] = Math.min(ans[i - 1], a[i]);
    }

    for (int i = peak - 1; i >= 0; i--) {
      ans[i] = Math.min(a[i], ans[i + 1]);
    }

    // Find the maximum sum
    int sum = 0;
    for (int i = 0; i < n; i++) {
      sum += ans[i];
    }

    // Print sum and optimal array
    System.out.print("Sum = " + sum + "\n");

    System.out.print("Final Array = ");
    for (int i = 0; i < n; i++) {
      System.out.print(ans[i] + " ");
    }
  }

  // Drive Code
  public static void main(String[] args) {
    // Given array
    int arr[] = { 1, 2, 1, 2, 1, 3, 1 };

    int N = arr.length;

    // Function Call
    maximumSum(arr, N);

  }
}
