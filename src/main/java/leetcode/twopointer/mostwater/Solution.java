package leetcode.twopointer.mostwater;

/*
11. Container With Most Water
https://leetcode.com/problems/container-with-most-water/description/
 */

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {

    public int maxArea(int[] height) {

        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {

            int h = Math.min(height[left], height[right]);
            max = Math.max(h * (right - left), max);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;

    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}), 49);
    }

}
