package ru.yandex.sprint3.perimeter;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// F. Периметр треугольника
// https://contest.yandex.ru/contest/23638/problems/F/
class MergeSort {
    public static int[] mergeSort(int[] array, Comparator<Integer> comparator) {
        if (array.length == 1) {  // базовый случай рекурсии
            return array;
        }

        // запускаем сортировку рекурсивно на левой половине
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, array.length / 2), comparator);

        // запускаем сортировку рекурсивно на правой половине
        int[] right = mergeSort(Arrays.copyOfRange(array, array.length / 2, array.length), comparator);

        // заводим массив для результата сортировки
        int[] result = new int[array.length];

        // сливаем результаты
        int l = 0, r = 0, k = 0;
        while (l < left.length && r < right.length) {
            // выбираем, из какого массива забрать минимальный элемент
            if (comparator.compare(left[l], right[r]) < 0) {
                result[k] = left[l];
                l++;
            } else {
                result[k] = right[r];
                r++;
            }
            k++;
        }

        // Если один массив закончился раньше, чем второй, то
        // переносим оставшиеся элементы второго массива в результирующий
        while (l < left.length) {
            result[k] = left[l];   // перенеси оставшиеся элементы left в result
            l++;
            k++;
        }
        while (r < right.length) {
            result[k] = right[r];  // перенеси оставшиеся элементы right в result
            r++;
            k++;
        }

        return result;
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        Comparator<Integer> comparator = (o1, o2) -> o2 - o1;

        int[] array = readInput(); //{6, 3, 3, 2};
        int[] res = MergeSort.mergeSort(array, comparator);

        int i = 0;
        int p = 0;
        while (i < res.length) {
            if (res[i] < res[i + 1] + res[i + 2]) {
                p = res[i] + res[i + 1] + res[i + 2];
                break;
            }
            i++;
        }

        System.out.println(p);
    }

    private void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    private int[] readInput() throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            StringTokenizer tz = new StringTokenizer(reader.readLine());

            int[] array = new int[count];
            int i = 0;
            while (i<count){
                array[i++] = Integer.parseInt(tz.nextToken());
            }

            return array;
        }
    }

}
