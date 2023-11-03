package ru.yandex.sprint1.finaltz.hand.zero.variant2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// ID посылки: 95386700
// Посылка: https://contest.yandex.ru/contest/22450/submits/
// https://contest.yandex.ru/contest/22450/problems/A/
// A. Ближайший ноль

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    public void run() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String strlength = bufferedReader.readLine();
        StringTokenizer stringArrTokenizer = new StringTokenizer(bufferedReader.readLine());

        int length = Integer.parseInt(strlength);
        int[] list = new int[length];

        int j = 0;
        while (j < length) {
            list[j++] = Integer.parseInt(stringArrTokenizer.nextToken());
        }

        for (int i = 0; i < list.length; i++) {
            if (list[i] != 0) {
                list[i] = list.length;
            }
        }

        for (int i = 1; i < list.length; i++) {
            list[i] = list[i] == 0 ? 0 : list[i - 1] + 1;
        }

        for (int i = list.length - 2; i >= 0; i--) {
            list[i] = list[i] == 0 ? 0 : Math.min(list[i + 1] + 1, list[i]);
        }

        print(list);
    }

    private void print(int[] values) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            sb.append(values[i] + " ");
        }
        System.out.println(sb);
    }

}
