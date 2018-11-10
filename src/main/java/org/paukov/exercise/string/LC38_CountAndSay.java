package org.paukov.exercise.string;

/**
 * Created by dpaukov on 11/8/18.
 *
 * 38. Count and Say (Easy). https://leetcode.com/problems/count-and-say/
 *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 * 1 is read off as "one 1" or 11. 11 is read off as "two 1s" or 21. 21 is read off as "one 2, then
 * one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 *
 * Example 1: Input: 1 Output: "1"
 *
 * Example 2: Input: 4 Output: "1211"
 */
public class LC38_CountAndSay {

  static String countAndSay(int n) {
    if (n == 1) {
      return "1";
    }
    StringBuilder result = new StringBuilder();
    String s = countAndSay(n - 1);
    int k = 0;
    while (k < s.length()) {
      char c = s.charAt(k);
      int count = 1;
      int i = k + 1;
      while (i < s.length() && c == s.charAt(i)) {
        count++;
        i++;
      }
      result.append(count).append(c);
      k += count;
    }
    return result.toString();
  }

  public static void main(String[] args) {
    for (int n = 1; n <= 20; n++) {
      System.out.println( n + "): " + countAndSay(n));
    }
  }
}
