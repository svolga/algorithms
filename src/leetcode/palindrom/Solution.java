package leetcode.palindrom;

// 9. Palindrome Number
// https://leetcode.com/problems/palindrome-number/description/

public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int value = 121;

        System.out.println(isPalindrome(value) ? "Yes" : "No");
    }

    public boolean isPalindrome(int x) {
        int tempOrigin = x;
        int reverseNum = 0;
        while (tempOrigin > 0) {
            int lastDigit = tempOrigin % 10;
            reverseNum = reverseNum * 10 + lastDigit;
            tempOrigin = tempOrigin / 10;
        }

        boolean isEqual = reverseNum == x;
        return isEqual;
    }
}