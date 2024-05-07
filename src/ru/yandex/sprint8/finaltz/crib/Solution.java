package ru.yandex.sprint8.finaltz.crib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// B. Шпаргалка
// https://contest.yandex.ru/contest/26133/problems/B/
// Номер посылки: 113654399
// Посылка: https://contest.yandex.ru/contest/26133/run-report/113654399/
/*
-- ПРИНЦИП РАБОТЫ --
  1.  Создадим префиксное дерево на основе класс Node. Хранить переходы по ребрам будем в списке ребер.
  2.  Создадим массив с булевым типом данных для хранения признака - можно ли создать строку с данным индексом или нет.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
    Построение префиксного дерева - O(L), где L — суммарная длина всех слов во множестве.
    Прохождение по префиксному дереву - O(n^2), где n - количество символов в строке.

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
    Префиксное дерево - O(L), где L — суммарная длина всех слов во множестве.
    Массив - O(n), где n - количество символов в строке.
 */

public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String text = reader.readLine();
            int n = Integer.parseInt(reader.readLine());
            List<String> words = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                words.add(reader.readLine());
            }
/*
            String text = "abacaba";
            List<String> words = List.of("abac", "caba", "aba");
*/
/*
            String text = "examiwillpasstheexam";
            List<String> words = List.of("will", "pass", "the", "exam", "i");
*/
            System.out.println(canSplit(text, words) ? "YES" : "NO");
        }
    }

    public static Node createTrie(List<String> words) {
        Node root = new Node(' ', new HashMap<>());

        for (String word : words) {
            Node node = root;
            for (char c : word.toCharArray()) {
                node.next.putIfAbsent(c, new Node(c, new HashMap<>()));
                node = node.next.get(c);
            }
            node.terminal = true;
        }

        return root;
    }

    public static boolean canSplit(String input, List<String> words) {
        Node root = createTrie(words);
        boolean[] dp = new boolean[input.length() + 1];
        dp[0] = true;

        for (int i = 0; i < input.length() + 1; i++) {
            Node node = root;
            if (dp[i]) {
                for (int j = i; j < input.length() + 1; j++) {
                    if (node.terminal) {
                        dp[j] = true;
                    }

                    if (j == input.length() || !node.next.containsKey(input.charAt(j))) {
                        break;
                    }
                    node = node.next.get(input.charAt(j));
                }
            }
        }

        return dp[input.length()];
    }
}

class Node {
    char value;
    Map<Character, Node> next;
    boolean terminal;

    public Node(char value, Map<Character, Node> next) {
        this.value = value;
        this.next = next;
        this.terminal = false;
    }
}

