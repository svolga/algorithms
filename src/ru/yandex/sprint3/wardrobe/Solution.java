package ru.yandex.sprint3.wardrobe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// G. Гардероб
// https://contest.yandex.ru/contest/23638/problems/G/
// Сортировка подсчетом
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private int[] sort(int[] array, int k) {
        int[] result = new int[k];
        for (int value : array) {
            result[value]++;
        }
        return result;
    }

    private void run(String[] args) throws IOException {
        // 0 - роз, 1 - желт, 2 - малин
        int[] array = readInput(); //{2, 1, 1, 2, 0, 2};
        int[] res = sort(array, 3);
        String str = "0 ".repeat(res[0]) + "1 ".repeat(res[1]) + "2 ".repeat(res[2]);
        System.out.println(str);
    }

    private int[] readInput() throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            StringTokenizer stz = new StringTokenizer(reader.readLine());

            int[] array = new int[count];
            int i = 0;
            while (stz.hasMoreTokens() && i<count) {
                array[i] = Integer.parseInt(stz.nextToken());
                i++;
            }

            return array;
        }
    }

    private void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

}
