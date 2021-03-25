package dev.codefoundry.sort;

public class QuickSort {
  public int findKthLargestIterative(int[] a, int index) {
    int n = a.length;
    int k = n - index;

    return sortIterative(a, k);
  }

  private int sortIterative(int[] a, int k) {

    int lo = 0, hi = a.length - 1;
    while (hi > lo) {
      int j = partition(a, lo, hi);
      if (k == j)
        return a[k];

      if (k > j) {
        lo = j + 1;
      } else {
        hi = j - 1;
      }
    }
    return a[k];
  }

  private int partition(int[] a, int lo, int hi) {

    int i = lo, k = lo, j = hi + 1;
    while (true) {

      while (a[++i] < a[k]) {
        if (i >= hi)
          break;
      }
      while (a[--j] > a[k]) {
        if (j <= lo)
          break;
      }
      if (i >= j)
        break;
      swap(a, i, j);
    }
    swap(a, j, k);
    return j;
  }

  private void swap(int[] array, int i, int j) {

    if (i == j)
      return;
    int c = array[i];
    array[i] = array[j];
    array[j] = c;
  }
}
