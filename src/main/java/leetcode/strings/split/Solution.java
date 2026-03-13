package leetcode.strings.split;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

2788. Split Strings by Separator

https://leetcode.com/problems/split-strings-by-separator/description/
 */
public class Solution {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        String sep = String.format("[%c]", separator);
        List<String> res = new ArrayList<>();

        for (String word : words) {
            String[] arrays = word.split(sep);
            Arrays.stream(arrays).filter(s -> !s.isEmpty()).forEach(res::add);
        }

        return res;
    }

    private void testing(List<String> actual, List<String> expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {

        testing(
                splitWordsBySeparator(
                        List.of("one.two.three", "four.five", "six"),
                        '.'
                ),
                List.of("one", "two", "three", "four", "five", "six")
        );


        testing(
                splitWordsBySeparator(
                        List.of("$easy$", "$problem$"),
                        '$'
                ),
                List.of("easy", "problem")
        );

        testing(
                splitWordsBySeparator(
                        List.of("|||"),
                        '|'
                ),
                List.of()
        );


    }

}
