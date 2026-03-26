package leetcode.twopointer.twosum1;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
1. Two Sum
https://leetcode.com/problems/two-sum/description/?envType=problem-list-v2&envId=hash-table
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {

        // number/position
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int key = target - nums[i];
            if (map.containsKey(key)) {
                return new int[]{map.get(key), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }

    private void testing(int[] actual, int[] expected) {
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
        testing(twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2});
    }


}
