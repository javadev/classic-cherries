package org.paukov.exercise.dynamic;

/**
 * Created by dpaukov on 5/31/18.
 *
 * 518. Coin Change 2 (Medium).
 * https://leetcode.com/problems/coin-change-2/description/
 *
 * You are given coins of different denominations and a total amount of money. Write a function to
 * compute the number of combinations that make up that amount. You may assume that you have
 * infinite number of each kind of coin.
 *
 * Note: You can assume that:
 *
 * 0 <= amount <= 5000; 1 <= coin <= 5000; the number of coins is less than 500; the answer is
 * guaranteed to fit into signed 32-bit integer.
 *
 * Example 1: Input: amount = 5, coins = [1, 2, 5] Output: 4 Explanation: there are four ways to
 * make up the amount: 5=5 5=2+2+1 5=2+1+1+1 5=1+1+1+1+1
 *
 * Example 2: Input: amount = 3, coins = [2] Output: 0 Explanation: the amount of 3 cannot be made
 * up just with coins of 2.
 *
 * Example 3: Input: amount = 10, coins = [10] Output: 1
 */
public class LC518CoinChange2 {

  /**
   * Dynamic programming solution: dp[i] represents an answer for amount i (the number of
   * combinations that make up that amount). For each amount (i) in the dp array and coin in coins
   * array: if (i > coin) then dp[i] = dp[i] + dp[i-coin];
   *
   * The answer is in the dp[amount].
   *
   * https://leetcode.com/problems/coin-change-2/discuss/99212/Knapsack-problem-Java-solution-with-thinking-process-O(nm)-Time-and-O(m)-Space
   * https://leetcode.com/problems/coin-change-2/discuss/99222/Video-explaining-how-dynamic-programming-works-with-the-Coin-Change-problem
   * https://www.youtube.com/watch?v=jaNZ83Q3QGc
   */
  static int change(int amount, int[] coins) {
    int[] dp = new int[amount + 1];
    dp[0] = 1;
    for (int coin : coins) {
      for (int i = coin; i <= amount; i++) {
        dp[i] += dp[i - coin];
      }
    }
    return dp[amount];
  }

  public static void main(String[] args) {
    System.out.println("Change 5, [1,2,5]: " + change(5, new int[]{1, 2, 5}));
  }

}
