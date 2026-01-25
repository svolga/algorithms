package java.yandex.sprint2.stackmaxeffective;

// G. Стек - MaxEffective
// https://contest.yandex.ru/contest/22779/problems/G/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class StackMaxEffective {

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

    private void run(String[] args) {
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

    public static void main(String[] args) {
        new StackMaxEffective().run(args);
    }
}

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
    List<Integer> max;

    public Stack() {
        this.max = new ArrayList<>();
    }

    public void push(Integer value) {
        max.add(
                max.size() == 0 || value > max.get(max.size() - 1) ? value : max.get(max.size() - 1)
        );
  }

    public Integer pop() {
        return max.remove(max.size() - 1);
    }

    public boolean isEmpty() {
        return max.isEmpty();
    }

    public int getMax() {
        return max.get(max.size() - 1);
    }
}
