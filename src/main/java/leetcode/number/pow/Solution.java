package java.leetcode.number.pow;

public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        // x = 2.00000, n = 10
//        double x = 2.00000;
//        int n = 10;
        double x = 2.00000;
        int n = -2;


        double ans = myPow(x, n);

        System.out.println(ans);

    }

    public double myPow(double x, int n) {

        int i = 0;
        double ans = 1;
        int sign = n < 0 ? -1 : 1;
        n = sign * n;

        while (i < n) {
            ans = x * ans;
            i++;
        }

        return sign < 0 ? 1 / ans : ans;
    }

}
