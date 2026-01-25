package java.yandex.sprint1.binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// G. Работа из дома
// https://contest.yandex.ru/contest/22449/problems/G/
public class Main {

    public static void main(String[] args) throws IOException {
        new Main().run();
    }

    private void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int value = Integer.valueOf(reader.readLine());
        System.out.println(decimalToOther(value, 2));
    }

    private String decimalToOther(int decimalValue, int system) {
        StringBuilder doubleValue = new StringBuilder();

        if (decimalValue == 0)
            return "0";

        while (decimalValue != 0) {
            int rest = decimalValue % system;
            decimalValue /= system;
            doubleValue.append(rest);
        }
        return doubleValue.reverse().toString();
    }

}
