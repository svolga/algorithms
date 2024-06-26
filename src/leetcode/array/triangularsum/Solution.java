package leetcode.array.triangularsum;

// 2221. Find Triangular Sum of an Array
// https://leetcode.com/problems/find-triangular-sum-of-an-array/description/
public class Solution {
    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
//        int[] nums = {1, 2, 3, 4, 5};
        int[] nums = {5};
        int res = triangularSum(nums);
        System.out.println(res);
    }
/*
You are given a 0-indexed integer array nums, where nums[i] is a digit between 0 and 9 (inclusive).

The triangular sum of nums is the value of the only element present in nums after the following process terminates:

Let nums comprise of n elements. If n == 1, end the process. Otherwise, create a new 0-indexed integer array newNums of length n - 1.
For each index i, where 0 <= i < n - 1, assign the value of newNums[i] as (nums[i] + nums[i+1]) % 10, where % denotes modulo operator.
Replace the array nums with newNums.
Repeat the entire process starting from step 1.
*/

    public int triangularSum(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int[] newNums = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            newNums[i] = (nums[i] + nums[i + 1]) % 10;
        }

        return triangularSum(newNums);
    }


}
