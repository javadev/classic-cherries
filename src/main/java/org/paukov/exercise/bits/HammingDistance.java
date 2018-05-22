package org.paukov.exercise.bits;


/**
 * Created by dpaukov on 3/18/18.
 * <p>
 * The Hamming distance between two integers is the number of positions at which the corresponding
 * bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note: 0 ≤ x, y < 2^31.
 * <p>
 * Example:
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 * <p>
 * https://leetcode.com/problems/hamming-distance/description/
 */
public class HammingDistance {

  public static int hammingDistance(int x, int y) {
    int xor = x ^ y;
    int result = 0;
    while (xor != 0) {
      if ((xor & 1) == 1) {
        result++;
      }
      xor >>= 1;
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println("Distance of (2, 4): " + hammingDistance(2, 4));
    System.out.println("Distance of (7, 8): " + hammingDistance(7, 8));
    System.out.println("Distance of (63, 0): " + hammingDistance(63, 0));
  }
}
