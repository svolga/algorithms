package leetcode.twopointer.longestpal;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
5. Longest Palindromic Substring
https://leetcode.com/problems/longest-palindromic-substring/description/
 */
public class Solution {
    public String longestPalindrome(String s) {

        int ind = 0;
        int maxLen = 0;

        for (int i = 0; i < s.length(); i++) {

            // odd
            int left = i;
            int right = i;

            while (left >= 0 && right < s.length() &&
                    s.charAt(left) == s.charAt(right)) {

                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    ind = left;
                }
                left--;
                right++;
            }

            // even
            left = i;
            right = i + 1;

            while (left >= 0 && right < s.length() &&
                    s.charAt(left) == s.charAt(right)) {

                if (right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                    ind = left;
                }
                left--;
                right++;
            }

        }
        return s.substring(ind, ind + maxLen);
    }

    private void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(longestPalindrome("babad"), "bab");
        testing(longestPalindrome("cbbd"), "bb");
    }

}
