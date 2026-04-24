package leetcode.twopointer.reversestring2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
541. Reverse String II
https://leetcode.com/problems/reverse-string-ii/description/
 */
public class Solution {

    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int left = 0;
        int right = k - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);

    }

    private void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
//        testing(reverseStr("abcdefg", 2), "bacdfeg");
        testing(reverseStr("abcd", 2), "bacd");
    }

}
