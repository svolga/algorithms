package java.yandex.sprint5.finaltz.sortheap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

// A. Пирамидальная сортировка
// https://contest.yandex.ru/contest/24810/problems/A/
// Номер посылки: 105865573
// Посылка: https://contest.yandex.ru/contest/24810/run-report/105865573/
/*
-- ПРИНЦИП РАБОТЫ --
Создадим пустую бинарную невозрастающую кучу (max-heap).
Вставим в неё по одному все элементы массива, сохраняя свойства кучи. Так как нам нужна сортировка игроков
с более высокими результатами к менее высоким, т.е. от большего к меньшему, на вершине пирамиды должен оказаться
участник с лучшим результатами.
Будем извлекать из неё наиболее приоритетные элементы (с самым высоким значением), удаляя их из кучи.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Сложность пирамидальной сортировки в худшем случае O(n log n)
На первом этапе идет создание бинарной кучи. Сложность этой операции — O(1)
Далее идет вставка n элементов подряд в бинарную кучу.
Сложность этого этапа:
O(log1)+O(log2)+...+O(log n) = O(n logn)
Последним шагом извлекаем n элементов. Сложность этой операции также не больше, чем O(n logn).

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
  При просеивании идет рекурсия и создание временной переменной, в итоге сложность составит log(h)

*/

public class Solution {

    private final Heap<Person> heap = new Heap<>();

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {
        readInput();
        print(heap.heapsort());
    }

    private void print(List<Person> result) {
        StringBuilder sb = new StringBuilder();
        for (Person person : result) {
            sb.append(person.getLogin()).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private void readInput() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());

            for (int i = 0; i < count; i++) {
                StringTokenizer stz = new StringTokenizer(reader.readLine());

                String login = stz.nextToken();
                int pointCount = Integer.parseInt(stz.nextToken());
                int penaltyCount = Integer.parseInt(stz.nextToken());

                heap.add(new Person(login, pointCount, penaltyCount));
            }
        }
    }
}

class Heap<T extends Person> {
    // Бинарная куча
    private final List<T> heap;

    public Heap() {
        heap = new ArrayList<>();
    }

    public void add(T item) {
        heapAdd(item);
    }

    public List<T> heapsort() {
        // Будем извлекать из неё наиболее приоритетные элементы, удаляя их из кучи.
        List<T> sortedArray = new ArrayList<>();
        while (!heap.isEmpty()) {
            T max = popMax();
            sortedArray.add(max);
        }
        return sortedArray;
    }

    private void heapAdd(T key) {
        int index = heap.size() + 1;
        heap.add(key);
        siftUp(index);
    }

    private T popMax() {
        T result = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        siftDown(0);
        return result;
    }

    private void siftUp(int index) {
        if (index == 1) {
            return;
        }

        int parentIndex = index / 2;
        if (heap.get(parentIndex - 1).compareTo(heap.get(index - 1)) > 0) {
            T temp = heap.get(parentIndex - 1);
            heap.set(parentIndex - 1, heap.get(index - 1));
            heap.set(index - 1, temp);
            siftUp(parentIndex);
        }
    }

    private void siftDown(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        // Нет дочерних узлов
        if (heap.size() - 1 < left) {
            return;
        }

        int indexLargest = (right < heap.size() && heap.get(left).compareTo(heap.get(right)) > 0) ? right : left;

        if (heap.get(index).compareTo(heap.get(indexLargest)) > 0) {
            Collections.swap(heap, index, indexLargest);
            siftDown(indexLargest);
        }
    }
}

class Person implements Comparable<Person> {
    private final String login;
    private final Integer pointCount;
    private final Integer penaltyCount;

    public Person(String login, int pointCount, int penaltyCount) {
        this.login = login;
        this.pointCount = pointCount;
        this.penaltyCount = penaltyCount;
    }

    public String getLogin() {
        return login;
    }

    public Integer getPointCount() {
        return pointCount;
    }

    public Integer getPenaltyCount() {
        return penaltyCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(getLogin(), person.getLogin()) && Objects.equals(getPointCount(),
                person.getPointCount()) && Objects.equals(getPenaltyCount(), person.getPenaltyCount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLogin(), getPointCount(), getPenaltyCount());
    }

    @Override
    public int compareTo(Person o) {
        if (!o.pointCount.equals(this.pointCount)) {
            return o.pointCount.compareTo(this.pointCount);
        }
        if (!o.penaltyCount.equals(this.penaltyCount)) {
            return this.penaltyCount.compareTo(o.penaltyCount);
        }
        return this.login.compareTo(o.login);
    }

    @Override
    public String toString() {
        return "Person{" +
                "login='" + login + '\'' +
                ", doneTaskCount=" + pointCount +
                ", penaltyCount=" + penaltyCount +
                '}' + System.lineSeparator();
    }
}