package ru.yandex.sprint2.fibonacimod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// L. Фибоначчи по модулю
// https://contest.yandex.ru/contest/22779/problems/L/

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().run(args);
    }
    private int getSum(int n) {
        int result = 1;
        if (n == 0 || n == 1) {
            return result;
        }
        result = getSum(n - 1) + getSum(n - 2);
        return result;
    }

    private int getMod(int value, int powerValue) {
        int power = (int) Math.pow(10, powerValue);
        int result = value % power;
        return result;
    }

    private void run(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

            int n = Integer.valueOf(stringTokenizer.nextToken());
            int k = Integer.valueOf(stringTokenizer.nextToken());

            int commitCount = getSum(n);
            int result = getMod(commitCount, k);

            System.out.println(result);
        }
    }

}