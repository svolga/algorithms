package leetcode.array.gretest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
1299. Replace Elements with Greatest Element on Right Side
https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/description/
 */
public class Solution {

    public int[] replaceElements(int[] arr) {

        int[] res = new int[arr.length];
        int max = -1;
        res[arr.length - 1] = max;
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[i];
            res[i] = max;
            max = Math.max(max, temp);
        }

        return res;
    }

    private void testing(int[] actual, int[] expected) {
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(replaceElements(new int[]{17, 18, 5, 4, 6, 1}), new int[]{18, 6, 6, 6, 1, -1});
        testing(replaceElements(new int[]{400}), new int[]{-1});

    }
}
