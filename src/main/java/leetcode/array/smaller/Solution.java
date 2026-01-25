package java.leetcode.array.smaller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// 1365. How Many Numbers Are Smaller Than the Current Number
// https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int[] nums = {6,5,4,8};
        int[] res = smallerNumbersThanCurrent(nums);

        System.out.println(Arrays.toString(res));

    }

    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] res = Arrays.copyOf(nums, nums.length);
        Arrays.sort(res);

        Map<Integer, Integer> map = new HashMap<>();

        map.put(res[0], 0);
        for (int i = 1; i < res.length; i++) {
            if (!map.containsKey(res[i])) {
                map.put(res[i], i);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            res[i] = map.getOrDefault(nums[i], 0);
        }

        return res;
    }


}
