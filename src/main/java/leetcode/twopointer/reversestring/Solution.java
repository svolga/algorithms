package leetcode.twopointer.reversestring;

/*
344. Reverse String
https://leetcode.com/problems/reverse-string/description/?envType=problem-list-v2&envId=two-pointers
 */
public class Solution {

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

}
