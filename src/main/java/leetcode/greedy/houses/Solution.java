package leetcode.greedy.houses;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
2078. Two Furthest Houses With Different Colors
https://leetcode.com/problems/two-furthest-houses-with-different-colors/description/
 */
public class Solution {

    // [1,1,1,6,1,1,1]
    public int maxDistance(int[] colors) {
        int i = 0;
        int max1 = 0;
        int j = colors.length - 1;
        int leftValue = colors[0];
        while (j >= 0) {
            if (colors[j] != leftValue) {
                max1 = j - i;
                break;
            }
            else{
                j--;
            }
        }

        int max2 = 0;
        i = 0;
        j = colors.length - 1;
        int rightValue = colors[j];
        while (i < colors.length) {
            if (colors[i] != rightValue) {
                max2 = j - i;
                break;
            }
            else{
                i++;
            }
        }

        return Math.max(max1, max2);
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(maxDistance(new int[]{1, 1, 1, 6, 1, 1, 1}), 3);
        testing(maxDistance(new int[]{1, 8, 3, 8, 3}), 4);
        testing(maxDistance(new int[]{0, 1}), 1);
    }
}
