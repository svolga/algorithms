package ru.yandex.sprint1.doublesys;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// H. Двоичная система - сложение в двоичной системе
// https://contest.yandex.ru/contest/22449/problems/H/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String num1 = reader.readLine();
            String num2 = reader.readLine();

            int diff = num2.length() - num1.length();
            if (diff != 0) {
                if (diff > 0) {
                    num1 = "0".repeat(diff) + num1;
                } else {
                    num2 = "0".repeat(-1 * diff) + num2;
                }
            }

            StringBuilder sb = sum(num1, num2);
            System.out.println(sb);
        }
    }

    private StringBuilder sum(String strA, String strB) {

        char[] charAs = strA.toCharArray();
        char[] charBs = strB.toCharArray();

        int countA = charAs.length - 1;
        int countB = charBs.length - 1;
        int rest = 0;
        StringBuilder sb = new StringBuilder();

        while (countA >= 0 || countB >= 0) {

            int a = charAs[countA] - '0';
            int b = charBs[countB] - '0';
            int sum = a + b + rest;
            rest = sum / 2;

            sb.append(sum % 2);

            countA--;
            countB--;
        }

        if (rest > 0) {
            sb.append(rest);
        }

        return sb.reverse();
    }
}
