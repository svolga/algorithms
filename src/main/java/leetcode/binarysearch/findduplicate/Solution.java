package leetcode.binarysearch.findduplicate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
https://leetcode.com/problems/find-the-duplicate-number/description
287. Find the Duplicate Number

 */
public class Solution {

    public int findDuplicate(int[] nums) {

        for (int num : nums) {

            int idx = Math.abs(num) - 1;
            if (nums[idx] < 0) {
                return Math.abs(num);
            }

            nums[idx] = -nums[idx];
        }
        return -1;

    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(findDuplicate(new int[]{1, 3, 4, 2, 2}), 2);
//        testing(findDuplicate(new int[]{3,1,3,4,2}), 3);
//        testing(findDuplicate(new int[]{3,3,3,3,3}), 2);

    }

}
