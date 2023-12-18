package ru.yandex.sprint4.preffixhash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// C. Префиксные хеши
// https://contest.yandex.ru/contest/23991/problems/C/

public class Solution {

    int a; // Основание полинома
    int m; // Модуль
    String str; // Входная строка
    List<Boundary> listBoundary = new ArrayList<>(); // list со start->end

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        getInput();
/*
        listBoundary.add(new Boundary(1, 1));
        listBoundary.add(new Boundary(1, 5));
        listBoundary.add(new Boundary(2, 3));
        listBoundary.add(new Boundary(3, 4));
        listBoundary.add(new Boundary(4, 4));
        listBoundary.add(new Boundary(1, 8));
        listBoundary.add(new Boundary(5, 8));

        a = 1000;
        m = 1_000_009;
        str = "abcdefgh";
*/

//        System.out.println("Префиксы хешей --> h");
        long[] pow = new long[str.length() + 1];
        long h[] = new long[str.length() + 1];
        pow[0] = 1;

        for (int i = 1; i < str.length() + 1; i++) {
            h[i] = (h[i - 1] * a + str.charAt(i - 1)) % m;
            pow[i] = pow[i - 1] * a % m;
        }

//        print(pow);
//        print(h);

        listBoundary.forEach(boundary -> {
            long hashSubString = getHashSubstring(a, h, pow, m, str.length(), boundary.getLeft(), boundary.getRight());
            System.out.println(hashSubString);
        });
    }

    long getHashSubstring(int a, long[] h, long[] pow, int mod, int n, int l, int r) {
        return (h[r] - h[l - 1] * pow[r - l + 1] % m + m) % m;
    }

    private void print(long[] array) {
        System.out.println(Arrays.toString(array));
    }

    private void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    private void getInput() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            a = Integer.parseInt(reader.readLine());
            m = Integer.parseInt(reader.readLine());
            str = reader.readLine();
            int lenStartEnd = Integer.parseInt(reader.readLine());
            for (int i = 0; i < lenStartEnd; i++) {
                StringTokenizer stz = new StringTokenizer(reader.readLine());
                listBoundary.add(new Boundary(Integer.parseInt(stz.nextToken()), Integer.parseInt(stz.nextToken())));
            }
        }
    }

}

class Boundary {
    private final int left;
    private final int right;

    public Boundary(int left, int right) {
        this.left = left;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public int getRight() {
        return right;
    }
}
