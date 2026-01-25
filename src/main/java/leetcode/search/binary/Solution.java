package java.leetcode.search.binary;

import java.util.Arrays;

// 704. Binary Search
// https://leetcode.com/problems/binary-search/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {

        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 2;

/*
        int[] nums = {5};
        int target = 5;
*/

        System.out.println(Arrays.toString(nums));
        int out = search(nums, target);
        System.out.println("out = " + out);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == nums[mid]) {
                return mid;
            }

            if (target >= nums[left] && target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

}
