package leetcode.bit.evenoddbits;

import java.util.Arrays;

// 2595. Number of Even and Odd Bits
// https://leetcode.com/problems/number-of-even-and-odd-bits/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {

        int n = 0;
        int[] res = evenOddBit(n);
        System.out.println(Arrays.toString(res));
    }

    public int[] evenOddBit(int n) {
        int[] out = new int[2];

        int i = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (i % 2 == 0) {
                    out[0]++;
                } else {
                    out[1]++;
                }
            }
            i++;
            n = n >> 1;
        }

        return out;
    }

}
