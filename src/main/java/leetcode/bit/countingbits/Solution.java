package java.leetcode.bit.countingbits;

import java.util.Arrays;

// 338. Counting Bits
// https://leetcode.com/problems/counting-bits/description/
public class Solution {
    public static void main(String[] args) {
        new Solution().run(args);
    }
/*
Input: n = 5
Output: [0,1,1,2,1,2]
Explanation:
0 --> 0
1 --> 1
2 --> 10
3 --> 11
4 --> 100
5 --> 101
 */

    private void run(String[] args) {
        int n = 5;
        int[] bits = countBits(n);
        System.out.println(Arrays.toString(bits));
    }


    private int countOnes(int n) {
        int counter = 0;
        while (n > 0) {
            counter += n % 2;
            n = n >> 1;
        }
        return counter;

    }

    public int[] countBits(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }
}
