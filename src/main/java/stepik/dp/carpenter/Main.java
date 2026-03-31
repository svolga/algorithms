package stepik.dp.carpenter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Задача «Мамин плотник»
https://stepik.org/lesson/1110493/step/4?unit=1121860

В дощечке в один ряд вбиты гвоздики. Любые два гвоздика можно соединить ниточкой. Требуется соединить некоторые пары гвоздиков ниточками так, чтобы к каждому гвоздику была привязана хотя бы одна ниточка, а суммарная длина всех ниточек была минимальна.

Формат входных данных
В первой строке входных данных записано число
N - количество гвоздиков (2≤N≤100). В следующей строке заданы
N чисел - координаты всех гвоздиков (неотрицательные различные целые числа, не превосходящие
10 000). Координаты вводятся через пробел, значения не упорядочены.

Формат выходных данных
Выведите единственное число - минимальную суммарную длину всех ниточек.

Комментарий по тестам
Тест №1: Упорядочим координаты всех гвоздиков, получим:
0 2 4 10 12. Соединим ниточками первый и второй, второй и третий, четвёртый и пятый гвоздики. Итоговая длина равна
(2−0)+(4−2)+(12−10)=6.

Sample Input:
5
4 10 0 12 2

Sample Output:
6

 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] lines = br.readLine().split(" ");
        int[] nums = Arrays.stream(lines).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(nums);

        int[] dp = new int[N + 1];
        Arrays.fill(dp, 0);

        for (int i = 1; i < nums.length; i++) {
            if (i > 2) {
                dp[i] = Math.min(dp[i - 1], dp[i - 2]) + nums[i] - nums[i - 1];
            } else {
                dp[i] = dp[i - 1] + nums[i] - nums[i - 1];
            }
        }

        System.out.println(dp[N - 1]);
    }
}
