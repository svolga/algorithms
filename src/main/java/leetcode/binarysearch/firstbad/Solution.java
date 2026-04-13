package leetcode.binarysearch.firstbad;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
278. First Bad Version
https://leetcode.com/problems/first-bad-version/description/
 */
public class Solution {

    public int firstBadVersion(int n) {
/*
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
 */
        return 0;
    }

    /*private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(firstBadVersion(5), 4);
        testing(firstBadVersion(15), 14);
        testing(firstBadVersion(2), 1);
        testing(firstBadVersion(1), 1);
    }*/

}
