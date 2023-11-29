package ru.yandex.sprint3.sort.s1;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    private void run(String[] args) {
        int[] array = new int[10_000_000];
        for (int i=0; i < array.length-1; i++){
            array[i] = ThreadLocalRandom.current().nextInt(2000, 5000);
        }

        print(array);
        bubbleSort(array, array.length - 1);
        print(array);
    }


    private void bubbleSort(int[] array, int n) {
        if (array.length == 0 || n == 0)
            return;

        for (int i = 1; i < n; i++) {
            if (array[i - 1] > array[i]) {
                int temp = array[i - 1];
                array[i - 1] = array[i];
                array[i] = temp;
            }
        }

        bubbleSort(array, n - 1);
    }


}
