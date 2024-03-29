package ru.yandex.sprint6.maxpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

// G. Максимальное расстояние
// https://contest.yandex.ru/contest/25069/problems/G/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {
/*
        Graph graph = new Graph(5 + 1);

        graph.addEdge(2, 1);
        graph.addEdge(4, 5);
        graph.addEdge(4, 3);
        graph.addEdge(3, 2);

        graph.bfs(2);
        int m = graph.maxPath();
        System.out.println(m);
*/


/*
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(1);
        list.add(3);
*/

/*
        Graph graph = new Graph(3+1);

        graph.addEdge(3, 2);
        graph.addEdge(1, 3);

        graph.bfs(3);
*/

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer stz = new StringTokenizer(reader.readLine());

            int vertexCount = Integer.parseInt(stz.nextToken());
            int edgeCount = Integer.parseInt(stz.nextToken());

            Graph graph = new Graph(vertexCount + 1, false);

            for (int i = 0; i < edgeCount; i++) {
                StringTokenizer line = new StringTokenizer(reader.readLine());
                int from = Integer.parseInt(line.nextToken());
                int to = Integer.parseInt(line.nextToken());
                graph.addEdge(from, to);
            }

            int start = Integer.parseInt(reader.readLine());
            graph.bfs(start);

            System.out.println(graph.maxPath());
        }
    }
}

class Graph {
    private final TreeSet<Integer>[] adj;                 // Список смежности
    private final boolean isOriented;                     // Ориентированность графа

    List<String> color;
    List<Integer> previous;
    List<Integer> distance;

    Comparator<Integer> comparator = Comparator.comparingInt(o -> o);

    public Graph(int vertexes, boolean isOriented) {
        this.isOriented = isOriented;

        adj = new TreeSet[vertexes];
        for (int i = 0; i < vertexes; i++) {
            adj[i] = new TreeSet<>(comparator);
        }

        color = new ArrayList<>(Collections.nCopies(vertexes, "white"));
        previous = new ArrayList<>(Collections.nCopies(vertexes, null));
        distance = new ArrayList<>(Collections.nCopies(vertexes, null));
    }

    public void addEdge(int from, int to) {
        adj[from].add(to);
        if (!isOriented) {
            adj[to].add(from);
        }
    }

    public void bfs(int s) {
        // Создадим очередь вершин и положим туда стартовую вершину.
        Queue<Integer> planned = new LinkedList<>();
        planned.add(s);
        color.set(s, "gray");
        distance.set(s, 0);

        while (!planned.isEmpty()) {
            int u = planned.poll();  // Возьмём вершину из очереди.

            for (int v : adj[u]) {
                if (color.get(v).equals("white")) {
                    // Серые и чёрные вершины уже
                    // либо в очереди, либо обработаны.
                    distance.set(v, distance.get(u) + 1);
                    previous.set(v, u);
                    color.set(v, "gray");
                    planned.add(v);  // Запланируем посещение вершины.
                }
            }
            color.set(u, "black");  // Теперь вершина считается обработанной.
        }
    }

    public int maxPath() {
        return distance.stream()
                .filter(Objects::nonNull)
                .max(Comparator.comparingInt(o -> o))
                .orElse(0);
    }
}

