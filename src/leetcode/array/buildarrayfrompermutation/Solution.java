package leetcode.array.buildarrayfrompermutation;

import java.util.Arrays;

// 1920. Build Array from Permutation
// https://leetcode.com/problems/build-array-from-permutation/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int[] nums = {0,2,1,5,3,4};
// [0,1,2,4,5,3]

        System.out.println(Arrays.toString(nums));

        int[] ans = buildArray(nums);
        System.out.println(Arrays.toString(ans));
    }

    public int[] buildArray(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[nums[i]];
            nums[i] = temp;

//            ans[i] = nums[nums[i]];
        }

        return nums;
    }


}
