package ru.yandex.sprint2.stackmax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;


// F. Стек - Max
// https://contest.yandex.ru/contest/22779/problems/F/

class Command {
    String operand;
    Integer param;

    public Command(String operand, Integer param) {
        this.operand = operand;
        this.param = param;
    }

    @Override
    public String toString() {
        return "Command{" +
                "operand='" + operand + '\'' +
                ", param=" + param +
                '}';
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

    public int getMax() {
        return items.stream()
                .mapToInt(value -> value)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }
}

public class StackMax {

    private List<Command> getCommands() {
        List<Command> commands = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int commandCount = Integer.parseInt(reader.readLine());

            for (int i = 0; i < commandCount; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
                commands.add(new Command(
                        stringTokenizer.nextToken(),
                        stringTokenizer.hasMoreTokens() ? Integer.valueOf(stringTokenizer.nextToken()) : null
                ));
            }

        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return commands;
    }

    private void run() {
        Stack stack = new Stack();

        List<Command> commands = getCommands();
        for (Command command : commands) {
            switch (command.operand) {
                case "push":
                    stack.push(command.param);
                    break;
                case "pop":
                    if (stack.isEmpty()) {
                        System.out.println("error");
                    } else {
                        stack.pop();
                    }
                    break;
                case "get_max":
                    if (stack.isEmpty()) {
                        System.out.println("None");
                    } else {
                        System.out.println(stack.getMax());
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new StackMax().run();
    }

}