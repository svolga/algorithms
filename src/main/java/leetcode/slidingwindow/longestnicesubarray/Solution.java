package leetcode.slidingwindow.longestnicesubarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
2401. Longest Nice Subarray
https://leetcode.com/problems/longest-nice-subarray/description/
 */
public class Solution {
    public int longestNiceSubarray(int[] nums) {

        int maxLength = 0;
        int left = 0;
        int usedBits = 0;

        for (int right = 0; right < nums.length; right++) {
            // Пока есть конфликт битов, сужаем окно слева
            while ((usedBits & nums[right]) != 0) {
                usedBits ^= nums[left];
                left++;
            }

            // Добавляем текущее число в окно
            usedBits |= nums[right];
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(longestNiceSubarray(new int[]{1, 3, 8, 48, 10}), 3);
        testing(longestNiceSubarray(new int[]{3,1,5,11,13}), 1);
    }
}
