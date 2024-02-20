package ru.yandex.sprint7.stock;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// A. Биржа
// https://contest.yandex.ru/contest/25596/problems/A/
public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            int[] prices = new int[count];
            StringTokenizer stz = new StringTokenizer(reader.readLine());

            for (int i = 0; i < count; i++) {
                prices[i] = Integer.parseInt(stz.nextToken());
            }
//            int[] prices = {7, 1, 5, 3, 6, 4};
            int value = getProfit(prices);
            System.out.println(value);
        }
    }

    private int getProfit(int[] prices) {

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0) {
                profit += diff;
            }
        }
        return profit;
    }

}
