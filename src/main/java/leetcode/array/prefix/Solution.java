package leetcode.array.prefix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
2185. Counting Words With a Given Prefix
https://leetcode.com/problems/counting-words-with-a-given-prefix/description/
 */
public class Solution {

    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            if (word.startsWith(pref)) {
                count++;
            }
        }
        return count;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(prefixCount(new String[]{"pay","attention","practice","attend"}, "at"), 2);
        testing(prefixCount(new String[]{"leetcode","win","loops","success"}, "code"), 0);
    }

}
