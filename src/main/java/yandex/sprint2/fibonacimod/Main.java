package java.yandex.sprint2.fibonacimod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// L. Фибоначчи по модулю
// https://contest.yandex.ru/contest/22779/problems/L/

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(calculate(n, k));
        }
    }

    private int pow(int value, int powValue) {
        int result = 1;
        for (int i = 1; i <= powValue; i++) {
            result = result * value;
        }
        return result;
    }

    private int calculate(int number, int powerValue) {
        int power = pow(10, powerValue);
        int current = 0;
        int prevprev = 0;
        int prev = 1;

        for (int i = 0; i <= number + 1; i++) {

            if (i == 0 || i == 1) {
                current = i;
            } else {
                current = prevprev + prev;
                current = current % power;
            }
            prevprev = prev;
            prev = current;
        }
        return current;
    }

}