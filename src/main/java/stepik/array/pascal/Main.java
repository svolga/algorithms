package stepik.array.pascal;

/*
https://stepik.org/lesson/1221926/step/8?unit=1235337

Треугольник Паскаля
Даны два числа n и m. Создайте двумерный массив A[n][m] и заполните его по следующим правилам:
Числа, стоящие в строке 0 или в столбце 0 равны 1 (A[0][j]=1, A[i][0]=1).
Для всех остальных элементов массива A[i][j]=A[i-1][j]+A[i][j-1], то есть каждый элемент равен
сумме двух элементов, стоящих слева и сверху от него.

Входные данные
Программа получает на вход два числа n и m.  Числа от 1 до 15.

Выходные данные
Выведите данный массив.

Значения требуется выровнять по правому краю. Если число однозначное, перед ним устанавливается 5 знаков
"пробел". Гарантируется, что все числа в правильном ответе не превышают 5 знаков в десятичной записи.

Входные данные
3 4

Выходные данные
     1     1     1     1
     1     2     3     4
     1     3     6    10
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        int[][] nums = new int[n][m];

        for (int i = 0; i < n; i++) {
            nums[i][0] = 1;
        }

        for (int j = 0; j < m; j++) {
            nums[0][j] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                nums[i][j] = nums[i][j-1] + nums[i-1][j];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(String.format("%6d", nums[i][j]));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

}
