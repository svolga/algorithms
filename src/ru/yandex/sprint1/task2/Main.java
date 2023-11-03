package ru.yandex.sprint1.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://contest.yandex.ru/contest/22449/problems/B/
// B. Чётные и нечётные числа
public class Main {

    private static boolean isEven(int a) {
        return a % 2 == 0;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int a = Integer.parseInt(stringTokenizer.nextToken());
        int b = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());

        boolean isA = isEven(a);
        boolean isB = isEven(b);
        boolean isC = isEven(c);

        System.out.println(isA  == isB && isB == isC ? "WIN" : "FAIL");
    }
}
