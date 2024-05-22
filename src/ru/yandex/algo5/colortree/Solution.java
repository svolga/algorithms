package ru.yandex.algo5.colortree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// A. Покраска деревьев
// https://contest.yandex.ru/contest/59539/problems/A/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String[] arr1 = reader.readLine().strip().split(" ");
            int p = Integer.parseInt(arr1[0]);
            int v = Integer.parseInt(arr1[1]);

            String[] arr2 = reader.readLine().strip().split(" ");
            int q = Integer.parseInt(arr2[0]);
            int m = Integer.parseInt(arr2[1]);

            int start1 = p - v;
            int end1 = p + v;

            int start2 = q - m;
            int end2 = q + m;

            boolean isInterces = (start2 - end1) * (end2 - start1) <= 0; // Пересекаются

            int count = 0;
            if (isInterces) {
                count = Math.max(end1, end2) - Math.min(start1, start2) + 1;
            } else {
                count = end2 - start2 + 1 + end1 - start1 + 1;
            }

            System.out.println(count);
        }
 /*       int p = 0;
        int v = 2; //7;

        int q = 12;
        int m = 3; //5;
*/

    }

}

