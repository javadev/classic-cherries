package org.paukov.exercise.math;

/**
 * Created by dpaukov on 5/21/18.
 *
 * 343. Integer Break (Medium).
 * https://leetcode.com/problems/integer-break/description/
 *
 * Given a positive integer n, break it into the sum of at least two positive integers and
 * maximize the product of those integers. Return the maximum product you can get.
 *
 * For example,
 * given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 *
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class IntegerBreak {


  //12 81 (3+3+3+3) 36 6+6
  //11 54 (3+3+3+2) 30 5+6
  //10 36 (3+3+4) 25 5+5
  //9  27 (3+3+3) 20 4+5
  //8  18 (3+3+2) 16 4+4
  //7  12 (3+4)
  //6  9  (3+3)
  //5  6  (3+2)
  // Complexiy O(n/3)
  static int integerBreak(int n) {
    if (n == 2) {
      return 1;
    }
    if (n == 3) {
      return 2;
    }

    int d = n / 3;
    int r = n % 3;

    if (r == 1) {
      d--;
      r = 4;
    }

    int result = 1;
    for (int i = 1; i <= d; i++) {
      result *= 3;
    }

    if (r == 0) {
      return result;
    }
    return result * r;

  }

  public static void main(String[] args) {
    for (int x = 2; x <= 58; x++) {
      System.out.println("X=" + x + ": " + integerBreak(x));
    }
  }
}
