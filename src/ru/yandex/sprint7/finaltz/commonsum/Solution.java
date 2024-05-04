package ru.yandex.sprint7.finaltz.commonsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

// B. Одинаковые суммы
// https://contest.yandex.ru/contest/25597/problems/B/
// Номер посылки: 113501933
// Посылка: https://contest.yandex.ru/contest/25597/run-report/113501933/
/*
-- ПРИНЦИП РАБОТЫ --
  Псевдополиномиальный алгоритм из wikipedia: https://shorturl.at/fjHK7

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
    O (n*s), где n - размер массива, s - сумма элементов

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
    Создается динамический массив размера s/2+1, сложность O(s)
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = readInt(reader);
            int[] nums = readArray(reader, count);

            boolean canSplit = canSplit(nums);
            System.out.println(canSplit ? "True" : "False");
        }
    }

    private int[] readArray(BufferedReader reader, int count) throws IOException {
        return Stream.of(reader.readLine().strip().split(" "))
                .mapToInt(Integer::parseInt)
                .limit(count)
                .toArray();
    }

    private int readInt(BufferedReader reader) throws NumberFormatException, IOException {
        return Integer.parseInt(reader.readLine());
    }

    public boolean canSplit(int[] nums) {
        int sum = Arrays.stream(nums).sum();

        if (sum % 2 != 0) {
            return false;
        }

        sum /= 2;

        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;

        for (int j : nums) {
            for (int i = sum; i > 0; i--) {
                if (i >= j) {
                    dp[i] = dp[i] || dp[i - j];
                }
            }
        }

        return dp[sum];
    }

    private void test() {
        int[] nums = {1, 5, 7, 1, 2};
        boolean result = canSplit(nums);
        System.out.println("result = " + result);
    }
}