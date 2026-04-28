package stepik.recurse.palindrom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Создайте рекурсивную функцию isPalindrome, которая проверяет, является ли строка палиндромом.
Формат входных данных: Строка s.
Формат выходных данных: True, если строка является палиндромом, иначе False.

Входные данные
radar

Выходные данные
True
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        boolean isPalindrom = isPalindrome(s, 0, s.length() - 1);
        System.out.println(isPalindrom ? "True" : "False");
    }

    private static boolean isPalindrome(String s, int left, int right) {

        if (right <= left) {
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        return isPalindrome(s, left + 1, right - 1);
    }

}
