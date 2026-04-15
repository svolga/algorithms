package leetcode.binarysearch.maxcount;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
2529. Maximum Count of Positive Integer and Negative Integer
https://leetcode.com/problems/maximum-count-of-positive-integer-and-negative-integer/description/
 */
public class Solution {

    public int maximumCount(int[] nums) {
        int n = nums.length;

        // Binary search to find the first non-negative number (>= 0)
        // Feasible condition: nums[mid] >= 0
        int left = 0;
        int right = n - 1;
        int firstNonNegative = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= 0) {
                firstNonNegative = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // Count of negative numbers
        int negativeCount;
        if (firstNonNegative == -1) {
            negativeCount = n;  // All elements are negative
        } else {
            negativeCount = firstNonNegative;
        }

        // Binary search to find the first positive number (> 0)
        // Feasible condition: nums[mid] > 0
        left = 0;
        right = n - 1;
        int firstPositive = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > 0) {
                firstPositive = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        // Count of positive numbers
        int positiveCount;
        if (firstPositive == -1) {
            positiveCount = 0;  // No positive elements
        } else {
            positiveCount = n - firstPositive;
        }

        return Math.max(negativeCount, positiveCount);
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
//        testing(maximumCount(new int[]{-2, -1, -1, 1, 2, 3}), 3);
//        testing(maximumCount(new int[]{-3, -2, -1, 0, 0, 1, 2}), 3);
//        testing(maximumCount(new int[]{5, 20, 66, 1314}), 4);
        testing(maximumCount(new int[]{-4, -3, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}), 8);
    }
}
