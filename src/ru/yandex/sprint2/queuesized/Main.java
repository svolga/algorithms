package ru.yandex.sprint2.queuesized;

// I. Ограниченная очередь
// https://contest.yandex.ru/contest/22779/problems/I/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main {

    List<Command> commands;
    int maxSize;

    public Main() {
        commands = new ArrayList<>();
        maxSize = 0;
    }

    private void run(String[] args) {
        readInput();
        MyQueueSized myQueueSized = new MyQueueSized(maxSize);

        for (Command command : commands) {
            switch (command.operand) {
                case "push":
                    myQueueSized.push(command.param);
                    break;
                case "pop":
                    myQueueSized.pop();
                    break;
                case "peek":
                    myQueueSized.peek();
                    break;
                case "size":
                    myQueueSized.size();
                    break;
            }
        }
    }

    private void readInput() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int commandCount = Integer.parseInt(reader.readLine());
            maxSize = Integer.parseInt(reader.readLine());

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
    }

    public static void main(String[] args) {
        new Main().run(args);
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

class MyQueueSized {

    private Integer[] queue;
    int tail;
    int head;
    int max;
    int size;

    public MyQueueSized(int max) {
        this.max = max;
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        queue = new Integer[max];
    }

    public void push(int x) {
        if (size != max) {
            queue[tail] = x;
            tail = (tail + 1) % max;
            size++;
        } else {
            System.out.println("error");
        }
    }

    public Integer pop() {
        if (size == 0) {
            System.out.println("None");
            return null;
        }
        Integer value = queue[head];
        queue[head] = null;
        head = (head + 1) % max;
        size--;
        System.out.println(value);
        return value;
    }

    public Integer peek() {
        if (size == 0) {
            System.out.println("None");
            return null;
        }
        Integer value = queue[head];
        System.out.println(value);
        return value;
    }

    public Integer size() {
        System.out.println(size);
        return size;
    }
}
