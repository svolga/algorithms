package java.leetcode.number.plusone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// 66. Plus One
// https://leetcode.com/problems/plus-one/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
//        int[] nums = {1, 5, 9};
        int[] nums = {9, 8, 0};
        int[] res = plusOne(nums);

        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(res));

    }

    public int[] plusOne(int[] digits) {
        int rest = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = digits.length - 1; i >= 0; i--) {

            int x = digits[i] + rest;
            rest = x >= 9 ? x % 9 : 0;
            x = x >= 10 ? x % 10 : x;
            list.add(x);
        }

        if (rest > 0)
            list.add(rest);

        Collections.reverse(list);
        return list.stream().mapToInt(value -> value).toArray();
    }

}
