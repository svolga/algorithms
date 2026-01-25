package java.yandex.sprint7.jump;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// F. Прыжки по лестнице
// https://contest.yandex.ru/contest/25596/problems/F/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            StringTokenizer stz = new StringTokenizer(reader.readLine());

            int n = Integer.parseInt(stz.nextToken());
            int k = Integer.parseInt(stz.nextToken());
/*
            int n = 6;
            int k = 3;
*/
            int res = getJump(n, k);
            System.out.println(res);
        }
    }

    private int getJump(int n, int k) {

        int mod = 1_000_000_007;
        int[] steps = new int[n];
        steps[0] = 1;

        for (int i = 1; i < steps.length; i++) {
            for (int j = Math.max(0, i - k); j < i; j++) {
                steps[i] = (steps[i] + steps[j]) % mod;
            }
        }
        return steps[n - 1];
    }

}
