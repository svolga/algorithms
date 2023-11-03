package ru.yandex.sprint1.letter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// L. Лишняя буква
// https://contest.yandex.ru/contest/22449/problems/L/
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        char[] char1 = reader.readLine().toCharArray();
        char[] char2 = reader.readLine().toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);

        String letter = "";
        for (int i = 0; i < char1.length; i++) {
            if (char2[i] != char1[i]) {
                letter = Character.toString(char2[i]);
                break;
            }
        }

        if (letter.isEmpty()) {
            letter = Character.toString(char2[char2.length - 1]);
        }

        System.out.println(letter);
    }

}
