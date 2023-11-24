package ru.yandex.sprint3.sort.bubble;

import java.util.Arrays;

// Пузырьковая сортировка
// Сложность O(n^2)
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int[] array = new int[]{2, 1, 3, 1, 99, 15, 56, 98, 5, 99, 87};
        System.out.println(Arrays.toString(array));
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private void bubbleSort(int[] array) {

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                    isSorted = false;
                }
            }
        }



    }

}

