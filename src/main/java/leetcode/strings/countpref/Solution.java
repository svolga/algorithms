package leetcode.strings.countpref;

/*
2255. Count Prefixes of a Given String
https://leetcode.com/problems/count-prefixes-of-a-given-string/description/
 */

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
/*
2255. Count Prefixes of a Given String
https://leetcode.com/problems/count-prefixes-of-a-given-string/description/
 */
public class Solution {

    public int countPrefixes(String[] words, String s) {

        Arrays.sort(words);
        int count = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(countPrefixes(new String[]{"a","b","c","ab","bc","abc"}, "abc"), 3);
        testing(countPrefixes(new String[]{"a","a"}, "aa"), 2);

    }


}
