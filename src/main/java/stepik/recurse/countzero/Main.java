package stepik.recurse.countzero;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://stepik.org/lesson/1073852/step/12?unit=1083924

Создайте рекурсивную функцию countZeros, которая принимает целое число и возвращает количество нулей в его десятичной записи.

Формат входных данных: Целое число n>1

Входные данные
1050

Выходные данные
2
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int value = countZeros(n);
        System.out.println(value);
    }

    private static int countZeros(int n) {
        if (n == 0) {
            return 0;
        }

        int mod = n % 10;
        if (mod == 0) {
            return 1 + countZeros(n / 10);
        } else {
            return countZeros(n / 10);
        }

    }

}
