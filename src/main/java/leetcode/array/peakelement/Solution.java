package leetcode.array.peakelement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
// 162. Find Peak Element
// https://leetcode.com/problems/find-peak-element/description/
public class Solution {

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                right = mid;
                index = mid;
            }
            else {
                left = mid + 1;
                index = left;
            }
        }

        return index;
    }


    private static void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        System.out.println("Peak Element");
        testing(findPeakElement(new int[]{1,2,3,1}), 2);
        testing(findPeakElement(new int[]{1,2,1,3,5,6,4}), 5);
    }
}



