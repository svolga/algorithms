package leetcode.slidingwindow.maxaverage;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
643. Maximum Average Subarray I
https://leetcode.com/problems/maximum-average-subarray-i/description/

 */
public class Solution {
    public double findMaxAverage(int[] nums, int k) {

        int maxSum = 0;
        for (int i = 0; i < k; i++) {
            maxSum += nums[i];
        }

        int sum = maxSum;
        int i = 0;
        while (i + k < nums.length) {
            sum = sum - nums[i] + nums[i + k];
            maxSum = Math.max(maxSum, sum);
            i++;
        }

        return (double)maxSum / k;
    }

    private void testing(double actual, double expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
//        testing(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4), 12.75000);
        testing(findMaxAverage(new int[]{5}, 1), 5.00000);

    }


}
