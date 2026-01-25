package java.yandex.sprint7.rucksack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// M. Рюкзак
// https://contest.yandex.ru/contest/25596/problems/M/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stz = new StringTokenizer(reader.readLine());

            int countItems = Integer.parseInt(stz.nextToken());
            int capacity = Integer.parseInt(stz.nextToken());
            Item[] items = new Item[countItems];

            for (int i = 0; i < countItems; i++) {
                stz = new StringTokenizer(reader.readLine());
                items[i] = new Item(
                        Integer.parseInt(stz.nextToken()),
                        Integer.parseInt(stz.nextToken())
                );
            }

/*

            int capacity = 6;
            int countItems = 4;
            Item[] items = new Item[countItems];
            //Item[] its = new

            items[0] = new Item(2, 7);
            items[1] = new Item(4, 2);
            items[2] = new Item(1, 5);
            items[3] = new Item(2, 1);
*/

            List<Integer> result = getMaxCost(items, capacity);

            System.out.println(result.size());
            StringBuilder sb = new StringBuilder();
            for (Integer res : result) {
                sb.append(res).append(" ");
            }
            System.out.println(sb);
        }
    }

    private void print(int[][] array) {
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private List<Integer> getMaxCost(Item[] items, int capacity) {
        int[][] dp = new int[items.length + 1][capacity + 1];

        for (int i = 1; i <= items.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                if (j >= items[i - 1].weigth) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i - 1].weigth] + items[i - 1].cost);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        int i = items.length;
        int j = capacity;
        while (dp[i][j] != 0) {
            if (dp[i][j] != dp[i - 1][j]) {
                result.add(i);
                j -= items[i - 1].weigth;
            }
            i--;
        }
        return result;
    }
}

class Item {
    int weigth;
    int cost;

    public Item(int weigth, int cost) {
        this.weigth = weigth;
        this.cost = cost;
    }
}
