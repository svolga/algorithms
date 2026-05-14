package stepik.array.mine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://stepik.org/lesson/1221926/step/5?unit=1235337
Напишите программу, отображающую игровое поле для игры "Сапер".

Входные данные
3 2
2
1 1
2 2

Выходные данные
* 2
2 *
1 1

 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);
        int w = Integer.parseInt(br.readLine());
        int[][] matrix = new int[n][m];

        for (int i = 0; i < w; i++) {
            String[] coords = br.readLine().split(" ");
            int mineX = Integer.parseInt(coords[0]);
            int mineY = Integer.parseInt(coords[1]);
            matrix[mineX - 1][mineY - 1] = -1;
        }


        // Заполняем
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (matrix[i][j] == -1) {
                    continue;
                }

                int count = 0;
                for (int x = -1; x <= 1; x++) {
                    for (int y = -1; y <= 1; y++) {

                        int nx = i + x;
                        int ny = j + y;

                        if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                            if (matrix[nx][ny] == -1) {
                                count++;
                            }
                        }
                    }
                }
                matrix[i][j] = count;
            }
        }

        printMatrix(matrix, n, m);
    }

    private static void printMatrix(int[][] matrix, int n, int m) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(matrix[i][j] == -1 ? "*" : matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
