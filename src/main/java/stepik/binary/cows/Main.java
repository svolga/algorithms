package stepik.binary.cows;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    /*

    Задача «Сложная жизнь коров»
    Сложность:  (оцени сложность задачи от 1[легко] до 5[очень сложно] в комментариях)

    На прямой расположены стойла, в которые необходимо расставить коров так, чтобы минимальное расстояние между коровами было как можно больше.

    Формат входных данных
    В первой строке вводятся числа
    N(2<N<10001) - количество стойл и
    K (1<K<N) - количество коров. Во второй строке задаются
    N натуральных чисел в порядке возрастания - координаты стойл (координаты не превосходят 10^9)

    Формат выходных данных
    Выведите одно число - наибольшее возможное допустимое расстояние.

    Комментарий по тестам
    Тест №1: Получить расстояние
    9 можно расставив 3 коровы по координатам
    2,11,20 для тестовых данных:

6 3
2 5 7 11 15 20


    Тест №2: Получить расстояние
    99 можно расставив
    4 коров по координатам
    1,100,1210,2015 для тестовых данных:

6 4
1 3 7 100 1210 2015

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = br.readLine().split(" ");

        int N = Integer.parseInt(line1[0]); // Кол-во стойл
        int K = Integer.parseInt(line1[1]); // Кол-во коров

        String[] line2 = br.readLine().split(" ");
        int[] nums = Arrays.stream(line2)
                .mapToInt(Integer::parseInt)
                .toArray();

        int rest = getLength(N, K, nums);
        System.out.println(rest);


    }

    private static int getLength(int N, int K, int[] nums) {
        int left = 0;
        int right = nums[nums.length - 1] + 1;

        while (left + 1 != right) {

            int mid = (left + right) / 2;
            if (getFun(mid, nums, N, K)) {
                left = mid;
            } else {
                right = mid;
            }

        }

        return left;
    }

    /*
    d - желаемое расстояние
    nums - координаты
    N - кол-во стойл
    K - кол-во коров
     */
    private static boolean getFun(int d, int[] nums, int N, int K) {
        int prev = nums[0];
        int count = 1;
        for (int i = 1; i < N; i++) {
            if (nums[i] - prev >= d) {
                count += 1;
                prev = nums[i];
            }
        }
        return count >= K;
    }

}
