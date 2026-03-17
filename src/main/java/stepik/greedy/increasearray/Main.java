package stepik.greedy.increasearray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Задача «Сделать массив возрастающим»

Дан целочисленный массив. За одно действие разрешается выбрать любой элемент массива и увеличить его на
1
1. Какое минимальное количество таких операций необходимо сделать, чтобы массив стал строго возрастающим? Напомним, что массив называется строго возрастающим, если каждый следующий элемент в нём больше предыдущего.

Формат входных данных
В первой строке вводится натуральное значение
n≤5000 - количество элементов массива. В следующей строке вводятся элементы массива через пробел. Элементы массива целые положительные числа, не превышающие
10^4.

Формат выходных данных
Выведите одно число - минимальное количество операций, которое нужно сделать, чтобы массив стал строго возрастающим.

Замечание
Массив длины 1 считается возрастающим.

Комментарий по тестам
Тест №1:
Sample Input 1:
3
1 1 1
Подходящий массив
[1,2,3], для этого необходимо
3 раза применить операцию: один раз для второго элемента и два раза для третьего.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String line1 = br.readLine();
        int[] array = Arrays.stream(line1.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = increaseArray(array);

        System.out.println(result);
    }

    private static int increaseArray(int[] array) {

        int count = 0;

        int curr = 0;
        int prev = array[0];

        for (int i = 1; i < array.length; i++) {

            if (array[i] <= prev) {
                curr = prev + 1;
                count += curr - array[i];
            } else {
                curr = array[i];
            }
            prev = curr;
        }
        return count;
    }

}
