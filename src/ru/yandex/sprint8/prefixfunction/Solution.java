package ru.yandex.sprint8.prefixfunction;

// Вычисление префикс - функции
// https://practicum.yandex.ru/learn/algorithms/courses/7f101a83-9539-4599-b6e8-8645c3f31fad/sprints/181015/topics/c83dc564-7573-4f64-8d1f-032c4206fac1/lessons/8d1d0127-7d88-424e-9d73-802a8c018a73/
public class Solution {

    public static void main(String[] args) {

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
