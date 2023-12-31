package ru.yandex.sprint3.sort.sortbykey;

import java.util.Arrays;
import java.util.function.IntUnaryOperator;

public class Solution {

    int[] digit_lengths = {4, 4, 3, 3, 6, 4, 5, 4, 6, 6}; // длины слов «ноль», «один»,

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int[] cards = {3, 7, 9, 2, 3};
        print(cards);
        insertion_sort_by_key(cards, this::card_strength);
        print(cards);

    }

    private void print(int[] array){
        System.out.println(Arrays.toString(array));
    }

    int card_strength(int card) { // ключ сравнения
        return digit_lengths[card];
    }

    // воспользуемся уже знакомой сортировкой вставками
    void insertion_sort_by_key(int[] array, IntUnaryOperator key) {
        for (int i = 1; i < array.length; i++) {
            int item_to_insert = array[i];
            int j = i;
            // заменим сравнение item_to_insert < array[j-1] на сравнение ключей
            while (j > 0 && key.applyAsInt(item_to_insert) < key.applyAsInt(array[j - 1])) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = item_to_insert;
        }
    }

}
