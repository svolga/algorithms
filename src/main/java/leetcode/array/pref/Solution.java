package leetcode.array.pref;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
3839. Number of Prefix Connected Groups
https://leetcode.com/problems/number-of-prefix-connected-groups/description/
 */
public class Solution {

    public int prefixConnected(String[] words, int k) {

        String[] filteredWords =
                Arrays.stream(words)
                        .filter(word -> word.length() >= k)
                        .toArray(String[]::new);

        Map<String, Integer> map = new HashMap<>();

        for (String filteredWord : filteredWords) {
            String prefix = filteredWord.substring(0, k);
            map.merge(prefix, 1, Integer::sum);
        }

        int count = 0;

        for (Integer value : map.values()) {
            if (value >= 2) {
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
        testing(prefixConnected(new String[]{"apple", "apply", "banana", "bandit"}, 2), 2);
        testing(prefixConnected(new String[]{"car", "cat", "cartoon"}, 3), 1);
    }

}
