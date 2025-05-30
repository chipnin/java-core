package algorithm.dp;

import java.util.Arrays;

/**
 * Issue in https://leetcode.com/problems/jump-game/?envType=problem-list-v2&envId=dynamic-programming
 */
public class JumpGame {
    public static void main(String[] args) {
        int[][] numArrs = {{2,3,1,1,4}, {3,2,1,0,4}, {0}, {2,0,0}, {2,0,0,1}, {2,0,1,0}};
        JumpGame.Solution solution = new JumpGame.Solution();
        for (int i = 0; i < numArrs.length; i++) {
            boolean canJump = solution.canJump(numArrs[i]);
            System.out.printf("nums = %s: result = %s\n", Arrays.toString(numArrs[i]), canJump);
        }
    }

    static class Solution {
        public boolean canJump(int[] nums) {
            int length = nums.length;
            boolean[] dp = new boolean[length];
            dp[length - 1] = true;
            for (int i = length - 2; i >= 0; i--) {
                if (nums[i] == 0 && i < length - 1) {
                    dp[i] = false;
                } else {
                    dp[i] = false;
                    for (int jump = 1; jump <= nums[i]; jump++) {
                        if (i + jump >= length - 1 || dp[i + jump]) {
                            dp[i] = true;
                            break;
                        }
                    }
                }
            }

            return dp[0];
        }
    }
}
