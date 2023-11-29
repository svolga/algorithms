package ru.yandex.sprint3.flower;

import java.util.Arrays;

class MergeSort {

    public static int[] mergeSort(int[] array) {
        if (array.length == 1) {  // базовый случай рекурсии
            return array;
        }

        // запускаем сортировку рекурсивно на левой половине
        int[] left = mergeSort(Arrays.copyOfRange(array, 0, array.length / 2));

        // запускаем сортировку рекурсивно на правой половине
        int[] right = mergeSort(Arrays.copyOfRange(array, array.length / 2, array.length));

        // заводим массив для результата сортировки
        int[] result = new int[array.length];

        // сливаем результаты
        int l = 0, r = 0, k = 0;
        while (l < left.length && r < right.length) {
            // выбираем, из какого массива забрать минимальный элемент
            if (left[l] <= right[r]) {
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

    public static int[][] mergeSort2(int[][] array) {
        if (array.length == 1) {  // базовый случай рекурсии
            return array;
        }

        // запускаем сортировку рекурсивно на левой половине
        int[][] left = mergeSort2(Arrays.copyOfRange(array, 0, array.length / 2));

        // запускаем сортировку рекурсивно на правой половине
        int[][] right = mergeSort2(Arrays.copyOfRange(array, array.length / 2, array.length));

        // заводим массив для результата сортировки
        int[][] result = new int[array.length][2];

        // сливаем результаты
        int l = 0, r = 0, k = 0;
        while (l < left.length && r < right.length) {
            // выбираем, из какого массива забрать минимальный элемент
            if (left[l][0] <= right[r][0]) {
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

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {

        int[] array = {4, 6, 2, 67, 34, 56, 90, 23, 56, 50};
        print(array);

        int [][] array2 = {{7,8}, {7,8}, {2,3}, {6,10}};
        print(array2);
        int[][] result2 = MergeSort.mergeSort2(array2);
        print(result2);

/*
        int[] result = MergeSort.mergeSort(array);
        print(result);
*/
    }

    private void print(int[][] array) {
        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

}
