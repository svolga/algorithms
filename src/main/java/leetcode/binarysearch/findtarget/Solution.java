package leetcode.binarysearch.findtarget;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
2089. Find Target Indices After Sorting Array
https://leetcode.com/problems/find-target-indices-after-sorting-array/description/
 */
public class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                result.add(i);
            }
        }

        return result;
    }

    private void testing(List<Integer> actual, List<Integer> expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(targetIndices(new int[]{1, 2, 5, 2, 3}, 2), List.of(1, 2));
        testing(targetIndices(new int[]{1, 2, 5, 2, 3}, 3), List.of(3));
        testing(targetIndices(new int[]{1, 2, 5, 2, 3}, 5), List.of(4));
    }
}
