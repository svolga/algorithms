package stepik.array.snake;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://stepik.org/lesson/1221926/step/10?unit=1235337

Заполнение змейкой
Даны числа n и m. Создайте массив A[n][m] и заполните его змейкой (см. пример).

Входные данные

Программа получает на вход два числа
n и m. Числа по модулю не превышают 2^31 − 1.

Выходные данные
Программа должна вывести  полученный массив, отводя на вывод каждого числа ровно 3 символа с выравниванием по правой стороне.

 Входные данные
 4 10

Выходные данные
  0  1  2  3  4  5  6  7  8  9
 19 18 17 16 15 14 13 12 11 10
 20 21 22 23 24 25 26 27 28 29
 39 38 37 36 35 34 33 32 31 30

 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        int[][] nums = new int[n][m];
        int value = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int col = (i % 2 == 0) ? j : m - j - 1;
                nums[i][col] = value;
                value++;
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
