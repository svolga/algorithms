package leetcode.strings.reversepref;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
2000. Reverse Prefix of Word
https://leetcode.com/problems/reverse-prefix-of-word/description/
 */

public class Solution {

    public String reversePrefix(String word, char ch) {

        StringBuilder sb = new StringBuilder(word);
        int right = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                right = i;
                break;
            }
        }

        if (right == 0) {
            return sb.toString();
        }

        int left = 0;
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
        return sb.toString();
    }

    private void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(reversePrefix("abcdefd", 'd'), "dcbaefd");
        testing(reversePrefix("xyxzxe", 'z'), "zxyxxe");
        testing(reversePrefix("abcd", 'z'), "abcd");
    }

}
