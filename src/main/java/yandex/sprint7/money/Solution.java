package java.yandex.sprint7.money;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// E. Алла на Алгосах
// https://contest.yandex.ru/contest/25596/problems/E/
public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

       /* int total = 130;
        int nominalCount = 4;
        int[] values = {10, 3, 40, 1};

        int result = coinChange(values, total);
        System.out.println(result);
*/

/*
        int total = 7;
        int nominalCount = 1;
        int[] values = {5,6};
        int result = coinChange(values, total);
        System.out.println(result);
*/


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int total = Integer.parseInt(reader.readLine());
            int countValues = Integer.parseInt(reader.readLine());
            StringTokenizer stz = new StringTokenizer(reader.readLine());

            int[] values = new int[countValues];
            for (int i = 0; i < countValues; i++) {
                values[i] = Integer.parseInt(stz.nextToken());
            }

            int result = coinChange(values, total);
            System.out.println(result);
        }
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] t = new int[n + 1][amount + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j == 0) {
                    t[i][j] = 0;
                } else {
                    t[i][j] = Integer.MAX_VALUE - 1;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    t[i][j] = Math.min(t[i][j - coins[i - 1]] + 1, t[i - 1][j]);
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][amount] == Integer.MAX_VALUE - 1 ? -1 : t[n][amount];
    }

}
