package ru.yandex.sprint1.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// C. Соседи
// https://contest.yandex.ru/contest/22449/problems/C/?success=95081390#2989/2020_04_21/PMefBHIZqd
public class Main {

    public static void main(String[] args) throws IOException {

/*
        //
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(7);
        list.add(3);

        Collections.sort(list);
        System.out.println(list);

        StringBuilder sb = new StringBuilder();
        list.forEach(value -> sb.append(value + " "));

        System.out.println(sb);
*/
        //

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringRowsTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringRowsTokenizer.nextToken()); // rows

        StringTokenizer stringColsTokenizer = new StringTokenizer(bufferedReader.readLine());
        int m = Integer.parseInt(stringColsTokenizer.nextToken()); // cols

        int[][] nums = new int[n][m];

        int i = 0;
        while (i < n) {
            StringTokenizer stringArrTokenizer = new StringTokenizer(bufferedReader.readLine());
            int j = 0;
            while (j < m) {
                int value = Integer.parseInt(stringArrTokenizer.nextToken()); // rows
                nums[i][j] = value;
                j++;
            }
            i++;
        }

        StringTokenizer stringPosXTokenizer = new StringTokenizer(bufferedReader.readLine());
        int posX = Integer.parseInt(stringPosXTokenizer.nextToken());

        StringTokenizer stringPosYTokenizer = new StringTokenizer(bufferedReader.readLine());
        int posY = Integer.parseInt(stringPosYTokenizer.nextToken());

        List<Integer> result = new ArrayList<>();
        if (posX + 1 < n) {
            result.add(nums[posX + 1][posY]);
        }
        if (posY - 1 >= 0) {
            result.add(nums[posX][posY - 1]);
        }
        if (posY + 1 < m) {
            result.add(nums[posX][posY + 1]);
        }
        if (posX - 1 >= 0) {
            result.add(nums[posX-1][posY]);
        }

        Collections.sort(result);

        StringBuilder sb = new StringBuilder();
        result.forEach(value -> sb.append(value + " "));

        System.out.println(sb);
    }

}
