package java.yandex.sprint7.changemoney;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// G. Банкомат
// https://contest.yandex.ru/contest/25596/problems/G/

// Статьи
// Способы размена: https://www.geeksforgeeks.org/understanding-the-coin-change-problem-with-dynamic-programming/
// Минимальное кол-во монет: https://education.yandex.ru/handbook/algorithms/article/zadacha-razmen-2

public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int money = Integer.parseInt(reader.readLine());
            int count = Integer.parseInt(reader.readLine());
            int[] coins = new int[count];

            StringTokenizer stz = new StringTokenizer(reader.readLine());

            for (int i = 0; i < count; i++) {
                coins[i] = Integer.parseInt(stz.nextToken());
            }

            int[] result = getNumberOfWays(money, coins);
            System.out.println(result[result.length - 1]);
        }

/*        int money = 8;
        int[] coins = {5};

        int[] result = getNumberOfWays(money, coins);
        System.out.println(Arrays.toString(result));
*/
    }

    // Способы размена
    private int[] getNumberOfWays(int money, int[] coins) {
        int[] ways = new int[money + 1];
        ways[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j < ways.length; j++) {
                if (coins[i] <= j) {
                    ways[j] += ways[j - coins[i]];
                }
            }
        }
        return ways;
    }

    private void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }


    // Размен монет
    private void run1() {
        int money = 5;
        int[] values = {3, 2, 1};

        int[] result = exchange(money, values);

        System.out.println(Arrays.toString(result));
        System.out.println(result[result.length - 1]);

    }

    // Минимальное количество монет
    private int[] exchange(int money, int[] values) {

        int[] result = new int[money + 1];
        for (int i = 0; i <= money; i++) {
            result[i] = Integer.MAX_VALUE;
        }
        result[0] = 0;

        for (int m = 1; m <= money; m++) {

            for (int value : values) {
                if (value <= m) {
                    result[m] = Math.min(result[m], 1 + result[m - value]);
                }
            }
        }

        return result;
    }


}
