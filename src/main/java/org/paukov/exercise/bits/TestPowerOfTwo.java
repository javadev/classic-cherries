package org.paukov.exercise.bits;

/**
 * Created by dpaukov on 5/6/18.
 * <p>
 * Test if x is a power of 2. Evaluates to true for 1, 2, 4, 8,..., false for all other values
 */
public class TestPowerOfTwo {

    // Power of 2 has only one 1 in its binary representation
    static boolean isPowerOfTwo(int x) {

        // the lowest bit that is 1
        int y = x & ~(x - 1);

        if (y == 0) {
            return false;
        }

        // unset the lowest bit 1 from the original x
        x = x ^ y;

        // calculate new lowest bit that is 1
        y = x & ~(x - 1);

        return y == 0;
    }

    public static void main(String[] args) {
        for (int i = -9; i < 18; i++) {
            System.out.println(i + ": " + TestPowerOfTwo.isPowerOfTwo(i));
        }
    }

}
