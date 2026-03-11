package leetcode.array.duplicate2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
219. Contains Duplicate II

https://leetcode.com/problems/contains-duplicate-ii/description/
 */
public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> prevs = map.getOrDefault(nums[i], new ArrayList<>());
            for (int j = 0; j < prevs.size(); j++) {
                if (Math.abs(prevs.get(j) - i) <= k) {
                    return true;
                }
            }
            prevs.add(i);
            map.put(nums[i], prevs);
        }

        return false;
    }

    private void testing(boolean actual, boolean expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3), true);
        testing(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1), true);
        testing(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2), false);
        testing(containsNearbyDuplicate(new int[]{99, 99}, 2), true);
    }

}
