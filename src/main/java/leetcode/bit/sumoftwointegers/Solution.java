package java.leetcode.bit.sumoftwointegers;

// 371. Sum of Two Integers
// https://leetcode.com/problems/sum-of-two-integers/description/
public class Solution {
    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int a = 2;
        int b = 3;
        int res = getSum(a, b);

        System.out.println(String.format("%d + %d = %d", a, b, res));
    }

    public int getSum(int a, int b) {
        int withoutCarry = a ^ b;
        int carry = (a & b) << 1;
        if (carry == 0) {
            return withoutCarry;
        }
        return getSum(withoutCarry, carry);
    }

}
