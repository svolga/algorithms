package java.yandex.sprint3.twobike;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// L. Два велосипеда
// https://contest.yandex.ru/contest/23638/problems/L/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int size = Integer.parseInt(reader.readLine());
            String values = reader.readLine();
            int maxValue = Integer.parseInt(reader.readLine());
            int maxValue2 = maxValue * 2;
/*
            int size = 7;
            String values = "1 1 4 4 4 4 8";
            int maxValue = 4;
            int maxValue2 = maxValue * 2;
*/

            StringTokenizer stz = new StringTokenizer(values);
            int[] array = new int[size];
            for (int i = 0; i < size; i++) {
                array[i] = Integer.parseInt(stz.nextToken());
            }

            int index = getGoodDay(array, 0, array.length - 1, maxValue);
            int day = index >= 0 ? index : -1;

            int index2 = -1;
            if (index >= 0) {
                index2 = getGoodDay(array, index, array.length - 1, maxValue2);
            }

            int day2 = index2 >= 0 ? index2 : -1;
            System.out.println(day + " " + day2);

        }
    }

    private int getGoodDay(int[] array, int left, int right, int maxValue) {

        if (right < left ) {
            return -1;
        }

        int mid = (right + left) / 2;

        if (array[mid] >= maxValue && (mid == 0 || maxValue > array[mid - 1])) {
            return mid + 1;
        }
        if (maxValue <= array[mid]) {
            return getGoodDay(array, left, mid, maxValue);
        } else {
            return getGoodDay(array, mid + 1, right, maxValue);
        }
    }

    private void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

}
