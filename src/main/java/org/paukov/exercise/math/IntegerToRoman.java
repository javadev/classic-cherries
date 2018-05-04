package org.paukov.exercise.math;

import java.util.Stack;

/**
 * Created by dpaukov on 5/3/18.
 * <p>
 * 12. Integer to Roman.
 * https://leetcode.com/problems/integer-to-roman/description/
 * <p>
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII,
 * which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right.
 * However, the numeral for four is not IIII. Instead, the number four is written as IV.
 * Because the one is before the five we subtract it making four. The same principle applies to the number nine,
 * which is written as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * <p>
 * Input: 3
 * Output: "III"
 * <p>
 * Example 2:
 * <p>
 * Input: 4
 * Output: "IV"
 * <p>
 * Example 3:
 * <p>
 * Input: 9
 * Output: "IX"
 * <p>
 * Example 4:
 * <p>
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, XXX = 30 and III = 3.
 * <p>
 * Example 5:
 * <p>
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class IntegerToRoman {

    static String romanMap(int base, int degree) {
        if (base == 1 && degree == 0) {
            return "I";
        }
        if (base == 1 && degree == 1) {
            return "X";
        }
        if (base == 1 && degree == 2) {
            return "C";
        }
        if (base == 1 && degree == 3) {
            return "M";
        }
        if (base == 5 && degree == 0) {
            return "V";
        }
        if (base == 5 && degree == 1) {
            return "L";
        }
        if (base == 5 && degree == 2) {
            return "D";
        }
        return "";
    }

    static String roman(int digit, int degree) {
        StringBuilder sb = new StringBuilder();
        if (digit > 0 && digit <= 3) {
            String base1 = romanMap(1, degree);
            for (int i = 0; i < digit; i++) {
                sb.append(base1);
            }
            return sb.toString();
        }
        if (digit == 4) {
            String base1 = romanMap(1, degree);
            String base5 = romanMap(5, degree);
            sb.append(base1);
            sb.append(base5);
            return sb.toString();
        }
        if (digit == 5) {
            String base5 = romanMap(5, degree);
            sb.append(base5);
            return sb.toString();
        }
        if (digit > 5 && digit <= 8) {
            String base1 = romanMap(1, degree);
            String base5 = romanMap(5, degree);
            sb.append(base5);
            for (int i = 1; i <= digit - 5; i++) {
                sb.append(base1);
            }
            return sb.toString();
        }
        if (digit == 9) {
            String base1 = romanMap(1, degree);
            String base10 = romanMap(1, degree + 1);
            sb.append(base1);
            sb.append(base10);
            return sb.toString();
        }
        return "";
    }

    public static String intToRoman(int num) {
        Stack<String> stack = new Stack<>();
        int degree = 0;
        while (num > 0) {
            int digit = num % 10;
            stack.push(roman(digit, degree));
            num = num / 10;
            degree++;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
