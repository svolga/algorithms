package java.yandex.sprint2.brackets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// H. Скобочная последовательность
// https://contest.yandex.ru/contest/22779/problems/H/

class Stack {
    List<Character> items;

    public Stack() {
        items = new ArrayList<>();
    }

    public void push(Character value) {
        items.add(value);
    }

    public Character pop() {
        return items.remove(items.size() - 1);
    }

    public Character peek() {
        return items.get(items.size() - 1);
    }

    public int size() {
        return items.size();
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String line = reader.readLine();
            boolean isCorrect = is_correct_bracket_seq(line);
            System.out.println(isCorrect ? "True" : "False");
        }
    }

    private static boolean is_correct_bracket_seq(String line) {

        Map<Character, Character> bracketList = Map.of(
                '}', '{',
                ')', '(',
                ']', '['
        );

        Stack stack = new Stack();
        for (int i = 0; i < line.length(); i++) {
            Character item = line.charAt(i);

            // В стек помещаем открывающиеся скобки
            if (!bracketList.containsKey(item)) {
                stack.push(item);
            } else { // встретилась скобка закрывающаяся
                if (stack.size() == 0) {
                    return false;
                } else {
                    // последняя скобка в стеке
                    Character openedBrake = stack.pop();
                    Character value = bracketList.get(item);
                    if (!value.equals(openedBrake)) {
                        return false;
                    }
                }
            }
        }
        return stack.size() == 0;
    }

}
