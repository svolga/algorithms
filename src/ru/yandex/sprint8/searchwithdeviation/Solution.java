package ru.yandex.sprint8.searchwithdeviation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// G. Поиск со сдвигом
// https://contest.yandex.ru/contest/26131/problems/G/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            StringTokenizer stz = new StringTokenizer(reader.readLine());
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(stz.nextToken()));
            }

            int m = Integer.parseInt(reader.readLine());
            stz = new StringTokenizer(reader.readLine());
            List<Integer> pattern = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                pattern.add(Integer.parseInt(stz.nextToken()));
            }

            List<Integer> occurrence = ArrayFinder.findAll(list, pattern);
            StringBuilder sb = new StringBuilder();
            for (Integer i : occurrence) {
                sb.append(i + 1).append(" ");
            }
            System.out.println(sb);
        }
/*

        List<Integer> list = new ArrayList<>(List.of(3, 9, 1, 2, 5, 10, 9, 1, 7));
        List<Integer> pattern = new ArrayList<>(List.of(4, 10)); // 2,5 --> [3,7]
*/
/*
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<Integer> pattern = new ArrayList<>(List.of(10, 11, 12));
*/
    }

}

class ArrayFinder {

    public static int find(List<Integer> list, List<Integer> pattern, int start) {
        if (list.size() < pattern.size() || start > list.size() - 1) {
            return -1;
        }

        for (int pos = start; pos <= list.size() - pattern.size(); pos++) {
            boolean match = true;
            for (int offset = 1; offset < pattern.size(); offset++) {
                if (list.get(pos + offset) - list.get(pos + offset - 1) != pattern.get(offset) - pattern.get(offset - 1)) {
                    match = false;
                    break;
                }
            }

            if (match == true) {
                return pos;
            }
        }
        return -1;
    }

    public static List<Integer> findAll(List<Integer> list, List<Integer> pattern) {
        List<Integer> occurrences = new ArrayList<>();
        int start = 0; // Начнём поиск с начала строки.
        // Найдём первое вхождение, если оно есть.
        while (true) {
            int pos = find(list, pattern, start);
            if (pos == -1) {
                break;
            }
            occurrences.add(pos); // Сохраним вхождение в список.
            start = pos + 1;       // И продолжим поиск, начиная с позиции,
            // следующей за только что найденной.
        }
        return occurrences;
    }

}
