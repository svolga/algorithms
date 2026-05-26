package stepik.array.fillspiral;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://stepik.org/lesson/1221926/step/12?unit=1235337

Спираль
Требуется заполнить массив размера N×N единичками по спирали (начиная с верхнего левого угла по часовой стрелке, см. пример).

Входные данные
С клавиатуры вводится число N (нечетное, натуральное и не превышающее 50). Числа по модулю не превышают
2^31 − 1.

Выходные данные
Требуется вывести на экран построенную спираль.


Входные данные
7

Выходные данные
1111111
0000001
1111101
1000101
1011101
1000001
1111111

 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line);

        int[][] nums = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int value = 1;


        while (top <= bottom && left <= right) {

            // слева направо по верхней границе
            for (int i = left > 0 ? left - 1 : left; i <= right; i++) {
                nums[top][i] = value;
            }

            // сверху вниз по правой границе
            for (int i = top + 1; i <= bottom; i++) {
                nums[i][right] = value;
            }

            // справа налево по нижней границе
            if (top < bottom) {

                for (int i = right - 1; i >= left; i--) {
                    nums[bottom][i] = value;
                }
            }

            // снизу вверх по левой границе
            if (left < right) {
                for (int i = bottom - 1; i > top + 1; i--) {
                    nums[i][left] = value;
                }
            }

            top += 2;
            bottom -= 2;
            right -= 2;
            left += 2;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(nums[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

}
