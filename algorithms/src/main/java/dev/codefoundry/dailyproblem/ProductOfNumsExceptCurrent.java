package dev.codefoundry.dailyproblem;

import java.util.Arrays;

/**
 * Given an array of integers, return a new array such that each element at
 * index i of the new array is the product of all the numbers in the original
 * array except the one at i.
 * 
 * 
 * 
 * For example, if our input was [1, 2, 3, 4, 5], the expected output would be
 * [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would
 * be [2, 3, 6].
 */
public class ProductOfNumsExceptCurrent {
  public int[] solveWithoutDiv(int[] nums) {
    int n = nums.length;
    int[] pre = new int[n];
    int[] post = new int[n];
    pre[0] = 1;
    post[n - 1] = 1;

    for (int i = 1; i < nums.length; i++) {
      pre[i - 1] *= nums[i - 1];
    }

    for (int i = n - 2; i >= 0; i--) {
      post[i + 1] *= nums[i + 1];
    }

    int[] result = new int[n];
    for (int i = 0; i < n; i++) {
      result[i] = pre[i] * post[i];
    }

    return result;
  }

  public int[] solveWithDivision(int[] nums) {
    int[] result = new int[nums.length];
    int zeroCount = 0;

    int product = 1;
    for (int num : nums) {
      if (num == 0) {
        zeroCount++;
      } else {
        product *= num;
      }
    }

    if (zeroCount > 1) {
      return result;
    }

    int i = 0;
    for (int num : nums) {
      if (num == 0) {
        result[i++] = product;
      } else {
        result[i++] = zeroCount != 0 ? 0 : product / num;
      }
    }

    return result;
  }

  public static void main(String[] args) {
    ProductOfNumsExceptCurrent pe = new ProductOfNumsExceptCurrent();
    int[] testCaseOne = new int[] { 1, 2, 3, 4, 5 };
    int[] testCaseOneExpected = new int[] { 120, 60, 40, 30, 24 };
    int[] result = pe.solveWithDivision(testCaseOne);
    if (Arrays.equals(testCaseOneExpected, result)) {
      System.out.println("Test case passes for: " + Arrays.toString(testCaseOne));
    } else {
      System.out.println("Test case failed for : " + Arrays.toString(testCaseOne));
    }

    int[] testCaseTwo = new int[] { 1, 0, 5, 6 };
    int[] testCaseTwoExpected = new int[] { 0, 30, 0, 0 };
    result = pe.solveWithDivision(testCaseTwo);

    if (Arrays.equals(testCaseTwoExpected, result)) {
      System.out.println("Test case passes for: " + Arrays.toString(testCaseTwo));
    } else {
      System.out.println(
          "Test case failed for : " + Arrays.toString(testCaseTwo) + " with result: " + Arrays.toString(result));
    }

    int[] testCaseThree = new int[] { 0, 0, 12, 1, 1 };
    int[] testCaseThreeExpected = new int[] { 0, 0, 0, 0, 0 };
    result = pe.solveWithDivision(testCaseThree);

    if (Arrays.equals(testCaseThreeExpected, result)) {
      System.out.println("Test case passes for: " + Arrays.toString(testCaseThree));
    } else {
      System.out.println(
          "Test case failed for : " + Arrays.toString(testCaseThree) + " with result: " + Arrays.toString(result));
    }

    result = pe.solveWithoutDiv(testCaseOne);
    System.out.println(Arrays.equals(testCaseOneExpected, result) ? "Test Case 1 Passed"
        : "Test case one Failed with : " + Arrays.toString(result));

    result = pe.solveWithoutDiv(testCaseTwo);
    System.out.println(Arrays.equals(testCaseTwoExpected, result) ? "Test Case 2 Passed"
        : "Test Case 2 failedwith : " + Arrays.toString(result));

    result = pe.solveWithoutDiv(testCaseThree);
    System.out.println(Arrays.equals(testCaseThreeExpected, result) ? "Tese Case 3 Passed" : "Test Case 3 Failed");

  }
}
