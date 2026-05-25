package stepik.array.diagonal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://stepik.org/lesson/1221926/step/11?unit=1235337

Заполнение диагоналями
Даны положительные целые числа
n и m. Создайте массив A[n][m] и заполните его, как показано на примере.

Входные данные

Программа получает на вход два числа
n и m, причём n * m ≤ 100


Выходные данные
Программа должна вывести полученный массив, отводя на вывод каждого числа ровно 3 символа.

Входные данные
4 10


Выходные данные
  0  1  3  6 10 14 18 22 26 30
  2  4  7 11 15 19 23 27 31 34
  5  8 12 16 20 24 28 32 35 37
  9 13 17 21 25 29 33 36 38 39

 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        int[][] nums = new int[n][m];
        int value = 0;

        // Идем по первой строке от 0 до m-1
        for (int startCol = 1; startCol < m; startCol++) {
            int row = 0;
            int col = startCol;
            while (row < n && col >= 0) {
                nums[row][col] = ++value;
                row++;
                col--;
            }
        }

        // Идем по последней колонке от 1 до n-1
        for (int startRow = 1; startRow < n; startRow++) {
            int col = m - 1;
            int row = startRow;
            while (row < n && col >= 0) {
                nums[row][col] = ++value;
                row++;
                col--;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(" ").append(String.format("%2d", nums[i][j]));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
