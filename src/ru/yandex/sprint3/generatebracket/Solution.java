package ru.yandex.sprint3.generatebracket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// A. Генератор скобок
// https://contest.yandex.ru/contest/23638/problems/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void addBrackets(int openedCount, int closedCount, String prefix, int count, List<String> list) {
        if (openedCount == closedCount && closedCount == count) {
            list.add(prefix);
            return;
        }

        if (openedCount < count) {
            addBrackets(openedCount + 1, closedCount, prefix + "(", count, list);
        }

        if (closedCount < openedCount) {
            addBrackets(openedCount, closedCount + 1, prefix + ")", count, list);
        }
    }

    private void run(String[] args) {
        try {
            int count = readInput();

            List<String> list = new ArrayList<>();
            addBrackets(0, 0, "", count, list);

            StringBuilder result = new StringBuilder();
            list.forEach(s -> result.append(s).append(System.lineSeparator()));
            System.out.println(result);

        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private int readInput() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return Integer.parseInt(reader.readLine());
        }
    }

}
