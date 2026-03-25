package leetcode.twopointer.reversestring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
344. Reverse String
https://leetcode.com/problems/reverse-string/description/?envType=problem-list-v2&envId=two-pointers
 */
public class Solution {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
        }
    }
/*
    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(reverseString(new char[]{'h','e','l','l','o'}), 2);
*/

    }

}
