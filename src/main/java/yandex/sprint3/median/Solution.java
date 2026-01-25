package java.yandex.sprint3.median;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// M. Золотая середина
// https://contest.yandex.ru/contest/23638/problems/M/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count1 = Integer.parseInt(reader.readLine());
            int count2 = Integer.parseInt(reader.readLine());
            StringTokenizer stz1 = new StringTokenizer(reader.readLine());
            StringTokenizer stz2 = new StringTokenizer(reader.readLine());

            int[] nums1 = new int[count1];
            for (int i = 0; i < count1; i++) {
                nums1[i] = Integer.parseInt(stz1.nextToken());
            }

            int[] nums2 = new int[count2];
            for (int i = 0; i < count2; i++) {
                nums2[i] = Integer.parseInt(stz2.nextToken());
            }

            double mediane = findMedianSortedArrays(nums1, nums2);
            System.out.println(mediane);
/*
            System.out.println(Arrays.toString(nums1));
            System.out.println(Arrays.toString(nums2));
*/

        }
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

    private double getMedian(int[] nums) {
        int mid = nums.length / 2;
        if (nums.length % 2 == 0) {
            return (nums[mid] + nums[mid - 1]) / 2.0;
        }
        return nums[mid];
    }


}
