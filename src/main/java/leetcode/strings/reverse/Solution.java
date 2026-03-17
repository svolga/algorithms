package leetcode.strings.reverse;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
3794. Reverse String Prefix
https://leetcode.com/problems/reverse-string-prefix/description/
 */
public class Solution {

    public String reversePrefix(String s, int k) {

        int left = 0;
        int right = k - 1;

        char[] array = s.toCharArray();

        while (left < right) {
            char temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }

        return new String(array);
    }

    private void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(reversePrefix("abcdef", 6), "fedcba");
        testing(reversePrefix("abcd",2), "bacd");
        testing(reversePrefix("xyz",3), "zyx");
    }
}
