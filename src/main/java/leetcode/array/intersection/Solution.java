package leetcode.array.intersection;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;


import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
350. Intersection of Two Arrays II
https://leetcode.com/problems/intersection-of-two-arrays-ii/
 */
public class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        ArrayList<Integer> list = new ArrayList<>();
        while (i <= nums1.length - 1 && j <= nums2.length - 1) {

            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            }

        }

        return list.stream().mapToInt(x -> x).toArray();
    }

    private void testing(int[] actual, int[] expected) {
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}), new int[]{2, 2});
        testing(intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}), new int[]{4, 9});
    }


}
