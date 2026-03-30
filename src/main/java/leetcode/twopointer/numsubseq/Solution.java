package leetcode.twopointer.numsubseq;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
1498. Number of Subsequences That Satisfy the Given Sum Condition
https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/
 */
public class Solution {

    public int numSubseq(int[] nums, int target) {

        Arrays.sort(nums);

        int mod = 1000000007;
        int res = 0;
        int right = nums.length - 1;

        for (int i = 0; i < nums.length; i++) {

            while (i <= right && nums[i] + nums[right] > target) {
                right--;
            }

            if (i <= right) {
                res = (res + power(2, right - i, mod)) % mod;
            }


        }
        return res;

    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(numSubseq(new int[]{3, 5, 6, 7}, 9), 4);
        testing(numSubseq(new int[]{3, 3, 6, 8}, 10), 6);
        testing(numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12), 61);
    }

    private int power(int base, int exp, int mod) {
        long result = 1, b = base;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * b) % mod;
            b = (b * b) % mod;
            exp >>= 1;
        }
        return (int) result;
    }

}
