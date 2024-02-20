package leetcode.number.missingnumber;

import java.util.Arrays;

// 268. Missing Number
// https://leetcode.com/problems/missing-number/description/?envType=daily-question&envId=2024-02-20
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
//        int[] nums = {3, 0, 1};
//        int[] nums = {0, 1};
        int res = missingNumber(nums);
        System.out.println("missing: " + res);
    }

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

}
