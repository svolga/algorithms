package java.yandex.sprint8.border;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// B. Пограничный контроль
// https://contest.yandex.ru/contest/26131/problems/B/
public class Solution {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String str1 = reader.readLine();
            String str2 = reader.readLine();
            boolean equal = compareStrings(str1, str2);
            System.out.println(equal ? "OK" : "FAIL");
        }
    }

    private static boolean compareStrings(String str1, String str2) {
        if (str1.length() - str2.length() > 1) {
            return false;
        }

        int i = 0;
        while (i < str1.length() && i < str2.length()) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            i++;
        }

        int j = 0;
        while (str1.length() - 1 - j >= 0 && str2.length() - 1 - j >= 0) {
            if (str1.charAt(str1.length() - 1 - j) != str2.charAt(str2.length() - 1 - j)) {
                break;
            }
            j++;
        }

        String newWord = str1.substring(0, i) + str1.substring(str1.length() - j);
        return (str1.length() - newWord.length() <= 1 && str2.length() - newWord.length() <= 1);
    }

}
