package stepik.greedy.jump;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://stepik.org/lesson/1236735/step/7?unit=1250466
Задача «Прыжки»

Вам дан массив, каждый элемент которого обозначает максимальную длину прыжка из этой ячейки
в следующие ячейки (предполагается, что прыгать можно слева направо). Длина прыжка является
целым числом и не превышает максимальную длину прыжка, указанную в ячейке.
Выпрыгивать за пределы массива запрещено.

Определите минимальное количество прыжков для достижения последней ячейки массива,
если прыжки начинаются с самой левой ячейки массива. Тесты сгенерированы так,
что последняя ячейка всегда достижима.

Формат входных данных
Первая строка содержит одно целое число n (1 ≤ n ≤ 10^4 ) - количество элементов в массиве.
Вторая строка содержит n целых чисел a  - элементы массива, a  -  обозначает максимальную
длину прыжка из ячейки с индексом i.

Формат выходных данных
Выведите одно целое число - минимальное количество прыжков для достижения последней ячейки
массива, то есть ячейки с индексом n−1 (если индексирование начинается с нуля).

Комментарий по тестам
Тест №1: достаточно совершить два прыжка, укажем индексы соответствующих ячеек:
0 → 1 → 4.
Тест №2: достаточно совершить три прыжка, укажем индексы соответствующих ячеек:
0 → 1 → 2 → 6.

Sample Input 1:
5
2 3 1 1 4
Sample Output 1:
2

Sample Input 2:
7
1 2 5 4 3 1 2
Sample Output 2:
3
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");

        int[] nums = Arrays.stream(line)
                .mapToInt(Integer::parseInt)
                .toArray();

        int step = 0;
        int left = 0;
        int right = 0;
        while (right < nums.length - 1) {

            int maxJump = 0;
            for (int i = left; i < right + 1; i++) {
                maxJump = Math.max(maxJump, i + nums[i]);
            }
            left = right + 1;
            right = maxJump;
            step++;
        }
        System.out.println(step);

    }

}
