package leetcode.strings.processstring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// https://leetcode.com/problems/process-string-with-special-operations-i/description/
// 3612. Process String with Special Operations I
public class Solution {

    public String processStr(String s) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {

            if (Character.isAlphabetic(s.charAt(i))) {
                sb.append(s.charAt(i));
            }
            else if (s.charAt(i) == '#') {
                sb.append(sb);
            }
            else if (s.charAt(i) == '%') {
                sb.reverse();
            }
            else if (s.charAt(i) == '*') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
        return sb.toString();
    }

    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        System.out.println("processStr");
        testing(processStr("a#b%*"), "ba");
        testing(processStr("z*#"), "");
    }
}
