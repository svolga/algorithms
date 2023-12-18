package ru.yandex.sprint4.substr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// E. Подстроки
// https://contest.yandex.ru/contest/23991/problems/E/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = reader.readLine();
            char[] chars = str.toCharArray();

            StringBuilder subStr = new StringBuilder();
            int max = 0;
            for (int i = 0; i < chars.length; i++) {
                Character c = chars[i];

                if (subStr.toString().contains(c.toString())) {
                    int index = subStr.indexOf(c.toString());
                    subStr = new StringBuilder(subStr.substring(index + 1));
                    subStr.append(c);
                } else {
                    subStr.append(c);
                }

                if (subStr.length() > max) {
                    max = subStr.length();
                }
            }
            System.out.println(max);
        }
    }
}
