package java.yandex.sprint3.sort.bubbleinput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// J. Пузырёк
// https://contest.yandex.ru/contest/23638/problems/J/
// Пузырьковая сортировка
// Сложность O(n^2)

public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    int[] readInput(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int i = 0;
            int count = Integer.parseInt(reader.readLine());

            int[] array = new int[count];
            String item = reader.readLine();

            StringTokenizer stringTokenizer = new StringTokenizer(item);
            while (stringTokenizer.hasMoreTokens() && i < count) {
                array[i] = Integer.parseInt(stringTokenizer.nextToken());
                i++;
            }
            return array;
        }
    }

    private void run(String[] args) {
        try {
            int[] array = readInput(args);
            bubbleSort(array);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    private void print(final int[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int item : array) {
            stringBuilder.append(item).append(" ");
        }
        System.out.println(stringBuilder);
    }

    private void bubbleSort(int[] array) {
        boolean isSorted = false;

        int j = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                    isSorted = false;
                }
            }

            if (j == 0 || !isSorted) {
                print(array);
            }
            j++;

        }
    }

}


