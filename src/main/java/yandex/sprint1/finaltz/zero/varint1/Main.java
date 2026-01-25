package java.yandex.sprint1.finaltz.zero.varint1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://contest.yandex.ru/contest/22450/problems/A/
// A. Ближайший ноль
/*
//        int[] list = {8, 4, 3, 8, 0, 7};
//        int[] list = {0, 1, 4, 9, 0};
//        int[] list = {0, 7, 9, 4, 8, 20};
 */
public class Main {

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringRowsTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringTokenizer stringArrTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringRowsTokenizer.nextToken());
        int[] list = new int[n];
        int j = 0;
        while (j < n) {
            list[j++] = Integer.parseInt(stringArrTokenizer.nextToken());
        }

        int[] result = new int[list.length];
        for (int i = 0; i < list.length; i++) {
            if (list[i] > 0) {

                int leftIndex = findClosestIndexLeft(0, i, list);
                int rightIndex = leftIndex == 0 ? leftIndex : findClosestIndexRight(0, i, list, leftIndex);

                if (leftIndex < 0) {
                    result[i] = rightIndex;
                } else if (rightIndex < 0) {
                    result[i] = leftIndex;
                } else if (rightIndex <= leftIndex) {
                    result[i] = rightIndex;
                } else {
                    result[i] = leftIndex;
                }
            }
        }

        print(result);
    }

    private void print(int[] values) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            sb.append(values[i] + " ");
        }
        System.out.println(sb);
    }

    private int findClosestIndexLeft(int search, int start, final int[] list) {
        for (int j = start; j >= 0; j--) {
            if (list[j] == search) {
                return start - j;
            }
        }
        return -1;
    }

    private int findClosestIndexRight(int search, int start, final int[] list, int leftIndex) {
        for (int j = start; j < list.length; j++) {
            if (leftIndex >= 0 && j - start > leftIndex) {
                return leftIndex;
            }
            if (list[j] == search) {
                return j - start;
            }
        }
        return -1;
    }

}