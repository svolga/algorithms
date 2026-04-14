package leetcode.array.mindist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
1848. Minimum Distance to the Target Element
https://leetcode.com/problems/minimum-distance-to-the-target-element/description/
 */
public class Solution {

    public int getMinDistance(int[] nums, int target, int start) {

        int left = 0;
        int right = nums.length - 1;

        int min = Integer.MAX_VALUE;

        while (left <= right) {
            if (nums[left] == target) {
                min = Math.abs(Math.min(min, left - start));
            }

            if (nums[right] == target) {
                min = Math.abs(Math.min(min, right - start));
            }

            if (min == 0) {
                break;
            }

            left++;
            right--;
        }
        return min;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(getMinDistance(new int[]{1, 2, 3, 4, 5}, 5, 3), 1);
        testing(getMinDistance(new int[]{1}, 1, 0), 0);
        testing(getMinDistance(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 1, 0), 0);

    }

}
