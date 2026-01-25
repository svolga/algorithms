package java.leetcode.dp.countingbits;

import java.util.Arrays;

// 338. Counting Bits
// https://leetcode.com/problems/counting-bits/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {

        int n = 5;

        int[] res = countBits(n);

        System.out.println(Arrays.toString(res));

    }

    public int[] countBits(int n) {
        // f(i) := i's number of 1s in bitmask
        // f(i) = f(i / 2) + i % 2
        int[] ans = new int[n + 1];

        for (int i = 1; i <= n; ++i)
            ans[i] = ans[i / 2] + (i % 2);

        return ans;
    }

}
