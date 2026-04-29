package leetcode.binarysearch.negativenums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/
1351. Count Negative Numbers in a Sorted Matrix
 */
public class Solution {

    private int getNegativeCount(int[] nums) {

        if (nums[nums.length - 1] > 0) {
            return 0;
        }

        int left = 0;
        int right = nums.length - 1;
        int firstNegativeIdx = -1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] < 0) {
                firstNegativeIdx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (firstNegativeIdx < 0) {
            return 0;
        } else {
            return nums.length - firstNegativeIdx;
        }
    }

    public int countNegatives(int[][] grid) {

        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            count += getNegativeCount(grid[i]);

        }
        return count;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(countNegatives(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1},
                {1, 1, -1, -2}, {-1, -1, -2, -3}}), 8);
        testing(countNegatives(new int[][]{{3, 2}, {1, 0}}), 0);
    }
}
