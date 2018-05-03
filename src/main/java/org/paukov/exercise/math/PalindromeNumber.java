package org.paukov.exercise.math;

/**
 * 9. Palindrome Number
 * https://leetcode.com/problems/palindrome-number/description/
 * <p>
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads
 * the same backward as forward.
 * <p>
 * Example 1:
 * <p>
 * Input: 121
 * Output: true
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-.
 * Therefore it is not a palindrome.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * Follow up:
 * <p>
 * Could you solve it without converting the integer to a string?
 */
public class PalindromeNumber {

    private int pow10(int p) {
        int res = 1;
        for (int i = 0; i < p; i++) {
            res *= 10;
        }
        return res;
    }

    public boolean isPalindrome(int value) {
        if (value < 0) return false;
        int n = (int) Math.log10(value) + 1;
        int lvalue = value;
        for (int i = 1; i < n; i++) {
            int pow = pow10(n - i);
            int l = lvalue / pow;
            lvalue = lvalue % pow;
            int rvalue = value;
            int j = 0;
            int r = -1;
            while (j < i) {
                r = rvalue % 10;
                rvalue /= 10;
                j++;
            }
            if (l != r) return false;
        }
        return true;
    }
}
