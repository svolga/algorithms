package leetcode.prefixsum.longest;


import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
14. Longest Common Prefix
https://leetcode.com/problems/longest-common-prefix/description/
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {

        Arrays.sort(strs);
        String firstStr = strs[0];
        String lastStr = strs[strs.length - 1];

        int len = Math.min(firstStr.length(), lastStr.length());
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (firstStr.charAt(i) != lastStr.charAt(i)) {
                break;
            }
            count++;
        }

        return firstStr.substring(0, count);
    }


    private void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(longestCommonPrefix(new String[]{"flower", "flow", "flight"}), "fl");
        testing(longestCommonPrefix(new String[]{"dog", "racecar", "car"}), "");

    }
}
