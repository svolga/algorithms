package ru.yandex.sprint6.finaltz.expansivenet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// A. Дорогая сеть
// https://contest.yandex.ru/contest/25070/problems/A/
// Номер посылки: 107459451
// Посылка: https://contest.yandex.ru/contest/25070/run-report/107459451/
/*
-- ПРИНЦИП РАБОТЫ --
    Построим для неориентированного графа список смежности. Создадим класс Pair с вершиной и весом ребра.
    Компаратор класса сортирует вершины от большего веса к меньшему. Создаем кучу и размещаем в ней первую вершину.
    Перемещаемся по ребрам и формируем сумму весов.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
    O (E log E), где E - число ребер
-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
    O (V^2), где V - число вершин
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer stz = new StringTokenizer(reader.readLine());
            int vertexCount = Integer.parseInt(stz.nextToken());
            int edgeCount = Integer.parseInt(stz.nextToken());

            Prima prima = new Prima(vertexCount);

            for (int i = 0; i < edgeCount; i++) {
                stz = new StringTokenizer(reader.readLine());
                prima.add(
                        Integer.parseInt(stz.nextToken()),
                        Integer.parseInt(stz.nextToken()),
                        Integer.parseInt(stz.nextToken())
                );
            }

            String weight = prima.getWeigth();
            System.out.println(weight);
        }
    }

    private void test() {
/*
        Prima prima = new Prima(4, 4);
        prima.add(1, 2, 5);
        prima.add(1, 3, 6);
        prima.add(2, 4, 8);
        prima.add(3, 4, 3);

        int weight = prima.getWeigth();
        System.out.println(weight);
*/
    }
}

class Prima {
    private final List<ArrayList<Pair>> adj;
    private final int countVertex;
    private final static String OOPS_ADJ = "Oops! I did it again";

    public Prima(int countVertex) {
        this.countVertex = countVertex + 1;

        adj = new ArrayList<>();
        for (int i = 0; i < this.countVertex; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void add(int from, int to, int key) {
        adj.get(from).add(new Pair(to, key));
        adj.get(to).add(new Pair(from, key));
    }

    public String getWeigth() {

        Queue<Pair> queue = new PriorityQueue<>();

        queue.add(new Pair(1, 0));
        int[] visited = new int[countVertex];
        int weight = 0;
        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            int vertex = node.vertex;
            if (visited[vertex] == 1)
                continue;

            int key = node.key;
            weight += key;
            visited[vertex] = 1;
            for (Pair pair : adj.get(vertex)) {
                if (visited[pair.vertex] == 0) {
                    queue.add(new Pair(pair.vertex, pair.key));
                }
            }
        }

        long countVisited = Arrays.stream(visited)
                .filter(value -> value == 1)
                .count();

        return countVisited == countVertex - 1 ? String.valueOf(weight) : OOPS_ADJ;
    }
}

class Pair implements Comparable<Pair> {
    int vertex;
    int key;

    Pair(int v, int key) {
        this.vertex = v;
        this.key = key;
    }

    public int compareTo(Pair pair) {
        return pair.key - this.key;
    }
}
