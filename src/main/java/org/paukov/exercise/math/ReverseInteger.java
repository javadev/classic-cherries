package org.paukov.exercise.math;

/**
 * Created by dpaukov on 5/1/18.
 * <p>
 * 7. Reverse Integer
 * <p>
 * https://leetcode.com/problems/reverse-integer/description/
 * <p>
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * <p>
 * Note:
 * Assume we are dealing with an environment which could only store integers within
 * the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {

    public int reverse(int x) {
        int result = 0;
        int div = 10;

        while (x != 0) {
            int a = x % div;
            if (result > (Integer.MAX_VALUE / 10)) {
                return 0;
            } else if (x < 0 && (result < (Integer.MIN_VALUE / 10))) {
                return 0;
            } else {
                result = result * 10 + a;
                x = x / div;
            }
        }
        return result;

    }
}
