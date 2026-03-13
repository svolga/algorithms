package leetcode.strings.parser;

/*
1678. Goal Parser Interpretation
https://leetcode.com/problems/goal-parser-interpretation/description/
*/

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {
    public String interpret(String command) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("G", "G");
        map.put("()", "o");
        map.put("(al)", "al");

        StringBuilder sb = new StringBuilder();
        StringBuilder substr = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            substr.append(command.charAt(i));
            if (map.containsKey(substr.toString())) {
                sb.append(map.get(substr.toString()));
                substr.setLength(0);
            }
        }

        return sb.toString();
    }

    private void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(interpret("G()(al)"), "Goal");
        testing(interpret("G()()()()(al)"), "Gooooal");
        testing(interpret("(al)G(al)()()G"), "alGalooG");
    }

}
