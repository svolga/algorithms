package ru.yandex.sprint3.finaltz.effectquicksort;

// Номер посылки: 101307849
// Посылка: https://contest.yandex.ru/contest/23815/run-report/101307849/
// B. Эффективная быстрая сортировка
// https://contest.yandex.ru/contest/23815/problems/B/
/*
-- ПРИНЦИП РАБОТЫ --
Используется быстрая сортировка, в качестве разделителя выбирается элемент с индексом в середине массива.
Слева от разделителя размещаются элементы меньше него, справа больше,
Затем рекурсивно вызывается сортировка в левой и правой половине.
В качестве сравнения элементов используется компаратор по трем полям.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Сложность быстрой сортировки зависит от входных данных, в худшем случае составляет O(n^2),
когда массив отсортирован или все элементы равны. Или в качестве опорного элемента выбирается максимальный или
минимальный элемент.
Среднее значение сложности O(n log n)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Использует память в виде стека, рекурсивный алгоритм в худшем случае потребует O(n) стека, в среднем O(log n)
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Objects;
import java.util.StringTokenizer;

class InPlaceQuickSort<T> {

    private final Comparator<T> comparator;

    public InPlaceQuickSort(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void quickSort(T[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(array, left, right);
        if (left < pivotIndex - 1) {
            quickSort(array, left, pivotIndex - 1);
        }

        if (pivotIndex < right) {
            quickSort(array, pivotIndex, right);
        }
    }

    private int partition(T[] array, int left, int right) {

        T pivot = array[(left + right) / 2];
        int i = left;
        int j = right;

        while (i <= j) {
            while (comparator.compare(array[i], pivot) < 0) {
                i++;
            }
            while (comparator.compare(array[j], pivot) > 0) {
                j--;
            }
            if (i <= j) {
                swap(array, i, j);
                i++;
                j--;
            }
        }
        return i;
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}

public class Solution {

    public static void main(String[] args) {
        try {
            new Solution().run(args);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void run(String[] args) throws IOException {
        User[] users = getInput();
        Comparator<User> userComparator = getUserComparator();
        InPlaceQuickSort<User> qsort = new InPlaceQuickSort<>(userComparator);
        qsort.quickSort(users, 0, users.length - 1);
        print(users);
    }

    private Comparator<User> getUserComparator() {

        return (o1, o2) -> {
            int diff = o2.getPoint() - o1.getPoint();
            if (diff != 0) {
                return diff;
            }
            diff = o1.getForfeit() - o2.getForfeit();
            if (diff != 0) {
                return diff;
            }
            return o1.getLogin().compareTo(o2.getLogin());
        };
    }

    private User[] getInput() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            User[] users = new User[count];
            for (int i = 0; i < count; i++) {
                StringTokenizer stz = new StringTokenizer(reader.readLine());
                users[i] = new User(stz.nextToken(), Integer.parseInt(stz.nextToken()), Integer.parseInt(stz.nextToken()));
            }
            return users;
        }
    }

    private void print(User[] users) {
        StringBuilder sb = new StringBuilder();
        for (User user : users) {
            sb.append(user.getLogin()).append(System.lineSeparator());
        }
        System.out.println(sb);
    }

}

class User {
    private final String login;
    private final int point;
    private final int forfeit;

    public User(String login, int point, int forfeit) {
        this.login = login;
        this.point = point;
        this.forfeit = forfeit;
    }

    public String getLogin() {
        return login;
    }

    public int getPoint() {
        return point;
    }

    public int getForfeit() {
        return forfeit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return point == user.point && forfeit == user.forfeit && Objects.equals(login, user.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, point, forfeit);
    }

    @Override
    public String toString() {
        return login + '\'' +
                ", point=" + point +
                ", forfeit=" + forfeit +
                '}';
    }
}