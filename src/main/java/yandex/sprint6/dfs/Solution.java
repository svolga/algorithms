package java.yandex.sprint6.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.TreeSet;

// C. DFS
// https://contest.yandex.ru/contest/25069/problems/C/
/*
Если граф представлен списками смежности, то перебрать все смежные вершины можно за время, пропорциональное числу
этих вершин. Фактически мы перебираем рёбра, исходящие из вершины. Поскольку алгоритм обрабатывает все вершины, ему
придётся пройтись по всем спискам смежности. Это эквивалентно тому, чтобы пройти по каждому ребру по одному разу,
что займёт O(E). Получим, что итоговая сложность алгоритма O(V+E)
Для неориентированного графа каждое ребро встречается дважды, однако на сложность это не повлияет:
O(V)+O(2E)=O(V+E).
 */


public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {
        /*
        Graph graph = new Graph(4+1);

        graph.addEdge(3, 2);
        graph.addEdge(4, 3);
        graph.addEdge(1, 4);
        graph.addEdge(1, 2);

        graph.DFS(3);
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
            graph.DFS(start);
        }
    }

}

class Graph {
    private final TreeSet<Integer>[] adj;               // Список смежности
    private final boolean isOriented;                   // Ориентированость графа

    List<String> color;

    Comparator<Integer> comparator = (o1, o2) -> o2 - o1;

    public Graph(int vertexes, boolean isOriented) {
        this.isOriented = isOriented;

        adj = new TreeSet[vertexes];
        for (int i = 0; i < vertexes; i++) {
            adj[i] = new TreeSet<>(comparator);
        }
        color = new ArrayList<>(Collections.nCopies(vertexes, "white"));
    }

    public void addEdge(int from, int to) {
        adj[from].add(to);
        if (!isOriented) {
            adj[to].add(from);
        }
    }

    private void mainDFS() {
        for (int i = 0; i < color.size(); i++) {
            // Перебираем варианты стартовых вершин, пока они существуют.
            if (color.get(i).equals("white")) {
                DFS(i); // Запускаем обход, стартуя с i-й вершины.
            }
        }
    }

    void DFS(int startVertex) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);  // Добавляем стартовую вершину в стек.

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {  // Пока стек не пуст:
            // Получаем из стека очередную вершину.
            // Это может быть как новая вершина, так и уже посещённая однажды.
            int v = stack.pop();

            if (color.get(v).equals("white")) {
                // Красим вершину в серый. И сразу кладём её обратно в стек:
                // это позволит алгоритму позднее вспомнить обратный путь по графу.
                color.set(v, "gray");
                stack.push(v);

                sb.append(v).append(" ");

                // Теперь добавляем в стек все непосещённые соседние вершины,
                // вместо вызова рекурсии
//                    for (int w : outgoingEdges) {
                for (int w : adj[v]) {
                    // Для каждого исходящего ребра (v, w):
                    if (color.get(w).equals("white")) {
                        stack.push(w);
                    }
                }
            } else if (color.get(v).equals("gray")) {
                // Серую вершину мы могли получить из стека только на обратном пути.
                // Следовательно, её следует перекрасить в чёрный.
                color.set(v, "black");
            }
        }

        System.out.println(sb);
    }

}
