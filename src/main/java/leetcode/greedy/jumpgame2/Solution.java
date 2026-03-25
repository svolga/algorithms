package leetcode.greedy.jumpgame2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
45. Jump Game II
https://leetcode.com/problems/jump-game-ii/description/
 */
public class Solution {

    public int jump(int[] nums) {

        int left = 0;
        int right = 0;
        int step = 0;

        while (right < nums.length - 1) {

            int maxStep = 0;
            for (int i = left; i < right+1; i++) {
                maxStep = Math.max(maxStep, i + nums[i]);
            }

            left = right + 1;
            right = maxStep;
            step++;
        }
        return step;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(jump(new int[]{2,3,1,1,4}), 2);
        testing(jump(new int[]{2,3,0,1,4}), 2);

    }
}
