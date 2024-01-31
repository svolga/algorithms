package ru.yandex.sprint6.matrixadjacency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// B. Перевести список ребер в матрицу смежности
// https://contest.yandex.ru/contest/25069/problems/B/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer stz = new StringTokenizer(reader.readLine());
            int vertexes = Integer.parseInt(stz.nextToken());
            int edgeCount = Integer.parseInt(stz.nextToken());
            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < edgeCount; i++) {
                StringTokenizer line = new StringTokenizer(reader.readLine());
                edges.add(new Edge(Integer.parseInt(line.nextToken()),
                        Integer.parseInt(line.nextToken())
                ));
            }

            int[][] mx = makeMatrix(edges, vertexes);
            print(mx);
        }

      /*  int vertexes = 5;

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(1, 3));
        edges.add(new Edge(2, 3));
        edges.add(new Edge(5, 2));

        int[][] mx = makeMatrix(edges, vertexes);
        print(mx);
       */
    }

    private void print(int[][] mx) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mx.length; i++) {
            for (int j = 0; j < mx[i].length; j++) {
                sb.append(mx[i][j]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private int[][] makeMatrix(List<Edge> edges, int vertexes) {
        int[][] mx = new int[vertexes][vertexes];
        for (Edge edge : edges) {
            mx[edge.getFrom() - 1][edge.getTo() - 1] = 1;
        }
        return mx;
    }

}

class Edge {
    private final int from;
    private final int to;

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public Edge(int from, int to) {
        this.from = from;
        this.to = to;
    }
}