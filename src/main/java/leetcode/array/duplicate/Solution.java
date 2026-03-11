package leetcode.array.duplicate;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
217. Contains Duplicate
https://leetcode.com/problems/contains-duplicate/description/?envType=problem-list-v2&envId=hash-table
 */
public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    private void testing(boolean actual, boolean expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(containsDuplicate(new int[]{1, 2, 3, 1}), true);
        testing(containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}), true);
        testing(containsDuplicate(new int[]{1,2,3,4}), false);
    }

}
