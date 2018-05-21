package org.paukov.exercise.dynamic;

import java.util.Stack;

/**
 * Created by dpaukov on 5/21/18.
 * <p>
 * https://en.wikipedia.org/wiki/Longest_common_substring_problem
 * http://tonyz93.blogspot.com/2016/09/longest-common-substring.html
 */
public class LongestCommonSubstring {

    /**
     * Idea: DP solution
     * DP[i,j] = DP[i-1,j-1] + 1, if s1[i]==s2[j]
     * DP[i,j] = 0, if s1[i]!=s2[j]
     */
    static String lcs(String s1, String s2) {
        int max = -1;
        int max_i = -1;
        int max_j = -1;

        int[][] dp = new int[s1.length()][s2.length()];

        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if (s1.charAt(i) == s2.charAt(j)) {

                    if (i == 0 | j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }

                    if (dp[i][j] > max) {
                        max = dp[i][j];
                        max_i = i;
                        max_j = j;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        // reconstruct the LCS string
        if (max > 0) {
            Stack<Character> stack = new Stack<>();
            int i = max_i, j = max_j;
            while (i >= 0 && j >= 0 && dp[i][j] != 0) {
                stack.push(s1.charAt(i));
                i--;
                j--;
            }
            String result = "";
            while (!stack.isEmpty()) {
                result += stack.pop();
            }
            return result;
        } else {
            return "";
        }
    }

    public static void main(String[] args) {
        System.out.println("LCS('abcda','bcdabc'): " + lcs("abcda", "bcdabc"));
    }
}
