package stepik.array.many;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://stepik.org/lesson/1221926/step/2?unit=1235337
Дано число
n - размер квадратной матрицы. Создайте двумерный массив и заполните его нулями, единицами и двойками по правилу: единицы располагаются на побочной диагонали, нули над единицами, а двойки под. Выведите полученный двумерный массив на экран.

Тестовые данные
Входные данные
4

Выходные данные
0 0 0 1
0 0 1 2
0 1 2 2
1 2 2 2


 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < n - 1 - i) {
                    nums[i][j] = 0;
                } else if (j > n - 1 - i) {
                    nums[i][j] = 2;
                }
            }
            nums[i][n - 1 - i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(nums[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
