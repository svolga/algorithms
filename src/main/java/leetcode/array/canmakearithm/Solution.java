package leetcode.array.canmakearithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
1502. Can Make Arithmetic Progression From Sequence
https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/description/
 */
public class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);

        if (arr.length < 2) {
            return false;
        }

        int dif = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != dif) {
                return false;
            }
        }
        return true;
    }

    private void testing(boolean actual, boolean expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(canMakeArithmeticProgression(new int[]{3, 5, 1}), true);
        testing(canMakeArithmeticProgression(new int[]{1, 2, 4}), false);

    }
}
