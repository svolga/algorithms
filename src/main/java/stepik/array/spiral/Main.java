package stepik.array.spiral;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://stepik.org/lesson/1221926/step/9?unit=1235337

Заполнение спиралью
Дано число n. Создайте массив A[2*n+1][2*n+1] и заполните его по спирали, начиная с числа 0
в центральной клетке A[n+1][n+1]. Спираль выходит вверх, далее закручивается против часовой стрелки.

Входные данные
Программа получает на вход одно число
0 ≤ n < 2^31

Выходные данные
Программа должна вывести  полученный массив, отводя на вывод каждого числа не менее 3 символов.
Однозначное значение выравнивается посередине. Более длинные числа выравниваются слева.

Входные данные
2

Выходные данные
12 11 10  9 24
13  2  1  8 23
14  3  0  7 22
15  4  5  6 21
16 17 18 19 20
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        n = 2 * n + 1;

        int[][] nums = new int[n][n];

        int x = (n - 1) / 2;
        int y = (n - 1) / 2;

        int value = 0; // Начальное значение
        int steps = 1; // Шагов в одном направлении
        int direction = 0; // 0: вправо, 1: вверх, 2: влево, 3: вниз

        // Смещение для направлений: вверх, влево, вниз, вправо
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        nums[y][x] = value;

        while (value < n * n - 1) {

            // Делаем два направления с одинаковым количеством шагов (например, вправо-вверх, потом влево-вниз)
            for (int i = 0; i < 2; i++) {

                for (int j = 0; j < steps; j++) {
                    x += dx[direction];
                    y += dy[direction];

                    // Проверка выхода за границы
                    if (x >= 0 && x < n && y >= 0 && y < n) {
                        nums[y][x] = ++value;
                    }
                }
                // Меняем направление (по часовой стрелке)
                direction = (direction + 1) % 4;

            }
            // Увеличиваем длину шага каждые два поворота
            steps++;
        }


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(String.format("%3d", nums[i][j]));
                sb.append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

}
