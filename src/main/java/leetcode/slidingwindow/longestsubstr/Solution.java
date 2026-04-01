package leetcode.slidingwindow.longestsubstr;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
3. Longest Substring Without Repeating Characters
https://leetcode.com/problems/longest-substring-without-repeating-characters/description/


Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> subSet = new HashSet<>();
        int left = 0;
        int len = 0;
        for (int right = 0; right < s.length(); right++) {
            while (subSet.contains(s.charAt(right))) {
                subSet.remove(s.charAt(left));
                left++;
            }
            subSet.add(s.charAt(right));
            len = Math.max(len, right - left + 1);
        }

        return len;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {

        testing(lengthOfLongestSubstring("abcabcbb"), 3);
        testing(lengthOfLongestSubstring("bbbbb"), 1);
        testing(lengthOfLongestSubstring("pwwkew"), 3);

        testing(lengthOfLongestSubstring(" "), 1);

    }
}
