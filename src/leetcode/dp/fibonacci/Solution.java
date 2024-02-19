package leetcode.dp.fibonacci;

import java.util.ArrayList;
import java.util.List;

// 509. Fibonacci Number
// https://leetcode.com/problems/fibonacci-number/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int n = 7;
        int res = fib(n);
        System.out.println(res);
    }

    public int fib(int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        int n1 = 0;
        int n2 = 1;

        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }

        return sum;
    }


/*
    public int fib(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0, 0);
        list.add(1, 1);

        for (int i = 2; i <= n; i++) {
            list.add(i, list.get(i - 1) + list.get(i - 2));
        }

        return list.get(n);
    }
*/
}
