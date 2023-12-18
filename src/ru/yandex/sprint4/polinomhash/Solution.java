package ru.yandex.sprint4.polinomhash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// A. Полиномиальный хеш
// https://contest.yandex.ru/contest/23991/problems/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int a = 3; // основание
            String str = "ABACB"; // hash -> 6080 ; HaSH -> 56156
            int m = 256;

/*
            int a = Integer.parseInt(reader.readLine());
            int m = Integer.parseInt(reader.readLine());
            String str = reader.readLine();
*/
            long h = hash(str, a, m);
            System.out.println(h);
        }
    }

    private long hash(String str, int a, int m) {
        long h = 0;
        for (int i = 0; i < str.length(); i++) {
            h = (h * a + (int) str.charAt(i)) % m;
        }
        return h;
    }

}
