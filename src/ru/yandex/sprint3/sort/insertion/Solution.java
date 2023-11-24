package ru.yandex.sprint3.sort.insertion;

import java.util.Arrays;

// Сортировка вставками - Сложность O(n^2)
// Объём памяти необходим для работы этого алгоритма, помимо места под хранение массива O(1)
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int[] array = new int[]{2, 1, 3, 1, 99, 15, 56, 98, 5, 99, 87};
        System.out.println(Arrays.toString(array));
        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    private void insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i;
            while (j > 0 && current < array[j - 1]) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = current;
        }
    }

}
