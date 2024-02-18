package ru.yandex.sprint4.longestcommonsubarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Vector;

// I. Общий подмассив
// https://contest.yandex.ru/contest/23991/problems/I/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

       /* Integer arr1[] = {1, 2, 3, 2, 1};
        Integer arr2[] = {3, 2, 1, 5, 6};

        int n = arr1.length;
        int m = arr2.length;

        Vector<Integer> A = new Vector<>(Arrays.asList(arr1));
        Vector<Integer> B = new Vector<>(Arrays.asList(arr2));

        int maxLength = LCS(0, 0, A, B, 0);

        System.out.print(maxLength);*/


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            Integer[] ls1 = new Integer[n];
            StringTokenizer stz = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                ls1[i] = Integer.parseInt(stz.nextToken());
            }

            int m = Integer.parseInt(reader.readLine());
            Integer[] ls2 = new Integer[m];
            stz = new StringTokenizer(reader.readLine());
            for (int i = 0; i < m; i++) {
                ls2[i] = Integer.parseInt(stz.nextToken());
            }

            Vector<Integer> A = new Vector<>(Arrays.asList(ls1));
            Vector<Integer> B = new Vector<>(Arrays.asList(ls2));

            int maxLength = LCS(0, 0, A, B, 0);

            System.out.print(maxLength);
        }

    }

    int LCS(int i, int j, Vector<Integer> A,
            Vector<Integer> B, int count) {
        // Base case: If either of the indices reaches the end of the array, return the count
        if (i == A.size() || j == B.size())
            return count;

        // If the current elements are equal, recursively check the next elements
        if (A.get(i).equals(B.get(j)))
            count = LCS(i + 1, j + 1, A, B, count + 1);

        // Recursively check for the longest common subarray by considering two possibilities:
        // 1. Exclude the current element from array A and continue with array B
        // 2. Exclude the current element from array B and continue with array A
        count = Math.max(count, Math.max(LCS(i + 1, j, A, B, 0),
                LCS(i, j + 1, A, B, 0)));

        return count;
    }


/*    int getMaxLength(int A[], int B[], int n, int m) {
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= m; j++)
                dp[i][j] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (A[i] == B[j])
                    dp[i][j] = dp[i + 1][j + 1] + 1;
            }
        }
        int maxm = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxm = Math.max(maxm, dp[i][j]);
            }
        }

        return maxm;
    }*/


}
