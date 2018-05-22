package org.paukov.exercise.dynamic;

/**
 * Created by dpaukov on 5/1/18.
 * 5. Longest Palindromic Substring
 * https://leetcode.com/problems/longest-palindromic-substring/description/
 *
 * Given a string s,
 * find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 * Input: "babad" Output: "bab" Note: "aba" is also a valid answer.
 *
 * Example 2: Input: "cbbd" Output: "bb"
 */
public class LongestPalindromicSubstring {

  /**
   * Idea of this DP solution: P[i][j] = P[i+1][j-1] && s[i]==s[j];
   */
  public static String longestPalindrome(String s) {
    int n = s.length();
    boolean[][] p = new boolean[n][n];

    for (int k = 0; k < n; k++) {
      int j = k;
      int i = 0;
      while ((j < n) && (i < n - k)) {
        if (i == j) {
          p[i][j] = true;
        } else if (i + 1 == j) {
          p[i][j] = s.charAt(i) == s.charAt(j);
        } else {
          p[i][j] = p[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
        }
        j++;
        i++;
      }
    }

    // search the longest
    for (int k = n - 1; k >= 0; k--) {
      int j = k;
      int i = 0;
      while ((j < n) && (i < n - k)) {
        if (p[i][j]) {
          return s.substring(i, j + 1);
        }
        j++;
        i++;
      }
    }
    return null;
  }

  public static void main(String[] args) {
    System.out.println("Longest Palindrome: " + longestPalindrome("asdfabwbalknbd"));
  }
}
