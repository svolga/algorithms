package leetcode.strings.validanagram;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
242. Valid Anagram
https://leetcode.com/problems/valid-anagram/description/
 */
public class Solution {

    public boolean isAnagram(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        Arrays.sort(cs);
        Arrays.sort(ct);

        return Arrays.equals(cs, ct);
    }

    private void testing(boolean actual, boolean expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(isAnagram( "anagram", "nagaram"), true);
    //    testing(isAnagram("rat", "car"), false);
    }

}
