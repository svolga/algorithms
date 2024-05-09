package leetcode.strings.excelsheetcolumntitle;

// 168. Excel Sheet Column Title
// https://leetcode.com/problems/excel-sheet-column-title/description/
public class Solution {
    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
//        int n = 2147483647;
        int n = 701;
//        int n = 1;
/*
2147483647
FXSHRXW
 */
        String str = convertToTitle(n);
        System.out.println(str);
    }

    public String convertToTitle(int columnNumber) {
        int max = 26;
        StringBuffer sb = new StringBuffer();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) ('A' + (columnNumber % max)));
            columnNumber /= max;
        }
        return sb.reverse().toString();
    }
}
