package leetcode.twopointer.maxdif;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
2016. Maximum Difference Between Increasing Elements
https://leetcode.com/problems/maximum-difference-between-increasing-elements/description/
 */
public class Solution {

    public int maximumDifference(int[] nums) {

        int maxDiff = -1;
        int minVal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > minVal) {
                maxDiff = Math.max(maxDiff, nums[i] - minVal);
            }
            else{
                minVal = nums[i];
            }
        }
        return maxDiff;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(maximumDifference(new int[]{7, 1, 5, 4}), 4);
        testing(maximumDifference(new int[]{9,4,3,2}), -1);
        testing(maximumDifference(new int[]{1,5,2,10}), 9);

    }
}
