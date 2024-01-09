package leetcode.strings.firstoccurrence;

// 28. Find the Index of the First Occurrence in a String
// https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] arg) {
/*
 haystack = "leetcode", needle = "leeto"
 */
        String haystack = "sadbutsad";
        String needle = "sad";

        int pos = strStr(haystack, needle);
        System.out.println(pos);
    }

    public int strStr(String haystack, String needle) {

        final int lenHaystack = haystack.length();
        final int lenNeedle = needle.length();

        for (int i = 0; i < lenHaystack - lenNeedle + 1; i++) {
            String strSubstr = haystack.substring(i, i + lenNeedle);
            if (strSubstr.equals(needle)) {
                return i;
            }
        }

        return -1;
    }

}
