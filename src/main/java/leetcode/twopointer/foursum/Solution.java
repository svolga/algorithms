package leetcode.twopointer.foursum;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

 */
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        return null;
    }

    private void testing(List<List<Integer>> actual, List<List<Integer>> expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0), List.of(List.of(-2, -1, 1, 2), List.of(-2, 0, 0, 2), List.of(-1, 0, 0, 1)));
        testing(fourSum(new int[]{2,2,2,2,2}, 0), List.of(List.of(2,2,2,2)));
    }
}
