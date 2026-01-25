package java.leetcode.strings.lengthlastword;

// 58. Length of Last Word
// https://leetcode.com/problems/length-of-last-word/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        String s = "luffy is still joyboy";
        int pos = lengthOfLastWord(s);
        System.out.println("len = " + pos);
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();
        int length = s.length();
        int i = 0;
        for (i = length - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                break;
            }
        }
        return length - i - 1;
    }


}
