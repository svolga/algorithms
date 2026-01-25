package java.yandex.sprint2.finaltz.calculator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// Номер посылки: 97896438
// Посылка: https://contest.yandex.ru/contest/22781/run-report/97896438/
// B. Калькулятор - обратная польская нотация
// https://contest.yandex.ru/contest/22781/problems/B/
/*
-- ПРИНЦИП РАБОТЫ --
Для реализации калькулятора с обратной польской нотацией использовался стек.
При разборе элементов строки с заданием, числа размещаются в стеке, при встрече математического оператора из стека
извлекаются два последних операнда и производится вычисление.
При этом результат также записывается в стек. По окончании вычислений в стеке остается одно значение,
которое является ответом.
Рассмотрим пример.
Пусть дана строка: 3 2 + 6 -
Алгоритм работы со строкой представлен в качестве примера на схеме по шагам:
https://joxi.ru/ZrJqxgVswXW8QA

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Добавление и удаление элементов из стека выполняются за константное время O(1)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Количество элементов, размещенных в стеке в худшем случае равно количеству всех чисел (n),
поэтому пространственная сложность составляет O(n).
 */

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

        Stack<Integer> stack = new Stack<>();
        while (stringTokenizer.hasMoreElements()) {
            String element = stringTokenizer.nextToken();

            Integer number = parseInt(element);
            if (number != null) {
                stack.push(number);
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
        return (int) Math.floor((double) a / b);
    }

    private Integer parseInt(String value) {
        if (value == null) {
            return null;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            return null;
        }
    }
}
