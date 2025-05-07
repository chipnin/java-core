package algorithm.dp;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://leetcode.com/problems/coin-change/
 */
public class CoinChange {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] coins = {{186,419,83,408}, {1, 2, 5}, {4, 3, 2}, {4, 3, 9}, {4, 1}};
        int[] amounts = {6249, 11, 10, 2, 0};
        for (int i = 0; i < coins.length; i++) {
            int total = solution.coinChangeDP1(coins[i], amounts[i]);
            System.out.printf("Coins = %s, amount = %d : total = %d\n", Arrays.toString(coins[i]), amounts[i], total);
        }

    }

    static class Solution {
        public int coinChangeDP1(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;

            for (int i = 1; i <= amount; i++) {
                for (int coin : coins) {
                    if (i - coin >= 0) {
                        dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                    }
                }
            }

            if (dp[amount] > amount) {
                return -1;
            }

            return dp[amount];
        }

        public int coinChangeV1(int[] coins, int amount) {
            if (amount == 0) return 0;
            int total = 0;
            Arrays.sort(coins);
            coins = reverseArray(coins);
            StringBuilder track = new StringBuilder();
            for (int i = 0; i < coins.length; i++) {
                int div = amount / coins[i];
                int mod = amount % coins[i];
                if (div == 0) {
                    total = 0;
                    continue;
                }
                total += div;
                track.append(div).append(" x ").append(coins[i]);
                if (mod == 0) {
                    System.out.printf("Tracking %s\n", track);
                    return total;
                }

                for (int j = i + 1; j < coins.length; j++) {
                    int div2 = mod / coins[j];
                    int mod2 = mod % coins[j];
                    if (div2 == 0) {
                        continue;
                    }
                    track.append(" + ").append(div2).append(" x ").append(coins[j]);
                    total += div2;
                    if (mod2 == 0) {
                        System.out.printf("Tracking %s\n", track);
                        return total;
                    }
                    mod = mod2;
                }
            }

            return -1;
        }

        private int[] reverseArray(int[] arr) {
            return IntStream.range(0, arr.length)
                    .map(i -> arr[arr.length - 1 - i])
                    .toArray();
        }
    }
}
