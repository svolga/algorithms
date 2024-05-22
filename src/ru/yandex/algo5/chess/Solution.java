package ru.yandex.algo5.chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// D. Слоны и ладьи
// https://contest.yandex.ru/contest/59539/problems/D/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int n = 8;
            int m = 8;
            Manager manager = new Manager(n, m);
//            manager.add(new Coord(2, 1), TYPE.R);
//            manager.add(new Coord(2, 6), TYPE.B);
/*
            manager.add(new Coord(1, 1), TYPE.R);
            manager.add(new Coord(3, 5), TYPE.B);
*/

            for (int i = 0; i < n; i++) {
                String line = reader.readLine();
                for (int j = 0; j < m; j++) {
                    char ch = line.charAt(j);
                    TYPE type = null;
                    if (ch == 'B') {
                        manager.add(new Coord(i, j), TYPE.B);
                    } else if (ch == 'R') {
                        manager.add(new Coord(i, j), TYPE.R);
                    }
                }
            }
//            manager.add(new Coord(1, 2), TYPE.B);
//            manager.add(new Coord(2, 3), TYPE.R);

            manager.fillPath();
            System.out.println(manager.getEmpty());
        }
    }
}

class Manager {
    private final int n;
    private final int m;
    TYPE[][] dp;
    private final Map<Coord, TYPE> figures;

    public Manager(int n, int m) {
        dp = new TYPE[n][m];
        figures = new HashMap<>();
        this.n = n;
        this.m = m;
    }

    public void add(Coord coord, TYPE type) {
        figures.put(coord, type);
    }

    public void fillPath() {

        figures.forEach((coord, type) -> {

            dp[coord.getI()][coord.getJ()] = type;

            if (type.equals(TYPE.R)) {
                left(coord);
                right(coord);
                up(coord);
                down(coord);
            } else {
                leftTop(coord);
                leftBottom(coord);
                rightTop(coord);
                rightBottom(coord);
            }


        });

 //       print(dp);
        return;

    }

    public int getEmpty() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dp[i][j] == null) {
                    count++;
                }
            }
        }
        return count;
    }

    private void print(TYPE[][] dp) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < dp.length; i++) {

            for (int j = 0; j < n; j++) {
                sb.append(dp[i][j] == null ? '0' : dp[i][j]).append(" ");
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    public void rightBottom(Coord coord) {
        int i = coord.getI();
        int j = coord.getJ();

        while (i < n - 1 && j < m - 1) {

            if (figures.containsKey(new Coord(i + 1, j + 1))) {
                break;
            }

            if (dp[i + 1][j + 1] == null) {
                dp[i + 1][j + 1] = TYPE.B;
            }
            i++;
            j++;
        }
    }

    public void rightTop(Coord coord) {
        int i = coord.getI();
        int j = coord.getJ();

        while (i > 0 && j < m - 1) {

            if (figures.containsKey(new Coord(i - 1, j + 1))) {
                break;
            }

            if (dp[i - 1][j + 1] == null) {
                dp[i - 1][j + 1] = TYPE.B;
            }
            i--;
            j++;
        }
    }

    public void leftTop(Coord coord) {
        int i = coord.getI();
        int j = coord.getJ();

        while (i > 0 && j > 0) {

            if (figures.containsKey(new Coord(i - 1, j - 1))) {
                break;
            }

            if (dp[i - 1][j - 1] == null) {
                dp[i - 1][j - 1] = TYPE.B;
            }
            i--;
            j--;
        }
    }

    public void leftBottom(Coord coord) {
        int i = coord.getI();
        int j = coord.getJ();

        while (i < n - 1 && j > 0) {

            if (figures.containsKey(new Coord(i + 1, j - 1))) {
                break;
            }

            if (dp[i + 1][j - 1] == null) {
                dp[i + 1][j - 1] = TYPE.B;
            }
            i++;
            j--;
        }
    }


    public void down(Coord coord) {
        for (int i = coord.getI(); i < n - 1; i++) {

            if (figures.containsKey(new Coord(i + 1, coord.getJ()))) {
                break;
            }

            if (dp[i + 1][coord.getJ()] == null) {
                dp[i + 1][coord.getJ()] = TYPE.R;
            }
        }
    }

    public void up(Coord coord) {
        for (int i = coord.getI(); i > 0; i--) {

            if (figures.containsKey(new Coord(i - 1, coord.getJ()))) {
                break;
            }

            if (dp[i - 1][coord.getJ()] == null) {
                dp[i - 1][coord.getJ()] = TYPE.R;
            }
        }
    }

    public void left(Coord coord) {
        for (int j = coord.getJ(); j > 0; j--) {

            if (figures.containsKey(new Coord(coord.getI(), j - 1))) {
//                System.out.println("Занята координата " + new Coord(coord.getI(), j - 1));
                break;
            }

            if (dp[coord.getI()][j - 1] == null) {
                dp[coord.getI()][j - 1] = TYPE.R;
            }
        }
    }

    public void right(Coord coord) {
        for (int j = coord.getJ(); j < m - 1; j++) {

            if (figures.containsKey(new Coord(coord.getI(), j + 1))) {
                break;
            }

            if (dp[coord.getI()][j + 1] == null) {
                dp[coord.getI()][j + 1] = TYPE.R;
            }
        }
    }

}

enum TYPE {
    R(1),
    B(2);

    TYPE(int i) {
    }
}

class Coord {
    private final Integer i;
    private final Integer j;

    public Coord(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    @Override
    public String toString() {
        return "Coord{" +
                "i=" + i +
                ", j=" + j +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coord)) return false;
        Coord coord = (Coord) o;
        return getI() == coord.getI() && getJ() == coord.getJ();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getI(), getJ());
    }
}