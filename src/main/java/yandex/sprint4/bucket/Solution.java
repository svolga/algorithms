package java.yandex.sprint4.bucket;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    private void run(String[] args) {


        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        print(nums);
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }

        print(nums);

        String abc = "abc";

        for (char c : abc.toCharArray()) {

        }

        for (char c : abc.toCharArray()) {
            System.out.println(c + " --> " + (int) c);
        }

        /*
        int k = "temp".hashCode();
        int t = (String.valueOf(k)).hashCode();
*/
    }


    private double rest(int x, int y) {
        return Math.floorMod(x, y);
    }

}
