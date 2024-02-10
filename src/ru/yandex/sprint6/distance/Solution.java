package ru.yandex.sprint6.distance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

// F. Расстояние между вершинами
// https://contest.yandex.ru/contest/25069/problems/F/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {
/*
        Graph graph = new Graph(5 + 1, false);

        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(4, 5);

        int start = 1;
        graph.bfs(start);

        List<Integer> list = graph.shortestPath(5);

        System.out.println(list.size() - 1);
*/


     /*   Graph graph = new Graph(6 + 1, false);

        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        int start = 1;
        int end = 5;
        graph.bfs(start, end);

        System.out.println(graph.getPath(end));*/

/*
        List<Integer> list = graph.shortestPath(end);
        System.out.println(list.size() - 1);
*/

/*
        Graph graph = new Graph(1 + 1, false);

        int start = 1;
        graph.bfs(start);

        List<Integer> list = graph.shortestPath(1);
        System.out.println(list.size() - 1);*/

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

            stz = new StringTokenizer(reader.readLine());

            int start = Integer.parseInt(stz.nextToken());
            int end = Integer.parseInt(stz.nextToken());
            graph.bfs(start, end);
            System.out.println(graph.getPath(end));
        }
    }
}

class Graph {
    private final List<Integer>[] adj;              // список смежности
    private final boolean isOriented;                  // Ориентированность графа

    List<String> color;
    List<Integer> distance;


    public Graph(int vertexes, boolean isOriented) {
        this.isOriented = isOriented;

        adj = new ArrayList[vertexes];
        for (int i = 0; i < vertexes; i++) {
            adj[i] = new ArrayList<>();
        }

        color = new ArrayList<>(Collections.nCopies(vertexes, "white"));
        distance = new ArrayList<>(Collections.nCopies(vertexes, null));
    }

    public void addEdge(int from, int to) {
        adj[from].add(to);
        if (!isOriented) {
            adj[to].add(from);
        }
    }

    public void bfs(int s, int end) {
        // Создадим очередь вершин и положим туда стартовую вершину.
        List<Integer> planned = new LinkedList<>();
        planned.add(s);
        color.set(s, "gray");
        distance.set(s, 0);

        while (!planned.isEmpty()) {
            int u = planned.remove(0);  // Возьмём вершину из очереди.
            if (end == u) {
                break;
            }
            for (int v : adj[u]) {
                if (color.get(v).equals("white")) {
                    // Серые и чёрные вершины уже
                    // либо в очереди, либо обработаны.
                    distance.set(v, distance.get(u) + 1);
                    color.set(v, "gray");
                    planned.add(v);  // Запланируем посещение вершины.
                }
            }
        }
    }

    public int getPath(int v){
        return distance.get(v) == null ? -1 : distance.get(v);
    }

}