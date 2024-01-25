package leetcode.mediantwosortedarrays;

import java.util.Arrays;

// 4. Median of Two Sorted Arrays
// https://leetcode.com/problems/median-of-two-sorted-arrays/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        double mediana = findMedianSortedArrays(nums1, nums2);
        System.out.println("mediana = " + mediana);
    }

    private double getMedian(int[] nums) {
        int mid = nums.length / 2;

        if (nums.length % 2 == 0) {
            double val = nums[mid] + nums[mid - 1];
            val /= 2;
            return val;
        }
        return nums[mid];
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = new int[nums1.length + nums2.length];

        for (int i = 0; i < nums1.length; i++) {
            nums[i] = nums1[i];
        }

        for (int i = 0; i < nums2.length; i++) {
            nums[i + nums1.length] = nums2[i];
        }

        Arrays.sort(nums);

        return getMedian(nums);
    }


/*

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return 0;
    }
*/

}
