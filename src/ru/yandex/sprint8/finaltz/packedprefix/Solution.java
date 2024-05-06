package ru.yandex.sprint8.finaltz.packedprefix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// A. Packed Prefix
// https://contest.yandex.ru/contest/26133/problems/A/
// Номер посылки: 113587143
// Посылка: https://contest.yandex.ru/contest/26133/run-report/113587143/
/*
-- ПРИНЦИП РАБОТЫ --
    Распарсим строки в привычный вид. Первую строку примем за префикс. В цикле по списку слов находим новый префикс
    сравнивая текущее слово с префиксом.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
    O(n x L), где L - максимальная длина строки, n - кол-во строк

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
    O (L), где L - максимальная длина строки

 */
public class Solution {

    private static final char LEFT_BRACKET = '[';
    private static final char RIGHT_BRACKET = ']';

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {
        System.out.println(getPrefix());
    }

    public String getPrefix() throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            String prefix = parseText(reader.readLine());
            for (int i = 1; i < n; i++) {
                String string = parseText(reader.readLine());
                while (!prefix.isEmpty() && !string.startsWith(prefix)) {
                    prefix = prefix.substring(0, prefix.length() - 1);
                }
            }
            return prefix;
        }
    }

    public String parseText(String input) {
        Deque<Integer> repeatedElements = new ArrayDeque<>();
        Deque<StringBuilder> letters = new ArrayDeque<>();
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                repeatedElements.push(Character.getNumericValue(c));
                continue;
            }
            if (c == LEFT_BRACKET) {
                letters.push(new StringBuilder());
                continue;
            }
            if (c == RIGHT_BRACKET) {
                if (letters.size() == 1) {
                    result.append(letters.pop().toString().repeat(repeatedElements.pop()));
                    continue;
                }
                String previous = letters.pop().toString();
                letters.peek().append(previous.repeat(repeatedElements.pop()));
                continue;
            }
            if (letters.isEmpty()) {
                result.append(c);
            } else {
                letters.peek().append(c);
            }
        }

        return result.toString();
    }
}