package org.paukov.exercise.dynamic;

/**
 * Created by dpaukov on 5/18/18.
 *
 * 516. Longest Palindromic Subsequence
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 *
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the
 * maximum length of s is 1000.
 *
 * Example 1: Input: "bbbab" Output: 4 One possible longest palindromic subsequence is "bbbb".
 *
 * Example 2: Input:  "cbbd" Output: 2 One possible longest palindromic subsequence is "bb".
 */
public class LongestPalindromicSubsequence {

  /**
   * This is a classic DP approach. My suggestion is to start with the recursive version, top-down
   * version, it's easier to think that way first: - Define the top-down problem -- Give me the
   * largest palindromic subsequence between first and last indexes of the string - Define the base
   * cases -- Whenever the indexes are equal, return 1, or if the start > end index, return 0 -
   * Define the recurrence equation: - Whenever two characters are equal, then the palindrome length
   * increase by 2 + the palindrome of the inner string, which is from index start+1 to end-1 -
   * Otherwise, two characters are not equal, then the result is the max of the two possibilities:
   * inner string from start+1 to end, or start to end-1 <p> Next, realize that there are
   * overlapping subproblems and we should optimize using memoization, and add the memo array into
   * the problem. <p> Finally, you can convert to an iterative version by encoding the base cases
   * into the table and working in the opposite direction (bottom-up) from the base cases to the
   * largest case.
   *
   * https://leetcode.com/problems/longest-palindromic-subsequence/discuss/99101/Straight-forward-Java-DP-solution
   */
  public static int longestPalindromeSubseq(String s) {
    int n = s.length();
    int[][] dp = new int[n][n];

    for (int i = n - 1; i >= 0; i--) {
      dp[i][i] = 1;
      for (int j = i + 1; j < n; j++) {
        if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = dp[i + 1][j - 1] + 2;
        } else {
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[0][n - 1];
  }

  public static void main(String[] args) {
    System.out.println("Longest Palindrome Subsequenc: " + longestPalindromeSubseq("bbbab"));
  }
}
