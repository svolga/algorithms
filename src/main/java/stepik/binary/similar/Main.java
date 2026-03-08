package stepik.binary.similar;

/*
Задача «Приближенный двоичный поиск»

Реализуйте алгоритм приближенного бинарного поиска.

Формат входных данных
В первой строке входных данных содержатся числа N и K
Во второй строке задаются N чисел первого массива, отсортированного по неубыванию,
а в третьей строке - K чисел второго массива. Каждое число в обоих массивах по модулю
не превосходит 2 * 10^9. Числа в каждой строке вводятся через пробел.

Формат выходных данных
Для каждого из K чисел выведите в отдельную строку число из первого массива,
наиболее близкое к данному. Если таких несколько, выведите меньшее из них.

Замечание
Алгоритм необходимо реализовать с асимптотической сложностью
O(KlogN).

Sample Input:
5 5
1 3 5 7 9
2 4 8 1 6
Sample Output:
1
3
7
1
5
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String l1 = br.readLine();
        String l2 = br.readLine();
        String l3 = br.readLine();

        String[] line1 = l1.split(" ");
        String[] line2 = l2.split(" ");
        String[] line3 = l3.split(" ");

        int N = Integer.parseInt(line1[0]);
        int K = Integer.parseInt(line1[1]);

        int[] searchArray = Arrays.stream(line2)
                .mapToInt(Integer::parseInt)
                .toArray();

        StringBuilder result = new StringBuilder();

        for (String str : line3) {
            int target = Integer.parseInt(str);

            int lbs = getLbs(searchArray, target);
            int rbs = getRbs(searchArray, target);

            int valLbs = searchArray[lbs];
            int valRbs = searchArray[rbs];

            if (valLbs - target < target - valRbs) {
                System.out.println(valLbs);
            } else {
                System.out.println(valRbs);
            }

        }

    }

    private static int getLbs(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left + 1 < right) {
            int mid = (right + left) / 2;
            if (arr[mid] < target) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }


    private static int getRbs(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left + 1 < right) {
            int mid = (right + left) / 2;
            if (arr[mid] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return left;
    }


}
