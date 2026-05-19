package stepik.array.step;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://stepik.org/lesson/1221926/step/7?unit=1235337

В прямоугольной таблице N×M в начале игрок находится в левой верхней клетке.
За один ход ему разрешается перемещаться в соседнюю клетку либо вправо,
либо вниз (влево и вверх перемещаться запрещено). Посчитайте, сколько есть способов у игрока
попасть в правую нижнюю клетку.


Входные данные
1 10

Выходные данные
1
*/
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]);
        int M = Integer.parseInt(line[1]);

        int[][] nums = new int[N][M];
        for (int i = 0; i < M; i++) {
            nums[0][i] = 1;
        }

        for (int i = 0; i < N; i++) {
            nums[i][0] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                nums[i][j] = nums[i][j - 1] + nums[i-1][j];
            }
        }

        System.out.println(nums[N-1][M-1]);

    }

}
