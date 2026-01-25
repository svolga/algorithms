package java.yandex.sprint8.calcprefixfunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// L. Подсчёт префикс-функции
// https://contest.yandex.ru/contest/26131/problems/L/
public class Solution {

    public static void main(String[] args) throws IOException {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String str = reader.readLine();
//            String str = "aaaaa";
            int [] prefix = prefixFunction(str);

            StringBuilder sb = new StringBuilder();
            for (int i : prefix) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
        }
    }

    public static int[] prefixFunction(String s) {
        // Функция возвращает массив длины |s|
        int n = s.length();
        int[] pi = new int[n];
        pi[0] = 0;
        for (int i = 1; i < n; i++) {
            int k = pi[i-1];
            while (k > 0 && s.charAt(k) != s.charAt(i)) {
                k = pi[k-1];
            }
            if (s.charAt(k) == s.charAt(i)) {
                k++;
            }
            pi[i] = k;
        }
        return pi;
    }
}