package leetcode.bit.reversebits;

// 190. Reverse Bits
// https://leetcode.com/problems/reverse-bits/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int n = 43261596;
        int res = reverseBits(n);

        System.out.println(res);
    }

    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans = ans | (n & 1);
            n >>= 1;
        }
        return ans;

    }
}
