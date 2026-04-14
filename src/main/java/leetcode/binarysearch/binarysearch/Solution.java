package leetcode.binarysearch.binarysearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
704. Binary Search
https://leetcode.com/problems/binary-search/description/
 */
public class Solution {
    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(search(new int[]{-1, 0, 3, 5, 9, 12}, 9), 4);
        testing(search(new int[]{-1, 0, 3, 5, 9, 12}, 2), -1);
    }

}
