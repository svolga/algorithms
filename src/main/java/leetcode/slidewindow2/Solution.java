package leetcode.slidewindow2;

import java.util.HashSet;
import java.util.Set;

// Метод скользящего окна
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

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        while (r < n && l < n) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
                max = Math.max(max, r - l);
            } else {
                set.remove(s.charAt(l));
                l++;
            }
        }
        return max;
    }


    private void run(String[] args) {
//        String row = "bbbbb";
//        String row = "pwwkew";
        String row = "abcabcbb";
        int length = lengthOfLongestSubstring(row);
        System.out.println("length = " + length);
    }

    public static void main(String[] args) {
        new Solution().run(args);
    }


}
