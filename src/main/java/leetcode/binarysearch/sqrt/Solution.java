package leetcode.binarysearch.sqrt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
69. Sqrt(x)
https://leetcode.com/problems/sqrtx/description/
 */
public class Solution {

    public int mySqrt(int x) {

        if (x < 2) {
            return x;
        }

        long left = 0;
        long right = x;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            if (mid * mid > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return (int)right;

    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
//        testing(mySqrt(4), 2);
//        testing(mySqrt(8), 2);
        testing(mySqrt(2147395599), 46339);

    }

}
