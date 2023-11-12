package ru.yandex.sprint2.factorial;

// Факториал через рекурсию и цикл
public class Main {

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static int factorial2(int n) {
        int result = 1;
        while (n > 1) {
            result *= n;
            n--;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(3));
        System.out.println(factorial2(3));
    }

}
