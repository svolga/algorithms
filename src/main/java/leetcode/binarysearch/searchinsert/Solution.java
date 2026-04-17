package leetcode.binarysearch.searchinsert;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
35. Search Insert Position
https://leetcode.com/problems/search-insert-position/

 */
public class Solution {

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int res = nums.length;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
                res = mid;
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return res;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(searchInsert(new int[]{1,3,5,6}, 5), 2);
        testing(searchInsert(new int[]{1,3,5,6}, 2), 1);
        testing(searchInsert(new int[]{1,3,5,6}, 7), 4);
    }

}
