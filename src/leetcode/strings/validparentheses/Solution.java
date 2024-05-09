package leetcode.strings.validparentheses;

import java.util.Stack;

// 20. Valid Parentheses
// https://leetcode.com/problems/valid-parentheses/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        String s = "{()}";
        boolean isValid = isValid(s);
        System.out.println(isValid ? "true" : "false");
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }

            if (stack.empty()){
                return false;
            }

            char getChar = stack.pop();
            if ( (getChar == '(' && c!=')') || (getChar == '{' && c!='}') || (getChar == '[' && c!=']')) {
                return false;
            }
        }

        return stack.empty();
    }

}
