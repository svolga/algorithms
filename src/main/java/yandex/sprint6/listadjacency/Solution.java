package java.yandex.sprint6.listadjacency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// A. Построить список смежности
// https://contest.yandex.ru/contest/25069/problems/
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

            List<Integer>[] list = makeList(edges, vertexes);
            print(list);
        }

/*
        int vertexes = 5;

        List<Edge> edges = new ArrayList<>();
        edges.add(new Edge(1, 3));
        edges.add(new Edge(2, 3));
        edges.add(new Edge(5, 2));

        List<Integer>[] list = makeList(edges, vertexes);
        print(list);
*/

    }

    private void print(List<Integer>[] list) {
        Comparator<Integer> comparator = Comparator.comparingInt(o -> o);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < list.length; i++) {
            List<Integer> ls = list[i];
            sb.append(ls.size()).append(" ");

            if (ls.size() > 0) {
                ls.stream()
                        .sorted(comparator)
                        .forEach(value -> sb.append(value).append(" "));
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private List<Integer>[] makeList(List<Edge> edges, int vertexes) {
        ArrayList<Integer>[] list = new ArrayList[vertexes + 1];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (Edge edge : edges) {
            list[edge.getFrom()].add(edge.getTo());
        }

        return list;
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
