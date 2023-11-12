package ru.yandex.sprint2.recursionfibonaci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// K. Рекурсивные числа Фибоначчи
// https://contest.yandex.ru/contest/22779/problems/K/
public class Main {
    private int getSum(int n) {
        int result = 1;
        if (n == 0 || n == 1) {
            return result;
        }
        result = getSum(n - 1) + getSum(n - 2);
        return result;
    }

    private void run(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.valueOf(reader.readLine());
            int commitCount = getSum(n);
            System.out.println(commitCount);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().run(args);
    }

}
