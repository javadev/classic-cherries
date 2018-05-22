package org.paukov.exercise.math;

/**
 * Created by dpaukov on 5/2/18.
 * <p>
 * Convert String to Integer.
 * <p>
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 * <p>
 * Implement atoi which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary until the first
 * non-whitespace character is found. Then, starting from this character, takes an optional
 * initial plus or minus sign followed by as many numerical digits as possible, and interprets
 * them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number, which are
 * ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or
 * if no such sequence exists because either str is empty or it contains only whitespace characters,
 * no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * <p>
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within
 * the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of
 * the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "42"
 * Output: 42
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * <p>
 * <p>
 * Example 4:
 * <p>
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * <p>
 * <p>
 * Example 5:
 * <p>
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−231) is returned.
 */
public class String2Integer {

  public static int myAtoi(String str) {
    int result = 0;
    int pos = 0;
    int sign = 1;
    int len = str.length();

    if (len == 0) {
      return 0;
    }

    while (pos < len && str.charAt(pos) == ' ') {
      pos++;
    }

    if (pos < len && str.charAt(pos) == '-') {
      sign = -1;
      pos++;
    } else if (pos < len && str.charAt(pos) == '+') {
      pos++;
    }

    while (pos < len && Character.isDigit(str.charAt(pos))) {
      if (Integer.MAX_VALUE / 10 >= result &&
          Integer.MAX_VALUE - Character.digit(str.charAt(pos), 10) >= result * 10) {
        result = result * 10 + Character.digit(str.charAt(pos), 10);
      } else {
        if (sign > 0) {
          return Integer.MAX_VALUE;
        } else {
          return Integer.MIN_VALUE;
        }
      }
      pos++;
    }
    return sign * result;
  }
}
