package stepik.recurse.power;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://stepik.org/lesson/1073852/step/9?unit=1083924

Напишите рекурсивную функцию calculatePower, которая вычисляет степень числа.
Функция calculatePower должна принимать два аргумента: число base и целое число exponent.
Она должна возвращать результат возведения числа base в степень exponent.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int base = Integer.parseInt(line[0]);
        int exponent = Integer.parseInt(line[1]);
        double result = power(base, exponent);

        System.out.printf("%.2f", result);
    }

    private static double power(int base, int exponent) {

        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        } else {
            if (exponent < 0) {
                return 1.0 / (int) power(base, -exponent);
            } else {
                return base * (int) power(base, exponent - 1);
            }
        }
    }
}
