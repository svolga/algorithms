package leetcode.prefixsum.rangesum;

/*
303. Range Sum Query - Immutable
https://leetcode.com/problems/range-sum-query-immutable/description/

 */

public class NumArray {

    int[] prefixSum;

    public NumArray(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

    }

    public int sumRange(int left, int right) {
        if (left ==0) {
            return prefixSum[right] ;
        }
        return prefixSum[right] - prefixSum[left-1];
    }

    public static void main(String[] args) {

        int[] nums = new int[]{-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        int sum  = numArray.sumRange(1, 3);

        System.out.println(sum);

    }

}
