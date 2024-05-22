package other.missednumber;

// Найти пропущенное число в массиве за O(n)
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int[] nums = {1, 2, 3, 5, 6, 7};
        System.out.println(getMissedNumber(nums));
    }

    private int getMissedNumber(int[] nums) {

        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev + 1 != nums[i]) {
                return nums[i] - 1;
            }
            prev = nums[i];
        }
        return 0;

    }


}
