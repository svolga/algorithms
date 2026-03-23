package leetcode.greedy.nextgreater;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
496. Next Greater Element I
https://leetcode.com/problems/next-greater-element-i/description/
 */
public class Solution {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }

        int [] result = new int[nums1.length];
        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek() ) {
                int val = stack.pop();
                int idx = map.get(val);
                result[idx] = num;
            }
            if(map.containsKey(num)){
                stack.push(num);
            }
        }

        return result;
    }

    private void testing(int[] actual, int[] expected) {
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2}), new int[]{-1,3,-1});
//        testing(nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4}), new int[]{3,-1});
    }

}
