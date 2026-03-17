package leetcode.prefixsum.subarray;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

560. Subarray Sum Equals K
https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int running = 0;
        int total = 0;

        Map<Integer, Integer> sumFrequency = new HashMap<>();
        sumFrequency.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            running += nums[i];
            int targetSum = running - k;

            if (sumFrequency.containsKey(targetSum)) {
                total += sumFrequency.get(targetSum);
            }

            sumFrequency.put(running, sumFrequency.getOrDefault(running, 0) + 1);
        }

        return total;
    }


    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
//        testing(subarraySum(new int[]{1,1,1}, 2), 2);
//        testing(subarraySum(new int[]{1,2,3}, 3), 2);
        testing(subarraySum(new int[]{2,2,-4,1,1,2}, -3), 1);
    }


}
