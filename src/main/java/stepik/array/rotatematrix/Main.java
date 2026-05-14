package stepik.array.rotatematrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://stepik.org/lesson/1221926/step/6?unit=1235337
Дан двумерный массив массив N×M. Требуется повернуть его по часовой стрелке на 90 градусов.

Входные данные
3 4
1 2 3 4
5 6 7 8
9 10 11 12

Выходные данные
4 3
9 5 1
10 6 2
11 7 3
12 8 4

*/
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        int[][] matrix = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] line1 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                matrix[i][j] = Integer.parseInt(line1[j]);
            }
        }

        int[][] rotatedMatrix = new int[m][n];
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                rotatedMatrix[x][y] = matrix[n - y - 1][x];
            }
        }

        printMatrix(rotatedMatrix, m, n);
    }

    private static void printMatrix(int[][] matrix, int n, int m) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d %d", n, m)).append("\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
