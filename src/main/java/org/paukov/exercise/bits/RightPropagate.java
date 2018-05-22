package org.paukov.exercise.bits;

/**
 * Created by dpaukov on 5/6/18.
 * <p>
 * Right propagate the rightmost set bit, e.g. 01010000 -> 01011111.
 */
public class RightPropagate {

  static int run(int x) {

    int result = x;

    // the lowest one-bit (that is 1), others are zero
    int y = x & ~(x - 1);

    while (y != 0) {
      y >>= 1;
      result |= y;
    }

    return result;
  }

  public static void main(String[] args) {
    System.out.println("Bin: " + Integer.toBinaryString(RightPropagate.run(0b01010000)));
  }
}
