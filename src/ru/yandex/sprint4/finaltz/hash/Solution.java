package ru.yandex.sprint4.finaltz.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

// Номер посылки: 103711375
// Посылка: https://contest.yandex.ru/contest/24414/run-report/103711375/
// B. Хеш-таблица
// https://contest.yandex.ru/contest/24414/problems/B/
/*
-- ПРИНЦИП РАБОТЫ --
Для реализации хеш таблицы создан пользовательский класс CustomHashTableImpl, в качестве внутренней структуры
используется ArrayList с данными в виде корзин, которые хранят ссылки на голову односвязного списка.
Коллизии разрешаются методом цепочек.
Индексы массива рассчитываются через bucket ф-ию в зависимости от значения ключа и емкости массива.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Операции с таблицей в лучшем случае выполняются за константное время O(1), в худшем, когда данные выстраиваются в
одну цепочку за O(n). Среднее время - O(1).

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Для хранения данных используется O(n) памяти

 */

public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    List<Command> readInput() throws IOException {
        List<Command> commands = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            for (int i = 0; i < count; i++) {
                StringTokenizer stz = new StringTokenizer(reader.readLine());

                String operand = null;
                List<Integer> params = new ArrayList<>();
                int j = 0;
                while (stz.hasMoreTokens()) {
                    if (j == 0) {
                        operand = stz.nextToken();
                    } else {
                        params.add(Integer.parseInt(stz.nextToken()));
                    }
                    j++;
                }
                commands.add(new Command(operand, params));
            }
        }
        return commands;
    }

    private void run(String[] args) throws IOException {
        List<Command> commands = readInput();
        CustomHashTable<Integer, Person> hashTable = new CustomHashTableImpl<>();

        StringBuilder sb = new StringBuilder();
        for (Command command : commands) {
            switch (command.operand) {
                case "put":
                    hashTable.put(command.params.get(0), new Person(command.params.get(0), command.params.get(1)));
                    break;
                case "get":
                    Person person = hashTable.get(command.params.get(0));
                    sb.append(person == null ? "None" : person.getSalary()).append(System.lineSeparator());
                    break;
                case "delete":
                    Person deletedPerson = hashTable.delete(command.params.get(0));
                    sb.append(deletedPerson == null ? "None" : deletedPerson.getSalary()).append(System.lineSeparator());
                    break;
            }
        }
        System.out.println(sb);
    }

    class Node<K, V> {
        K key;
        V value;
        Node<K, V> next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    interface CustomHashTable<K, V> {
        void put(K key, V value);

        V delete(K key);

        V get(K key);
    }

    class CustomHashTableImpl<K, V> implements CustomHashTable<K, V> {

        private static final int DEFAULT_CAPACITY = 100_000;
        private final int capacity;
        private final List<Node<K, V>> data;

        public CustomHashTableImpl() {
            this(DEFAULT_CAPACITY);
        }

        public CustomHashTableImpl(int capacity) {
            this.capacity = capacity <= 0 ? capacity : DEFAULT_CAPACITY;
            data = new ArrayList<>(this.capacity);
            for (int i = 0; i < capacity; i++) {
                data.add(null);
            }
        }

        private int getBucket(K key) {
            int index = key.hashCode() % capacity;
            return index < 0 ? -1 * index : index;
        }

        @Override
        public V get(K key) {
            int index = getBucket(key);
            Node<K, V> head = data.get(index);
            return findElement(head, key);
        }

        @Override
        public void put(K key, V value) {
            int index = getBucket(key);
            int hashCode = key.hashCode();
            Node<K, V> head = data.get(index);

            while (head != null) {
                if (head.key.equals(key)) {
                    head.value = value;
                    return;
                }
                head = head.next;
            }

            head = data.get(index);
            Node<K, V> newNode = new Node<>(key, value);
            newNode.next = head;
            data.set(index, newNode);
        }

        @Override
        public V delete(K key) {
            int index = getBucket(key);
            Node<K, V> head = data.get(index);
            return removeElement(head, key, index);
        }

        private V findElement(Node<K, V> head, K key) {
            while (head != null) {
                if (head.key.equals(key))
                    return head.value;
                head = head.next;
            }

            return null;
        }

        private V removeElement(Node<K, V> head, K key, int index) {
            Node<K, V> prev = null;
            while (head != null) {
                if (head.key.equals(key)) {
                    break;
                }
                prev = head;
                head = head.next;
            }

            if (head == null) {
                return null;
            }

            if (prev != null) {
                prev.next = head.next;
            } else {
                data.set(index, head.next);
            }

            return head.value;
        }
    }

    class Person {
        private final int id;
        private final int salary;

        public Person(int id, int salary) {
            this.id = id;
            this.salary = salary;
        }

        public int getId() {
            return id;
        }

        public int getSalary() {
            return salary;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;
            Person person = (Person) o;
            return getId() == person.getId() && getSalary() == person.getSalary();
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getSalary());
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", salary=" + salary +
                    '}';
        }
    }

    class Command {
        String operand;
        List<Integer> params;

        public Command(String operand, List<Integer> params) {
            this.operand = operand;
            this.params = params;
        }

        @Override
        public String toString() {
            return "Command{" +
                    "operand='" + operand + '\'' +
                    ", params=" + params +
                    '}';
        }
    }

}
