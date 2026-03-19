package leetcode.greedy.longestpalindrome;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
409. Longest Palindrome
https://leetcode.com/problems/longest-palindrome/description/
 */
public class Solution {

    public int longestPalindrome(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.merge(c, 1, Integer::sum);
        }

        int count = 0;
        Boolean isOdd = false;
        for (Integer value : map.values()) {
            count += (value / 2) * 2;

            if (value % 2 != 0) {
                isOdd = true;
            }
        }

        return isOdd ? count + 1 : count;
    }


    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(longestPalindrome("abccccdd"), 7);
         testing(longestPalindrome("a"), 1);
    }


}
