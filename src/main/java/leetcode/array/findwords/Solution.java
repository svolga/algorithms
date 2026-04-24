package leetcode.array.findwords;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char[] chars = word.toCharArray();
            for (int j = chars.length - 1; j >= 0; j--) {
                if (chars[j] == x) {
                    result.add(i);
                    break;
                }
            }
        }
        return result;
    }

    private void testing(List<Integer> actual, List<Integer> expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(findWordsContaining(new String[]{"leet", "code"}, 'e'), List.of(0, 1));
        testing(findWordsContaining(new String[]{"abc", "bcd", "aaaa", "cbc"}, 'a'), List.of(0, 2));
        testing(findWordsContaining(new String[]{"abc", "bcd", "aaaa", "cbc"}, 'z'), List.of());

    }
}
