package ru.yandex.sprint3.sort.counting;

// Сортировка подсчетом

import java.util.Arrays;

class CountingSort {

    public static int[] countingSort(int[] array, int k) {
        int[] countedValues = new int[k];
        for (int value : array) {
            countedValues[value]++;
        }

        int index = 0;
        for (int value = 0; value < k; value++) {
            for (int amount = 0; amount < countedValues[value]; amount++) {
                array[index] = value;
                index++;
            }
        }
        return array;
    }
}

public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int[] arr = {5, 7, 1, 0, 1};
        print(arr);
        int[] res = CountingSort.countingSort(arr, 10);
        print(res);
    }

    private void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

}
