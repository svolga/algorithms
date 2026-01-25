package java.yandex.sprint1.chaostemp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// D. Хаотичность погоды
// https://contest.yandex.ru/contest/22449/problems/D/

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private int[] getData() throws IOException {
        int[] list;
        int size;
        StringTokenizer stringTokenizer;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            size = Integer.valueOf(reader.readLine());
            stringTokenizer = new StringTokenizer(reader.readLine());
        }

        list = new int[size];
        int i = 0;
        while (i < size) {
            list[i] = Integer.valueOf(stringTokenizer.nextToken());
            i++;
        }

        return list;
    }

    private void run() throws IOException {
        int[] list = getData();

        int dayCount = 0;
        if (list.length >= 0) {
            for (int i = 0; i < list.length; i++) {
                if (i > 0 && list[i] <= list[i - 1]) {
                    continue;
                }
                if (i < list.length - 1 && list[i] <= list[i + 1]) {
                    continue;
                }
                ++dayCount;
            }
        }

        System.out.println(dayCount);
    }

}