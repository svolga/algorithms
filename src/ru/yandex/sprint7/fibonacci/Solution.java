package ru.yandex.sprint7.fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// D. Числа Фибоначчи для взрослых
// https://contest.yandex.ru/contest/25596/problems/D/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {
/*
        int value = 66;
        int res = getFib(value);
        System.out.println("value = " + value + "; res = " + res);
*/

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int value = Integer.parseInt(reader.readLine());
            int res = getFib(value);
            System.out.println(res);
        }
    }

    private int getFib(int value) {

        List<Integer> list = new ArrayList<>();
        list.add(0, 1);
        list.add(1, 1);
        int i = 2;
        int mod = 1_000_000_007;
        for (i = 2; i <= value; i++) {
            int res = (list.get(i - 1) + list.get(i - 2)) % mod;
            list.add(i, res);
        }

        return list.get(i - 1);
    }
}
