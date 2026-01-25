package java.leetcode.dplongestincreasingsubsequence;

import java.util.Arrays;

// 300. Longest Increasing Subsequence
// https://leetcode.com/problems/longest-increasing-subsequence/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {

        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int len = lengthOfLIS(nums);
    }

    /*
    int n = a.size                     //размер исходной последовательности
       int prev[0..n - 1]
       int d[0..n - 1]

       for i = 0 to n - 1
           d[i] = 1
           prev[i] = -1
           for j = 0 to i - 1
               if (a[j] < a[i] and d[j] + 1 > d[i])
                   d[i] = d[j] + 1
                   prev[i] = j

     */
    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] prev = new int[n];
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        int max = Arrays.stream(dp).max().orElse(0);
        System.out.println(max);
        return max;

    }

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = Arrays.stream(dp).max().orElse(0);
        return max;
    }
}
