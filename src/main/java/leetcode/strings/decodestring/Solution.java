package java.leetcode.strings.decodestring;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// 394. Decode String
// https://leetcode.com/problems/decode-string/description/
public class Solution {
    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        String s = "3[a]2[bc]";
        String text = decodeString(s);

    }


    public String parseText(String input) {
        Deque<Integer> repeatedElements = new ArrayDeque<>();
        Deque<StringBuilder> letters = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                repeatedElements.push(Character.getNumericValue(c));
                continue;
            }
            if (c == '[') {
                letters.push(new StringBuilder());
                continue;
            }
            if (c == ']') {
                int count = repeatedElements.pop();
                if (letters.size() == 1) {
                    String letter = letters.pop().toString();
                    for (int i = 0; i < count; i++) {
                        result.append(letter);
                    }
                    continue;
                }

                String previous = letters.pop().toString();
                for (int i = 0; i < count; i++) {
                    letters.peek().append(previous);
                }
                continue;
            }
            if (letters.isEmpty()) {
                result.append(c);
            } else {
                letters.peek().append(c);
            }
        }

        return result.toString();
    }

    public String decodeString(String s) {
        Stack<Integer> repeated = new Stack<>();
        Stack<String> brackets = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)){

                repeated.push(Character.getNumericValue(c));
                continue;
            }

        }
        System.out.println(repeated);
        return "";
    }

}
