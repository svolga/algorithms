package java.yandex.sprint7.goldleprekon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// L. Золото лепреконов
// https://contest.yandex.ru/contest/25596/problems/L/
public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    public void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stz = new StringTokenizer(reader.readLine());

            int count = Integer.parseInt(stz.nextToken());
            int capacity = Integer.parseInt(stz.nextToken());
            int[] weigths = new int[count];

            stz = new StringTokenizer(reader.readLine());
            for (int i = 0; i < count; i++) {
                weigths[i] = Integer.parseInt(stz.nextToken());
            }
/*
            int capacity = 19;
            int[] weigths = {10, 10, 7, 7, 4};
*/
            int max = getMaxWeigth(weigths, capacity);
            System.out.println(max);
        }
    }

    private int getMaxWeigth(int[] weigths, int capacity) {
        int[] dp = new int[capacity + 1];
        dp[0] = 1;
        int max = 0;
        for (int weigth : weigths) {
            for (int i = capacity; i >= weigth; i--) {
                if (dp[i - weigth] == 1) {
                    dp[i] = 1;
                    max = Math.max(max, i);
                }
            }
        }
        return max;
    }
}
