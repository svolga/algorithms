package ru.yandex.sprint7.finaltz.commonsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Stream;

// B. Одинаковые суммы
// https://contest.yandex.ru/contest/25597/problems/B/
// Номер посылки: 108384878
// Посылка: https://contest.yandex.ru/contest/25597/run-report/108384878/
/*
-- ПРИНЦИП РАБОТЫ --
  Псевдополиномиальный алгоритм из wikipedia: https://shorturl.at/fjHK7

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
    O (n*s), где n - размер массива, s - сумма элементов

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
    Создается динамический массив размера n+1, s/2+1, сложность O(n*s)
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
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][sum];
    }

    private void test() {
        int[] nums = {1, 5, 7, 1, 2};
//        int[] nums = {1, 5, 7, 1};
//        int[] nums = {2, 10, 9, 1};
//        Integer[] nums = {1 , 2 , 3 , 4 , 5 , 5};
//        List<Integer> list = Arrays.asList(nums);

        boolean result = canSplit(nums);
        System.out.println("result = " + result);
    }
}
