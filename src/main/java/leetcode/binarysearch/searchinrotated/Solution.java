package leetcode.binarysearch.searchinrotated;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
https://leetcode.com/problems/search-in-rotated-sorted-array/description/
33. Search in Rotated Sorted Array
 */
public class Solution {

    public int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid]>nums[right]) {
                left = mid + 1;
            }
            else {
                right = mid;
            }
        }

        int pivot = left;
        int result = binarySearch(nums, target, 0, pivot);
        if(result != -1){
            return result;
        }
        return binarySearch(nums, target, pivot, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int left, int right) {

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else{
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
        testing(search(new int[]{4,5,6,7,0,1,2}, 0), 4);
        testing(search(new int[]{4,5,6,7,0,1,2}, 3), -1);
        testing(search(new int[]{1}, 0), -1);
    }

}
