package leetcode.greedy.split;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

1221. Split a String in Balanced Strings

https://leetcode.com/problems/split-a-string-in-balanced-strings/description/
 */
public class Solution {

    public int balancedStringSplit(String s) {
        int balance = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if ('L' == s.charAt(i)){
                ++balance;
            }
            else{
                --balance;
            }

            if (balance == 0) {
                count++;
            }
        }
        return count;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(balancedStringSplit("RLRRLLRLRL"), 4);
        testing(balancedStringSplit("RLRRRLLRLL"), 2);
        testing(balancedStringSplit("LLLLRRRR"), 1);
    }

}
