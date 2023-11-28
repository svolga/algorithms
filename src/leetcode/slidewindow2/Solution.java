package leetcode.slidewindow2;

// Мнтод скользящего окна
// Временная сложность O(n), пространственная сложность O(n)
// 3. Longest Substring Without Repeating Characters
// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class Solution {
/*
Подход двух указателей

int r = 0;
for (int l=0; l<n; l++){
    while(r<n && [отрезок хороший]){
        добавить a[r]
        r++;
    }
    убрать a[l]
}
*/

    boolean contains(StringBuilder sb, String findString) {
        return sb.indexOf(findString) > -1;
    }
/*
    public int lengthOfLongestSubstring(String s) {

        String current = "";
        String maxString = "";
        int r = 0;
        for (int l = 0; l < s.length(); l++) {

            boolean isFound = false;

            while (r < s.length() && !current.contains(Character.toString(s.charAt(r)))) {
                current += s.charAt(r);
                isFound = true;
                r += 1;
            }

            if (!isFound){
                current = s.substring(l, r);
            }

            if (maxString.length() <= current.length()) {
                maxString = current;
            }

        }

        System.out.println(maxString);

        return maxString.length();
    }
*/


    public int lengthOfLongestSubstring(String s) {
        String current = "";
        int max = 0;
        int r = 0;
        for (int l = 0; l < s.length(); l++) {

            while (r < s.length() && !current.contains(Character.toString(s.charAt(r)))) {
                current += s.charAt(r);
                r += 1;
            }

            System.out.println("l = " + l + "; r = " + r);

            current = s.substring(l, r);

            if (max <= current.length()) {
                max = current.length();
            }
        }
        return max;
    }


    private void run(String[] args) {
//        String row = "bbbbb";
        String row = "pwwkew";
        int length = lengthOfLongestSubstring(row);
        System.out.println("length = " + length);
    }

    public static void main(String[] args) {
        new Solution().run(args);
    }


}
