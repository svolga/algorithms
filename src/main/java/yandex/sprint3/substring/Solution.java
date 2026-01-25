package java.yandex.sprint3.substring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// C. Подпоследовательность
// https://contest.yandex.ru/contest/23638/problems/C/
//
public class Solution {

    private String substr;
    private String str;

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void readInput() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            substr = reader.readLine();
            str = reader.readLine();
        }
    }

    private void run(String[] args) throws IOException {
        readInput();
        System.out.println(isSubString(substr, str) ? "True" : "False");
    }

    private boolean isSubString(String substr, String str) {

        int j = 0;
        for (int i = 0; i < substr.length(); i++) {
            while (j < str.length() && substr.charAt(i) != str.charAt(j)) {
                j++;
            }
            if (j == str.length()) {
                return false;
            }
            if (substr.charAt(i) == str.charAt(j)) {
                j++;
            }
        }

        return true;
    }

}
