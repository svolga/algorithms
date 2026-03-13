package leetcode.dp.jump;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
55. Jump Game
https://leetcode.com/problems/jump-game/description/?envType=problem-list-v2&envId=greedy
// 2, 3, 1, 1, 4
*/
public class Solution {

    public boolean canJump(int[] nums) {

        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > end) {
                return false;
            }

            end = Math.max(end, i + nums[i]);
        }
        return true;

    }

    private void testing(boolean actual, boolean expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(canJump(new int[]{2, 3, 1, 1, 4}), true);
//        testing(canJump(new int[]{3, 2, 1, 0, 4}), false);
        //       testing(canJump(new int[]{0}), true);
//        testing(canJump(new int[]{1}), true);
    }

}
