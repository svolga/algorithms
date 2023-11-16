package ru.yandex.sprint2.finaltz.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// Номер посылки: 97474348
// Посылка: https://contest.yandex.ru/contest/22781/run-report/97474348/
// A. Дек
// https://contest.yandex.ru/contest/22781/problems/A/
public class Solution {

    private final List<Command> commands;
    private int capacity;

    public Solution() {
        this.capacity = 0;
        this.commands = new ArrayList<>();
    }

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void readInput() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int commandCount = Integer.parseInt(reader.readLine());
            this.capacity = Integer.parseInt(reader.readLine());

            for (int i = 0; i < commandCount; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

                commands.add(new Command(
                        stringTokenizer.nextToken(),
                        stringTokenizer.hasMoreTokens() ? Integer.parseInt(stringTokenizer.nextToken()) : null
                ));
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void run(String[] args) {
        readInput();

        StringBuilder stringBuilder = new StringBuilder();
        Deque deque = new Deque(capacity);

        for (Command command : commands) {
            switch (command.operand) {
                case "push_front":
                    if (deque.isFull()) {
                        stringBuilder.append("error").append(System.lineSeparator());
                    } else {
                        deque.push_front(command.param);
                    }
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        stringBuilder.append("error").append(System.lineSeparator());
                    } else {
                        stringBuilder.append(deque.pop_front()).append(System.lineSeparator());
                    }
                    break;
                case "push_back":
                    if (deque.isFull()) {
                        stringBuilder.append("error").append(System.lineSeparator());
                    } else {
                        deque.push_back(command.param);
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        stringBuilder.append("error").append(System.lineSeparator());
                    } else {
                        stringBuilder.append(deque.pop_back()).append(System.lineSeparator());
                    }
                    break;
            }
        }

        System.out.println(stringBuilder);
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

class Deque {
    private final Integer[] deque;
    private final int capacity;
    private int head;
    private int tail;
    private int size;

    public Deque(int capacity) {
        this.capacity = capacity;
        this.head = 0;
        this.tail = 1;
        this.size = 0;
        deque = new Integer[capacity];
    }

    public void push_front(int value) {
        if (!isFull()) {
            deque[head] = value;
            if (--head < 0) {
                head = capacity + head;
            }
            size++;
        }
    }

    public void push_back(int value) {
        if (!isFull()) {
            deque[tail] = value;
            tail = (tail + 1) % capacity;
            size++;
        }
    }

    public Integer pop_front() {
        if (isEmpty()) {
            return null;
        }
        head = (head + 1) % capacity;
        Integer x = deque[head];
        deque[head] = null;
        size--;
        return x;
    }

    public Integer pop_back() {
        if (isEmpty()) {
            return null;
        }
        if (--tail < 0) {
            tail = tail + capacity;
        }
        Integer x = deque[tail];
        deque[tail] = null;
        size--;
        return x;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void print() {
        System.out.println(Arrays.toString(deque));
    }
}