package leetcode.slidingwindow.maxvalue;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
1695. Maximum Erasure Value
https://leetcode.com/problems/maximum-erasure-value/description/
 */
public class Solution {

    public int maximumUniqueSubarray(int[] nums) {

        Set<Integer> subSet = new HashSet<>();

        int left = 0;
        int maxSum = 0;
        int currentSum = 0;
        for (int right = 0; right < nums.length; right++) {

            while(subSet.contains(nums[right])) {
                subSet.remove(nums[left]);
                currentSum -= nums[left];
                left++;
            }

            subSet.add(nums[right]);
            currentSum += nums[right];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(maximumUniqueSubarray(new int[]{4,2,4,5,6}), 17);
        testing(maximumUniqueSubarray(new int[]{5,2,1,2,5,2,1,2,5}), 8);
    }
}
