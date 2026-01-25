package java.yandex.sprint7.extfieldflower;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// I. Сложное поле с цветочками
// https://contest.yandex.ru/contest/25596/problems/I/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer stz = new StringTokenizer(reader.readLine());

            int n = Integer.parseInt(stz.nextToken());
            int m = Integer.parseInt(stz.nextToken());

            int[][] values = new int[n][m];

            for (int i = n - 1; i >= 0; i--) {
                String str = reader.readLine();
                for (int j = 0; j < m; j++) {
                    values[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                }
            }

            int[][] dp = getPath(values, n, m);

            System.out.println(dp[n - 1][m - 1]);
            String way = restorePath(dp, n, m);
            System.out.println(way);
        }
    }


    // Восстанавливаем обратный ход
    private String restorePath(int[][] dp, int n, int m) {

        StringBuilder value = new StringBuilder();
        int i = n - 1;
        int j = m - 1;

        while (i > 0 || j > 0) {
            int valBottom = i == 0 ? Integer.MIN_VALUE : dp[i - 1][j];
            int valLeft = j == 0 ? Integer.MIN_VALUE : dp[i][j - 1];
            if (valBottom > valLeft) {
                i = i - 1;
                value.append("U");
            } else {
                j = j - 1;
                value.append("R");
            }
        }

        return value.reverse().toString();
    }

    private int[][] getPath(int[][] values, int n, int m) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int left = j > 0 ? dp[i][j - 1] : 0;
                int bottom = i > 0 ? dp[i - 1][j] : 0;
                dp[i][j] = Math.max(left, bottom) + values[i][j];
            }
        }
        return dp;
    }

    private void test(){
        int n = 2;
        int m = 3;
        int[][] values = new int[n][m];

        values[1][0] = 1;
        values[1][1] = 0;
        values[1][2] = 1;

        values[0][0] = 1;
        values[0][1] = 1;
        values[0][2] = 0;

        for (int i = values.length - 1; i >= 0; i--) {
            System.out.println(Arrays.toString(values[i]));
        }

        int[][] dp = getPath(values, n, m);

        for (int i = dp.length - 1; i >= 0; i--) {
            System.out.println(Arrays.toString(dp[i]));
        }

        System.out.println(dp[n - 1][m - 1]);
        String way = restorePath(dp, n, m);
        System.out.println(way);
    }

}
