package leetcode.dp.climbingstairs;

import org.junit.jupiter.api.Test;

/*
70. Climbing Stairs
https://leetcode.com/problems/climbing-stairs/description/?envType=study-plan-v2&envId=dynamic-programming
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[n];
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(climbStairs(1), 1);
        testing(climbStairs(2), 2);
        testing(climbStairs(3), 3);
        testing(climbStairs(4), 5);
    }

}
