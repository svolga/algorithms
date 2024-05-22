package ru.yandex.algo52.chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// A. Минимальный прямоугольник
// https://contest.yandex.ru/contest/59540/problems/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = getInt(reader);

            List<Integer> x = new ArrayList<>();
            List<Integer> y = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                String[] str = reader.readLine().strip().split(" ");
                x.add(Integer.parseInt(str[0]));
                y.add(Integer.parseInt(str[1]));
            }

            Comparator<Integer> comp = new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o1 - o2;
                }
            };

/*
        List<Integer> x = Arrays.asList(1, 3, 3, 6);
        List<Integer> y = Arrays.asList(3, 1, 5, 3);
*/
            int x1 = x.stream().min(comp).get();
            int y1 = y.stream().min(comp).get();
            int x2 = x.stream().max(comp).get();
            int y2 = y.stream().max(comp).get();

            System.out.println(
                    x1 + " " + y1 + " " + x2 + " " + y2
            );
        }
    }

    private int getInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }


}
