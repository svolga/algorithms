package leetcode.twopointer.firstpalindrom;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/*
https://leetcode.com/problems/find-first-palindromic-string-in-the-array/
2108. Find First Palindromic String in the Array
 */
public class Solution {

    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }
        return "";
    }

    private boolean isPalindrome(String word) {
        int left = 0;
        int right = word.length() - 1;

        while (left <= right) {
            if (word.charAt(left) != word.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(firstPalindrome(new String[]{"abc","car","ada","racecar","cool"}), "ada");
        testing(firstPalindrome(new String[]{"notapalindrome","racecar"}), "racecar");
        testing(firstPalindrome(new String[]{"def","ghi"}), "");

    }

}
