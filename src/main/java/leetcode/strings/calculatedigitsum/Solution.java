package java.leetcode.strings.calculatedigitsum;

// 2243. Calculate Digit Sum of a String
// https://leetcode.com/problems/calculate-digit-sum-of-a-string/description/
public class Solution {
    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        String s = "11111222223";
//        String s = "3465";
        int k = 3;
        System.out.println(digitSum(s, k));
    }

    /*
    You are given a string s consisting of digits and an integer k.

    A round can be completed if the length of s is greater than k. In one round, do the following:

    Divide s into consecutive groups of size k such that the first k characters are in the first group,
    the next k characters are in the second group, and so on. Note that the size of the last group can be smaller than k.
    Replace each group of s with a string representing the sum of all its digits.
    For example, "346" is replaced with "13" because 3 + 4 + 6 = 13.
    Merge consecutive groups together to form a new string. If the length of the string is greater than k,
    repeat from step 1.
    Return s after all rounds have been completed.
     */
    public String digitSum(String s, int k) {
        if (s.length() <= k) {
            return s;
        }
        StringBuilder newSb = new StringBuilder();
        int i = 0;
        int j = 0;
        while (i < s.length() - 1) {
            int sum = 0;
            j = 0;
            while (j < k && i + j < s.length()) {
                int v = s.charAt(i + j) - '0';
                sum += v;
                j++;
            }
            i += j;
            newSb.append(sum);
        }

        int rest = s.length() % k;
        if (rest != 0 ) {
            newSb.append(s.substring(s.length() - rest, s.length()));
        }

        return digitSum(newSb.toString(), k);
    }

}
