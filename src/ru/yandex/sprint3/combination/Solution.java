package ru.yandex.sprint3.combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// B. Комбинации букв на телефоне
// https://contest.yandex.ru/contest/23638/problems/B/
public class Solution {

    private final Map<Integer, String[]> rows;
    Map<Integer, String> map;

    public Solution() {
        map = Map.of(
                2, "abc",
                3, "def",
                4, "ghi",
                5, "jkl",
                6, "mno",
                7, "pqrs",
                8, "tuv",
                9, "wxyz");

        rows = new HashMap<>();
    }

    public static void main(String[] args) {
        new Solution().run(args);
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (!digits.isEmpty()) {
            generateRow("", 0, digits, result);
        }
        return result;
    }

    private void generateRow(String currentValue, int keyPosition, String keys, List<String> result) {
        if (currentValue.length() == keys.length()) {
            result.add(currentValue);
            return;
        } else {
            int key = keys.charAt(keyPosition) - '0';
            String str = map.get(key);
            for (int i = 0; i < str.length(); i++) {
                String letter = Character.toString(str.charAt(i));
                generateRow(currentValue + letter, keyPosition + 1, keys, result);
            }
        }
    }

    private void run(String[] args) {
        try {
            String input = readInput();
            List<String> list = letterCombinations(input);
            System.out.println(String.join(" ", list));
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    private String readInput() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return reader.readLine();
        }
    }
}
