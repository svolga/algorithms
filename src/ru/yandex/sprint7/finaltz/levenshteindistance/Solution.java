package ru.yandex.sprint7.finaltz.levenshteindistance;

// A. Расстояние по Левенштейну
// https://contest.yandex.ru/contest/25597/problems/A/
// Номер посылки: 113505112
// Посылка: https://contest.yandex.ru/contest/25597/run-report/113505112/
/*
-- ПРИНЦИП РАБОТЫ --
Алгоритм Вагнера-Фишера: https://ru.wikipedia.org/wiki/Расстояние_Левенштейна
рекурентная формула: http://joxi.ru/5mdWKZkf3DWpqr

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
    O(n*m), n-длина 1 строки, m - длина второй строки

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
    O(k) - линейная, где k = min(n, m)
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
            System.out.println(minDistance(reader.readLine(), reader.readLine()));
        }
    }

    public int minDistance(String word1, String word2) {
        Integer n = word1.length();
        Integer m = word2.length();

        if (n > m) {
            swap(word1, word2);
            swap(n, m);
        }

        int[] current = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            current[i] = i;
        }

        for (int i = 1; i <= m; i++) {
            int[] prev = current;
            current = new int[n + 1];
            current[0] = i;
            for (int j = 1; j <= n; j++) {
                current[j] = Math.min(
                        prev[j] + 1,
                        Math.min(current[j - 1] + 1,
                        prev[j - 1] + (word1.charAt(j - 1) != word2.charAt(i - 1) ? 1 : 0)));
            }
        }
        return current[n];
    }

    private <T> void swap(T t1, T t2) {
        T temp = t1;
        t1 = t2;
        t2 = temp;
    }

    private void print(int[][] dp) {
        for (int[] ints : dp) {
            System.out.println(Arrays.toString(ints));
        }
    }
}