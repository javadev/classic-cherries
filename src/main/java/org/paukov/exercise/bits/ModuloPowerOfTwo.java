package org.paukov.exercise.bits;

/**
 * Created by dpaukov on 5/6/18.
 * <p>
 * Compute x modulo a power of two, e.g. returns 13 for 77 mod 64.
 */
public class ModuloPowerOfTwo {

    static int run(int x) {

        assert x > 0;

        int x_copy = x;
        int mask = 0;

        // the lowest one-bit
        int y = x_copy & ~(x_copy - 1);

        // move to the left to find the highest one-bit (mask)
        while (y != 0) {
            mask = y;
            x_copy = x_copy ^ y;
            y = x_copy & ~(x_copy - 1);
        }

        if (mask != 0) {
            return x & ~mask;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println("Modulo 77: " + ModuloPowerOfTwo.run(77)); // 13
        System.out.println("Modulo 34: " + ModuloPowerOfTwo.run(34)); // 2
        System.out.println("Modulo 3: " + ModuloPowerOfTwo.run(3)); // 1
        System.out.println("Modulo 1: " + ModuloPowerOfTwo.run(1)); // 0
        System.out.println("Modulo 0: " + ModuloPowerOfTwo.run(0)); // 0
    }
}
