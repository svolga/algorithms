package ru.yandex.sprint2.finaltz.deque;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// Номер посылки: 97898875
// https://contest.yandex.ru/contest/22781/run-report/97898875/
// A. Дек
// https://contest.yandex.ru/contest/22781/problems/A/

/*
-- ПРИНЦИП РАБОТЫ --
Задача – реализовать Дек на кольцевом буфере.
Дек – двусторонняя очередь, в которой элементы могут добавляться и удаляться как из начала, так и с конца очереди.
Очередь – структура данных, поддерживающая принцип FIFO.
Для хранения данных выбран массив с настраиваемыми параметрами:
capacity – максимальная емкость массива и
size – текущее количество элементов в массиве.
Еще две переменные head и tail – хранят индексы текущего значения головы и хвоста Дека.

При добавлении элемента в голову очереди происходит смещение индекса head - против часовой стрелки по кольцу,
при добавлении в конец – по часовой стрелке. При удалении элементов из head и tail, смещение индексов происходит
наоборот, для head – по часовой, для tail – против.

Рассмотрим схематично массив в некоторый момент времени после наполнения тремя элементам.
Например, массив:  [77, 33, null, null, null, 88] в котором добавлено 2 элемента в голову и 1 элемент в конец очереди
можно представить на картинке:
https://joxi.ru/KAgMR3KCEQ6Dem

При добавлении еще одного элемента в голову Дека – будет добавлено значение в ячейку массива с индексом 4, а значение
head сместится на одну позицию влево и станет равным 3.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
При работе с кольцевым буфером элементы добавляются и удаляются в массив фиксированной длины. Индексы элементов,
над которыми совершаются операции - посчитаны заранее, поэтому временная сложность операций добавления и удаления
выполняются за константное время O(1)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --.
Так как для хранения данных используется массив, то для добавления максимального количества, скажем n элементов,
понадобится массив имеющий длину n, поэтому пространственная сложность составляет O(n).
 */

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
                        deque.pushFront(command.param);
                    }
                    break;
                case "pop_front":
                    if (deque.isEmpty()) {
                        stringBuilder.append("error").append(System.lineSeparator());
                    } else {
                        stringBuilder.append(deque.popFront()).append(System.lineSeparator());
                    }
                    break;
                case "push_back":
                    if (deque.isFull()) {
                        stringBuilder.append("error").append(System.lineSeparator());
                    } else {
                        deque.pushBack(command.param);
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()) {
                        stringBuilder.append("error").append(System.lineSeparator());
                    } else {
                        stringBuilder.append(deque.popBack()).append(System.lineSeparator());
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

    public void pushFront(int value) {
        if (!isFull()) {
            deque[head] = value;
            head = (head - 1 + capacity) % capacity;
            size++;
        }
    }

    public void pushBack(int value) {
        if (!isFull()) {
            deque[tail] = value;
            tail = (tail + 1) % capacity;
            size++;
        }
    }

    public Integer popFront() {
        if (isEmpty()) {
            return null;
        }
        head = (head + 1) % capacity;
        Integer x = deque[head];
        deque[head] = null;
        size--;
        return x;
    }

    public Integer popBack() {
        if (isEmpty()) {
            return null;
        }
        tail = (tail - 1 + capacity) % capacity;
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