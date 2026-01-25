package java.leetcode.binarysearch.searchinsertposition;

// 35. Search Insert Position
// https://leetcode.com/problems/search-insert-position/description/
public class Solution {

    public static void main(String[] args) {

        new Solution().run(args);
    }

    private void run(String[] args) {
        int[] nums = {1, 3, 5, 6};
//        int[] nums = {1, 3, 5, 6, 12, 45, 56, 76, 78, 81, 83}; //, 85, 89, 91, 93, 95, 99};
//        int[] nums = {1, 3, 5, 6};
        int pos = searchInsert(nums, 7);
        System.out.println("pos = " + pos);
    }

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (target == nums[mid]) {
                return mid;
            }

            if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

}