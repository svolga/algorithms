package java.leetcode.number.addbinary;

// 67. Add Binary
// https://leetcode.com/problems/add-binary/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {

        String a = "11";
        String b = "1";

     /*   String a = "1010";
        String b = "1011";
     */
        String res = addBinary(a, b);
        System.out.println("res = " + res);
    }

    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int rest = 0;

        while (i >= 0 || j >= 0) {
            int x = rest;
            if (i >= 0) {
                x += a.charAt(i) - '0';
            }

            if (j >= 0) {
                x += b.charAt(j) - '0';
            }

            rest = x > 1 ? 1 : 0;
            x = x % 2;

            sb.append(x);

            i--;
            j--;
        }

        if (rest != 0) {
            sb.append(rest);
        }

        return sb.reverse().toString();
    }

}
