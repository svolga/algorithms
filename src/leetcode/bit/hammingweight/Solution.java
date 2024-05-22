package leetcode.bit.hammingweight;

// 191. Number of 1 Bits
// https://leetcode.com/problems/number-of-1-bits/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        Integer n = 128;
        int w = hammingWeight(n);

        String str = Integer.toBinaryString(n);
        System.out.println(str);
        System.out.println(w);
    }

    public int hammingWeight(int n) {
        return (int)Integer.toBinaryString(n).chars().filter(value -> value == '1').count();
    }
}
