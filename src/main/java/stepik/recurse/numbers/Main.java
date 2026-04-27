package stepik.recurse.numbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://stepik.org/lesson/1073852/step/8?unit=1083924

Напишите рекурсивную функцию countDigits, которая вычисляет количество цифр в заданном целом числе. Функция countDigits должна принимать целое число n в качестве аргумента и возвращать количество цифр в числе n.

Входные данные
123

Выходные данные
3
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Math.abs(n);
        int count = countDigits(k);
        System.out.println(count);

    }

    private static int countDigits(int n) {
        int len = Integer.toString(n).length();
        if (len == 1) {
            return 1;
        } else {
            return 1 + countDigits(n / 10);
        }
    }
}
