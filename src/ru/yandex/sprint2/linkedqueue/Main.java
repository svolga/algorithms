package ru.yandex.sprint2.linkedqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    List<Command> commands = new ArrayList<>();

    private void readInput() {
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
    }

    private void run(String[] args) {
        readInput();
        LinkedQueue queue = new LinkedQueue();

        for (Command command : commands) {
            switch (command.operand) {
                case "put":
                    queue.put(command.param);
                    break;
                case "get":
                    if (queue.size() == 0) {
                        System.out.println("error");
                    } else {
                        System.out.println(queue.get());
                    }
                    break;
                case "size":
                    System.out.println(queue.size());
                    break;
            }
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


class Node {
    public Node next;
    int value;

    public Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

class LinkedQueue {

    private int size;
    private Node tail;
    private Node head;

    public LinkedQueue() {
        size = 0;
        tail = null;
        head = null;
    }

    public void put(int x) {
        Node node = new Node(x, null);

        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        size++;
    }

    public Integer get() {
        Integer value = head.value;

        head = head.next;
        size--;

        if (size == 1) {
            tail = head;
        } else if (size == 0) {
            tail = null;
        }
        return value;
    }

    public Integer size() {
        return size;
    }
}
