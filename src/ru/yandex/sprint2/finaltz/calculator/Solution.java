package ru.yandex.sprint2.finaltz.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// Номер посылки: 97611947
// Посылка: https://contest.yandex.ru/contest/22781/run-report/97611947/
// B. Калькулятор - обратная польская нотация
// https://contest.yandex.ru/contest/22781/problems/B/

public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        StringTokenizer stringTokenizer = readInput(args);
        int result = calculatePolishNotation(stringTokenizer);
        System.out.println(result);
    }

    private int calculatePolishNotation(StringTokenizer stringTokenizer) {

        if (stringTokenizer == null) {
            return 0;
        }

        Stack stack = new Stack();
        while (stringTokenizer.hasMoreElements()) {
            String element = stringTokenizer.nextToken();

            if (isNumber(element)) {
                stack.push(Integer.valueOf(element));
            } else {
                int result = 0;
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (element) {
                    case "+":
                        result = val2 + val1;
                        break;
                    case "-":
                        result = val2 - val1;
                        break;
                    case "*":
                        result = val2 * val1;
                        break;
                    case "/":
                        result = divide(val2, val1);
                        break;
                }

                stack.push(result);
            }
        }

        return stack.isEmpty() ? 0 : stack.pop();
    }

    StringTokenizer readInput(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = reader.readLine();
            return new StringTokenizer(line);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    private int divide(int a, int b) {
        return a > 0 ? a / b : (int) Math.floor(1.0 * a / b);
    }

    private boolean isNumber(String value) {
        if (value == null) {
            return false;
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}


class Stack {
    List<Integer> items;

    public Stack() {
        this.items = new ArrayList<>();
    }

    public void push(Integer item) {
        items.add(item);
    }

    public Integer pop() {
        return items.remove(items.size() - 1);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}