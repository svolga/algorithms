package ru.yandex.sprint6.finaltz.railway;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

// B. Железные дороги
// https://contest.yandex.ru/contest/25070/problems/B/
// Номер посылки: 107648508
// Посылка: https://contest.yandex.ru/contest/25070/run-report/107648508/
/*
-- ПРИНЦИП РАБОТЫ --
    Составим список смежности для направленного графа по след. принципу:
    Дороги типа B идут от меньшего города к большему, дороги типа R от большего к меньшему.
    Если из одного города можно перемещаться в другие и вернуться в исходную точку, то считаем,
    что для города существуют как дороги одного типа, так и другого. В этом случае путь образует цикл.

    Примеры расположения дорог:
    https://joxi.ru/12MQy01slZJd12

     Поиск цикла в ориентированном графе с использованием цветов:
    https://www.geeksforgeeks.org/detect-cycle-direct-graph-using-colors/

     Используем массив с цветами для определения посещенных городов:
     0 - WHITE - город не посещали,
     1 - GREY  - посетили, не обработали
     2 - BLACK - посетили, обработали

    Если в процессе обхода встретили город с серым цветом, то получаем цикл, значит путь неоптимальный.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
    Перебрать все смежные вершины можно за время, пропорциональное числу вершин V.
    Фактически мы перебираем рёбра, исходящие из вершины. Поскольку алгоритм обрабатывает все вершины,
    ему придётся пройтись по всем спискам смежности. Это эквивалентно тому, чтобы пройти по каждому ребру по
    одному разу, что займёт
    O(V+E)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
     Граф представлен в виде списков смежности, для каждой вершины хранится список смежных с ней вершин.
     Занимаемая память при таком способе хранения составляет O(V+E),
     где E - количество вершин, V - количество рёбер.
     Когда мы работаем с ориентированным графом, то объем задействованной памяти будет меньше,
     чем при неориентированном (из-за отсутствия дублирования).
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());

            Road road = new Road(count);
            for (int i = 0; i < count - 1; i++) {
                String roadTypes = reader.readLine().trim();
                for (int j = 0; j < roadTypes.length(); j++) {
                    road.add(roadTypes.charAt(j), i, j);
                }
            }

            System.out.println(road.isOptimal());
        }
    }
}

class Road {
    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;
    private static final char ROAD_B = 'B';
    private static final char ROAD_R = 'R';
    private final Map<Integer, List<Integer>> adjacency;

    public Road(int count) {
        adjacency = new HashMap<>();
        for (int i = 0; i < count; i++) {
            adjacency.put(i, new ArrayList<>());
        }
    }

    public void add(char typeRoad, int i, int j) {
        if (typeRoad == ROAD_B) {
            adjacency.get(i).add(i + j + 1);
        } else if (typeRoad == ROAD_R) {
            adjacency.get(i + j + 1).add(i);
        }
    }

    private boolean dfsIsCyclic(int startVertex, int[] colors) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (colors[v] == WHITE) {
                colors[v] = GRAY;
                stack.push(v);
                for (int w : adjacency.get(v)) {
                    if (colors[w] == WHITE) {
                        stack.push(w);
                    } else if (colors[w] == GRAY) {
                        return true;
                    }
                }
            } else if (colors[v] == GRAY) {
                colors[v] = BLACK;
            }
        }
        return false;
    }

    private boolean isCyclic() {
        int[] colors = new int[adjacency.size()];
        for (int i = 0; i < adjacency.size(); i++) {
            if (dfsIsCyclic(i, colors)) {
                return true;
            }
        }
        return false;
    }

    public String isOptimal() {
        return isCyclic() ? "NO" : "YES";
    }

}