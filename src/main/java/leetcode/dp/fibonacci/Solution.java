package leetcode.dp.fibonacci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 509. Fibonacci Number
// https://leetcode.com/problems/fibonacci-number/description/
public class Solution {

    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int num0 = 0;
        int num1 = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = num0 + num1;
            num0 = num1;
            num1 = sum;
        }
        return sum;
    }


    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(fib(2), 1);
        testing(fib(3), 2);
        testing(fib(4), 3);
        testing(fib(5), 5);
        testing(fib(6), 8);
    }

}
