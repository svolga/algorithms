package leetcode.bit.singlenumber;

// 136. Single Number
// https://leetcode.com/problems/single-number/description/
public class Solution {
    public static void main(String[] args) {
        int [] nums = {4,1,2,1,2};
        int res = singleNumber(nums);
        System.out.println(res);
    }

    public static int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        return xor;
    }

}
