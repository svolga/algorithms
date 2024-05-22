package ru.yandex.algo5.startup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// E. Прибыльный стартап
// https://contest.yandex.ru/contest/59539/problems/E/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int[] nums = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            int[] nums = {21, 108, 1};
//            int[] nums = {5, 12, 4};
//            int[] nums = {1, 1, 1};
//            int[] nums = {29420920, 98069736, 69929};

            int n = nums[0];
            int k = nums[1];
            int d = nums[2];

            String profit = getProfit(n, k, d);
            System.out.println(profit);
        }
    }

    private String getProfit(int n, int k, int d) {

        int multiple = getMultiple(n, k);
        if (multiple < 0) {
            return String.valueOf(multiple);
        }

        StringBuilder sb = new StringBuilder(String.valueOf(10 * n + multiple));
        for (int i = 2; i <= d; i++) {
            sb.append("0");
        }
        return sb.toString();
    }

    private int getMultiple(int n, int k) {
        for (int i = 0; i < 10; i++) {
            if ((10 * n + i) % k == 0) {
                return i;
            }
        }
        return -1;
    }

}
