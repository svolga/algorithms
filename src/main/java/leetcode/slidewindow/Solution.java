package java.leetcode.slidewindow;

// Метод скользящего окна
// 643. Maximum Average Subarray I
// https://leetcode.com/problems/maximum-average-subarray-i/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int[] numbers = new int[]{1, 12, -5, -6, 50, 3};
        double average = findMaxAverage(numbers, 4);
        System.out.println(average);
    }

    private double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int res = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            res = Math.max(res, sum);
        }

        return (double) res / k;
    }

}
