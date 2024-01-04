package leetcode.reverseinteger;

// 7. Reverse Integer
// https://leetcode.com/problems/reverse-integer/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int x = -2147;
        int reverse = reverse(x);
        System.out.println("x = " + x + "; reverse = " + reverse);
    }

    public int reverse(int x) {

        int sign = x < 0 ? -1 : 1;
        x = x < 0 ? -x : x;

        long result = 0;
        while (x > 0) {
            result = result * 10 + x % 10;
            x = x / 10;
        }

        if (result > Integer.MAX_VALUE) {
            return 0;
        }

        return (int) (sign < 0 ? -result : result);
    }

}
