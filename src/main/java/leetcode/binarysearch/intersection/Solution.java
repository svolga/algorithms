package leetcode.binarysearch.intersection;

/*
https://leetcode.com/problems/intersection-of-two-arrays/description/
349. Intersection of Two Arrays
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class Solution {
/*

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        if (nums1.length > nums2.length) {
            for (int num : nums2) {
                checkIfExists(set, nums1, num);
            }
        } else {
            for (int num : nums1) {
                checkIfExists(set, nums2, num);
            }
        }

        return set.stream().mapToInt(i -> i).toArray();
    }

    private void checkIfExists(Set<Integer> set, int[] nums, int target) {
        if (set.contains(target)) {
            return;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                set.add(target);
                return;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

    }
*/

    public int[] intersection(int[] nums1, int[] nums2) {

        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        List<Integer> intersection = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                intersection.add(num);
                set.remove(num);
            }
        }

        return intersection.stream().mapToInt(i -> i).toArray();
    }


    private void testing(int[] actual, int[] expected) {
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}), new int[]{2});
        testing(intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}), new int[]{9, 4});
    }

}





