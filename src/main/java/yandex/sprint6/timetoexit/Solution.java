package java.yandex.sprint6.timetoexit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

// H. Время выходить
// https://contest.yandex.ru/contest/25069/problems/H/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {
/*
        Graph graph = new Graph(3 + 1, true);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.DFS(1);
        graph.print();
*/

/*
        Graph graph = new Graph(6 + 1, true);
        graph.addEdge(2, 6);
        graph.addEdge(1, 6);
        graph.addEdge(3, 1);
        graph.addEdge(2, 5);
        graph.addEdge(4, 3);
        graph.addEdge(3, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.DFS(1);
        graph.print();
*/

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer stz = new StringTokenizer(reader.readLine());

            int vertexCount = Integer.parseInt(stz.nextToken());
            int edgeCount = Integer.parseInt(stz.nextToken());

            Graph graph = new Graph(vertexCount + 1, true);

            for (int i = 0; i < edgeCount; i++) {
                StringTokenizer line = new StringTokenizer(reader.readLine());
                int from = Integer.parseInt(line.nextToken());
                int to = Integer.parseInt(line.nextToken());
                graph.addEdge(from, to);
            }

            graph.DFS(1);
            graph.print();
        }
    }
}

class Graph {
    private final Set<Integer>[] adj;    // список смежности
    private final boolean isOriented;        // Граф - неориентированный
    int time = 0;

    List<String> color;
    List<Integer> entry;
    List<Integer> leave;


    Comparator<Integer> comparator = Comparator.comparingInt(o -> o);

    public Graph(int vertexes, boolean isOriented) {
        this.isOriented = isOriented;

        adj = new TreeSet[vertexes];

        for (int i = 0; i < vertexes; i++) {
            adj[i] = new TreeSet<>(comparator);
        }
        color = new ArrayList<>(Collections.nCopies(vertexes, "white"));
        entry = new ArrayList<>(Collections.nCopies(vertexes, null));
        leave = new ArrayList<>(Collections.nCopies(vertexes, null));
    }

    public void addEdge(int from, int to) {
        adj[from].add(to);
        if (!isOriented) {
            adj[to].add(from);
        }
    }

    void DFS(int v) {
        time += 1;  // При входе в вершину время (номер шага) увеличивается.
        entry.set(v, time);  // Запишем время входа.
        color.set(v, "gray");
//        System.out.println(v);
        for (int w : adj[v]) {
            if (color.get(w).equals("white")) {
                DFS(w);
            }
        }
        time += 1;  // Перед выходом из вершины время снова обновляется.
        leave.set(v, time);  // Запишем время выхода.
        color.set(v, "black");
    }

    public void print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < entry.size(); i++) {
            int en = entry.get(i);
            int le = leave.get(i);

            sb.append(en - 1).append(" ").append(le - 1).append(System.lineSeparator());
        }

        System.out.println(sb);
    }

}
