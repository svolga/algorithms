package leetcode.prefixsum.contiguous;

/*
525. Contiguous Array
https://leetcode.com/problems/contiguous-array/description/
*/

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {

    public int findMaxLength(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }

        // count/index
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int count = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 0) {
                count--;
            } else {
                count++;
            }

            // was in this index

            if (map.containsKey(count)) {
                int index = map.get(count);
                maxLength = Math.max(maxLength, i - index);
            }
            else{
                map.put(count, i);
            }

        }

        return maxLength;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(findMaxLength(new int[]{0, 1, 1, 1, 1, 1, 0, 0, 0}), 6);
        testing(findMaxLength(new int[]{0, 1, 0}), 2);
        testing(findMaxLength(new int[]{0, 1}), 2);
    }


}
