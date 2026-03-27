package leetcode.twopointer.maxdist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
1855. Maximum Distance Between a Pair of Values
https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/description/
*/
public class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int max = 0;
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                max = Math.max(max, j-i);
                j++;
            }
            else{
                i++;
            }
        }
        return max;
    }


    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(maxDistance(new int[]{55, 30, 5, 4, 2}, new int[]{100, 20, 10, 10, 5}), 2);
        testing(maxDistance(new int[]{2, 2, 2}, new int[]{10, 10, 1}), 1);
        testing(maxDistance(new int[]{30, 29, 19, 5}, new int[]{25, 25, 25, 25, 25}), 2);
    }
}
