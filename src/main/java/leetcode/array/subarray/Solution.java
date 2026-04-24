package leetcode.array.subarray;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
2395. Find Subarrays With Equal Sum
https://leetcode.com/problems/find-subarrays-with-equal-sum/description/
 */
public class Solution {
    public boolean findSubarrays(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (set.contains(sum)) {
                return true;
            }
            set.add(sum);
        }
        return false;
    }

    private void testing(boolean actual, boolean expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(findSubarrays(new int[]{4, 2, 4}), true);
//        testing(findSubarrays(new int[]{1,2,3,4,5}), true);
//        testing(findSubarrays(new int[]{0,0,0}), true);

    }

}
