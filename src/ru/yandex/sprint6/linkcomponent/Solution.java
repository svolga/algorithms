package ru.yandex.sprint6.linkcomponent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

// E. Компоненты связности
// https://contest.yandex.ru/contest/25069/problems/E/

public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

/*
        Graph graph = new Graph(5 + 1, false);

        graph.addEdge(3, 2);
        graph.addEdge(4, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 2);
//        graph.addEdge(5, 5);

        graph.mainDFS();
        graph.print();
*/

//        System.out.println(Arrays.toString(graph.adj));

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
            graph.mainDFS();
            graph.print();
        }
    }

}

class Graph {
    public final TreeSet<Integer>[] adj;               // Список смежности
    private final boolean isOriented;                   // Ориентированость графа
    private int componentCount;

    private final static int GREY = -2;
    private final static int WHITE = -1;

    List<Integer> color;

    Comparator<Integer> comparator = (o1, o2) -> o2 - o1;

    public Graph(int vertexes, boolean isOriented) {
        this.isOriented = isOriented;
        this.componentCount = 0;

        adj = new TreeSet[vertexes];
        for (int i = 0; i < vertexes; i++) {
            adj[i] = new TreeSet<>(comparator);
        }
        color = new ArrayList<>(Collections.nCopies(vertexes, WHITE));
    }

    public void print() {
//        System.out.println("colors = " + color);
        Map<Integer, StringBuilder> map = new TreeMap<>();
        for (int i = 1; i < color.size(); i++) {
            StringBuilder sb = map.getOrDefault(color.get(i), new StringBuilder());
            sb.append(i).append(" ");
            map.put(color.get(i), sb);
        }

        Set<Integer> set = new HashSet<>(color);
        StringBuilder out = new StringBuilder();
        out.append(set.size() - 1).append(System.lineSeparator());
        map.forEach((integer, stringBuilder) -> out.append(stringBuilder).append(System.lineSeparator()));

        System.out.println(out);
    }

    public void addEdge(int from, int to) {
        adj[from].add(to);
        if (!isOriented) {
            adj[to].add(from);
        }
    }

    public void mainDFS() {
        for (int i = 0; i < color.size(); i++) {
            // Перебираем варианты стартовых вершин, пока они существуют.
            if (color.get(i).equals(-1)) {
                componentCount++;
                DFS(i, componentCount); // Запускаем обход, стартуя с i-й вершины.
            }

        }
    }

    void DFS(int startVertex, int componentCount) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);  // Добавляем стартовую вершину в стек.

//        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {  // Пока стек не пуст:
            // Получаем из стека очередную вершину.
            // Это может быть как новая вершина, так и уже посещённая однажды.
            int v = stack.pop();

            if (color.get(v).equals(WHITE)) {
                // Красим вершину в серый. И сразу кладём её обратно в стек:
                // это позволит алгоритму позднее вспомнить обратный путь по графу.
                color.set(v, GREY);
                stack.push(v);

//                sb.append(v).append(" ");

                // Теперь добавляем в стек все непосещённые соседние вершины,
                // вместо вызова рекурсии
                for (int w : adj[v]) {
                    // Для каждого исходящего ребра (v, w):
                    if (color.get(w).equals(-1)) {
                        stack.push(w);
                    }
                }
            } else if (color.get(v).equals(GREY)) {
                // Серую вершину мы могли получить из стека только на обратном пути
                // Следовательно, её следует перекрасить в цвет компоненты смежности
                color.set(v, componentCount);
            }
        }

//        System.out.println(sb);
    }
}
