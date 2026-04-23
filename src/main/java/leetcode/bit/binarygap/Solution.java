package leetcode.bit.binarygap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
868. Binary Gap
https://leetcode.com/problems/binary-gap/description/
 */
public class Solution {

    public int binaryGap(int n) {

        String s = Integer.toBinaryString(n);
        char[] chars = s.toCharArray();

// 10110
        int left = 0;
        int right = 0;
        int max = -1;

        while (right < s.length()) {
            if (chars[right] == '1') {

                if (max == -1) {
                    left = right;
                }

                max = Math.max(max, right - left);
                left = right;
            }
            right++;
        }
        return max;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(binaryGap(22), 2);
        testing(binaryGap(8), 0);
        testing(binaryGap(5), 2);
    }

}
