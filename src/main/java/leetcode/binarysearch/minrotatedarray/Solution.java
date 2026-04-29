package leetcode.binarysearch.minrotatedarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*'
https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
153. Find Minimum in Rotated Sorted Array
 */
public class Solution {

    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        int pivot = left;
        int min = Math.min(nums[pivot], nums[0]);

        return min;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(findMin(new int[]{3, 4, 5, 1, 2}), 1);
        testing(findMin(new int[]{4, 5, 6, 7, 0, 1, 2}), 0);
        testing(findMin(new int[]{11, 13, 15, 17}), 11);
    }

}
