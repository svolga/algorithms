package java.other.slidingwindow.twosum;

import java.util.Arrays;

// Два указателя
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int[] array = {1, 2, 3, 3, 5, 6, 7, 8, 9, 9};
        int target = 111;
        boolean res = twoSumSlow(array, target);
        System.out.println("array = " + Arrays.toString(array) +
                "; target = " + target + "; res = " + res);

    }

    private boolean twoSumSlow(int[] input, int targetValue) {

        int left = 0;
        int right = input.length - 1;

        while (left < right) {

            if (input[left] + input[right] == targetValue) {
                return true;
            }

            if (input[left] + input[right] < targetValue){
                left++;
            }

            if (input[left] + input[right] > targetValue){
                right--;
            }
        }

        return false;
    }

}
