package leetcode.slidingwindow.minsize;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
209. Minimum Size Subarray Sum
https://leetcode.com/problems/minimum-size-subarray-sum/description/
 */
public class Solution {

    public int minSubArrayLen(int target, int[] nums) {

        int left = 0;
        int currSum = 0;

        int minLength = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            currSum += nums[right];
            while (currSum >= target) {
                minLength = Math.min(minLength, right - left + 1);
                currSum -= nums[left];
                left++;
            }

        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}), 2);
        testing(minSubArrayLen(4, new int[]{1, 4, 4}), 1);
        testing(minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}), 0);
    }

}
