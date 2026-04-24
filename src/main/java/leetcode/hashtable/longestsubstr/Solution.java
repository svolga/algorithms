package leetcode.hashtable.longestsubstr;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
2982. Find Longest Special Substring That Occurs Thrice II
https://leetcode.com/problems/find-longest-special-substring-that-occurs-thrice-ii/description/
 */
public class Solution {

    public int maximumLength(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();

        int left = 0;

        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            char currChar = s.charAt(right);
            char prevChar = s.charAt(right - 1);

            if (currChar == prevChar) {
                count++;
                right++;
//                map.put(currChar, map.getOrDefault(currChar, new ArrayList<>()).add(count));
            }
            else{
                count = 0;
                left = right;
            }

        }

        return 0;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

/*
Строка s = "cccerrreccc"
Группы: c: [3, 3], e: [1], r: [3]
*/
    @Test
    public void test() {
        testing(maximumLength("aaabaaa"), 4);

    }

}
