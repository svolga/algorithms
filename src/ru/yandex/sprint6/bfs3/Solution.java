package ru.yandex.sprint6.bfs3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

// D. BFS
// https://contest.yandex.ru/contest/25069/problems/D/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {
/*
        Graph graph = new Graph(4+1);

        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(1, 4);
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
        }
    }

}


class Graph {
    private final TreeSet<Integer>[] adj;              // список смежности
    private final boolean isOriented;                  // Ориентированность графа

    List<String> color;
    List<Integer> previous;
    List<Integer> distance;

    Comparator<Integer> comparator = (o1, o2) -> o1-o2;

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

        StringBuilder sb = new StringBuilder();
        while (!planned.isEmpty()) {
            int u = planned.poll();  // Возьмём вершину из очереди.

            sb.append(u).append(" ");

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

        System.out.println(sb);
    }
}
