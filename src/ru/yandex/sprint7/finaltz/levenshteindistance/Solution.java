package ru.yandex.sprint7.finaltz.levenshteindistance;

// A. Расстояние по Левенштейну
// https://contest.yandex.ru/contest/25597/problems/A/
// Номер посылки: 108404856
// Посылка: https://contest.yandex.ru/contest/25597/run-report/108404856/
/*
-- ПРИНЦИП РАБОТЫ --
Алгоритм Вагнера-Фишера: https://shorturl.at/cfwCU
рекурентная формула: http://joxi.ru/5mdWKZkf3DWpqr

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
    O(n*m), n-длина 1 строки, m - длина второй строки

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
    O(n*m) - заполняется динамический массив размером n*m
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String word1 = reader.readLine();
            String word2 = reader.readLine();

/*
            String word1 = "POLYNOMIAL";
            String word2 = "EXPONENTIAL";
*/

            int distance = minDistance(word1, word2);
            System.out.println(distance);
        }
    }

    private int minDistance(String word1, String word2) {
        int n = word1.length() + 1;
        int m = word2.length() + 1;

        int[][] dp = new int[n][m];
        dp[0][0] = 0;

        for (int i = 1; i < n; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j < m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = findMin(
                        dp[i][j - 1] + 1,
                        dp[i - 1][j] + 1,
                        dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1)
                );
            }
        }
        return dp[n - 1][m - 1];
    }

    private int findMin(int... values) {
        int min = Integer.MAX_VALUE;
        for (int value : values) {
            min = Math.min(min, value);
        }
        return min;
    }

    private void print(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }

}
