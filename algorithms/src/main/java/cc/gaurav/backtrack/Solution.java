package cc.gaurav.backtrack;

import java.util.*;

public class Solution {

  /*
   * public class MaxSumSubarray {
   * 
   * public static int[] maxSumSubarray(int[] array) { // implement me // { -4, 2,
   * -9, 5, -2, 3, 2, -6 }. {1, 2} // start, end // max = -4, running = -4 // idx
   * 1 // running = -4 + 2 // max = -2 // if (running < nums[idx]) // running =
   * nums[idx]; // max = max
   * 
   * //{1, 2} // max = 1 // running = 1 idx = 1 // running += nums[idx] -> 3
   * //max(max, running) // if (running < nums[idx]) 3 < 2 running = nums[idx];
   * start = idx; end = start;
   * 
   * end++;
   * 
   * 
   * 
   * return new int[] {}; }
   * 
   * public static void main(String[] args) { System.out.println( Arrays.toString(
   * maxSumSubarray(new int[] { -4, 2, -9, 5, -2, 3, 2, -6 }) ) ); }
   * 
   * }
   */

  public static class Employee {
    public final int id;
    public final Employee manager;

    public Employee(int id, Employee manager) {
      this.id = id;
      this.manager = manager;
    }

    public String toString() {
      return Integer.toString(id);
    }

    // equals
    // hasCode
  }

  public static Employee findCommonManager(Employee first, Employee second) {
    if (first == null || second == null)
      return null;

    if (first.id == second.id)
      return first.manager;

    // Employee managerA = new Employee(1);
    // Employee managerA1 = new Employee(1);
    List<Employee> hierechyOfFirst = getHierechy(first);

    List<Employee> hierechyOfSecond = getHierechy(second);
    int idxOfFirst = hierechyOfFirst.size() - 1;
    int idxOfSecond = hierechyOfSecond.size() - 1;
    while (idxOfFirst >= 0 && idxOfSecond >= 0) {
      if (hierechyOfFirst.get(idxOfFirst).id == hierechyOfSecond.get(idxOfSecond).id) {
        idxOfFirst--;
        idxOfSecond--;
      } else
        break;
    }

    Employee commonManager = hierechyOfSecond.get(idxOfFirst + 1);

    return (commonManager.id == first.id || commonManager.id == second.id) ? null : commonManager;
  }

  private static List<Employee> getHierechy(Employee e) {
    List<Employee> hiererchies = new ArrayList<>();

    while (e != null) {
      hiererchies.add(e);
      e = e.manager;
    }

    return hiererchies;
  }

  public static void main(String args[]) {
    Employee ceo = new Employee(1, null);
    Employee vp = new Employee(11, ceo);
    Employee director = new Employee(6, vp);
    Employee manager = new Employee(13, director);
    Employee dev = new Employee(2, manager);
    Employee otherManager = new Employee(16, director);
    Employee otherDev = new Employee(17, otherManager);

    System.out.println(findCommonManager(dev, otherDev));

    System.out.println(findCommonManager(ceo, director));
  }

  public int[] evenOddSort(int[] arr) {
    int i = 0;
    int j = arr.length - 1;

    while (i <= j) {
      if (arr[i] % 2 == 0) {
        int jth = arr[j];
        arr[j] = arr[i];
        arr[i] = jth;
        j--;
      } else {
        i++;
      }
    }

    return arr;
  }

}
