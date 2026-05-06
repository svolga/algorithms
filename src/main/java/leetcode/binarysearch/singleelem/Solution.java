package leetcode.binarysearch.singleelem;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
https://leetcode.com/problems/single-element-in-a-sorted-array/description/
540. Single Element in a Sorted Array
 */
public class Solution {

    public int singleNonDuplicate(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1])||
                    (mid % 2 != 0 && nums[mid] == nums[mid - 1])) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left];
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8}), 2);
        testing(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11}), 10);

    }
}
