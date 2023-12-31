package ru.yandex.sprint3.sort.digitallength;

import java.util.Arrays;

public class Main {


    static int[] digit_lengths = {4, 4, 3, 3, 6, 4, 5, 4, 6, 6}; // длины слов «ноль», «один»,...

    static int[] key_for_card(int card) {
        return new int[] {-digit_lengths[card], card};
    }

    public static void main(String[] args) {
        int[] cards = {2, 3, 7};
/*

        Arrays.sort(cards, (a, b) -> {
            int[] keyA = key_for_card(a);
            int[] keyB = key_for_card(b);
            return keyA[0] == keyB[0] ? keyA[1] - keyB[1] : keyA[0] - keyB[0];
        });
*/
        System.out.println(Arrays.toString(cards));
    }

}
