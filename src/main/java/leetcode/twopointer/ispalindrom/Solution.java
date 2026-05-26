package leetcode.twopointer.ispalindrom;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
https://leetcode.com/problems/valid-palindrome/description/?envType=study-plan-v2&envId=top-interview-150
125. Valid Palindrome
 */
public class Solution {

    public boolean isPalindrome(String s) {

        if (s.isEmpty()){
            return true;
        }

        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {

            char firtsChar = s.charAt(left);
            char lastChar = s.charAt(right);
            if (!Character.isLetterOrDigit(firtsChar)) {
                left++;
            } else if (!Character.isLetterOrDigit(lastChar)) {
                right--;
            } else {
                if (Character.toUpperCase(s.charAt(left)) != Character.toUpperCase(s.charAt(right))) {
                    return false;
                }
                left++;
                right--;
            }

        }

        return true;

    }

    private void testing(boolean actual, boolean expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(isPalindrome("A man, a plan, a canal: Panama"), true);
        testing(isPalindrome("race a car"), false);
        testing(isPalindrome(" "), true);
    }
}
