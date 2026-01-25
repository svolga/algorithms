package java.yandex.sprint3.finaltz.broken;

import java.util.Arrays;

// Номер посылки: 101308847
// Посылка: https://contest.yandex.ru/contest/23815/run-report/101308847/
// A. Поиск в сломанном массиве
// https://contest.yandex.ru/contest/23815/problems/
/*
-- ПРИНЦИП РАБОТЫ --
Массив делится на две половины, в каждой из которых смещаются указатели и вызывается бинарный поиск

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
В качестве алгоритма используется бинарный поиск, сложность которого составляет O(log n)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Кроме константных переменных дополнительная память не выделяется, поэтому пространственная сложность O(1)
 */
public class Solution {

    public static int brokenSearch(int[] arr, int k) {

        int left = 0;
        int right = arr.length - 1;

        if (left > right) {
            return -1;
        }

        while (left <= right) {

            int mid = (left + right) / 2;
            if (arr[mid] == k) {
                return mid;
            }

            // Данные отсортированы
            if (arr[left] <= arr[mid]) {
                if (arr[left] <= k && k <= arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (arr[mid] <= arr[right]) {
                    if (arr[mid] <= k && k <= arr[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }

        return -1;
    }

    private static void test() {
        int[] arr = {19, 21, 100, 101, 1, 4, 5, 7, 12};
        int res = brokenSearch(arr, -101);
        System.out.println(res);
    }

    private static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        test();
    }

}