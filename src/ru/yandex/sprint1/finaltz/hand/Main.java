package ru.yandex.sprint1.finaltz.hand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

// ID посылки: 95477575
// Посылка: https://contest.yandex.ru/contest/22450/submits/
// B. Ловкость рук
// https://contest.yandex.ru/contest/22450/problems/B/

public class Main {

    private static final int colCount = 4;
    private static final int rowCount = 4;
    private static final int personCount = 2;

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int k = personCount * Integer.parseInt(reader.readLine());

            int [] data = getIntData(reader);

            long count = IntStream.of(data)
                    .filter(value -> value > 0 && value <= k)
                    .count();

            System.out.println(count);
        }
    }

    private int[] getIntData(BufferedReader reader) throws IOException {
        int[] digitsCount = new int[10];

        for (int i = 0; i < rowCount; i++) {
            String row = reader.readLine();
            for (int j = 0; j < colCount; j++) {
                int value = charToInt(row.charAt(j));
                if (value > 0) {
                    digitsCount[value] += 1;
                }
            }
        }
        return digitsCount;
    }

    private int charToInt(char t) {
        return t >= '0' && t <= '9' ? t - '0' : -1;
    }

}
