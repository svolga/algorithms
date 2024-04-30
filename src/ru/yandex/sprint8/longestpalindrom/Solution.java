package ru.yandex.sprint8.longestpalindrom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// C. Самый длинный палиндром 2
// https://contest.yandex.ru/contest/26131/problems/C/
public class Solution {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = reader.readLine();
//        String str = "pabcd";
//            String str = "aaabbb";
//            String str = "fxusggqdel";
//            String str = "ogmommrkpz";
            String palindrom = getPalindrom(str);
            System.out.println(palindrom);
        }
    }

    private static String getPalindrom(String str) {
        char[] chr = str.toCharArray();
        Arrays.sort(chr);

        StringBuilder sb1 = new StringBuilder();
        char middle = 0;

        int i = 0;
        while (i < chr.length - 1) {
            if (chr[i] == chr[i + 1]) {
                sb1.append(chr[i]);
                i += 2;
            } else {
                if (middle == 0) {
                    middle = chr[i];
                }
                i++;
            }
        }

        if (sb1.length() == 0) {
            return String.valueOf(chr[0]);
        }

        return middle == 0 ? sb1.toString() + sb1.reverse() : sb1.toString() + middle + sb1.reverse();
    }
}


