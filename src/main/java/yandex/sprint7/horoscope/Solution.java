package java.yandex.sprint7.horoscope;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// K. Гороскопы
// https://contest.yandex.ru/contest/25596/problems/K/
// Отличная лекция о НОП и НВП: https://www.youtube.com/watch?v=1KSaJSZpkLM
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(reader.readLine());
            int[] nums1 = new int[n];
            StringTokenizer stz1 = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                nums1[i] = Integer.parseInt(stz1.nextToken());
            }

            int m = Integer.parseInt(reader.readLine());
            int[] nums2 = new int[m];
            StringTokenizer stz2 = new StringTokenizer(reader.readLine());

            for (int j = 0; j < m; j++) {
                nums2[j] = Integer.parseInt(stz2.nextToken());
            }


/*
            int[] nums1 = {1, 2, 1, 9, 1, 2, 1, 9};
            int[] nums2 = {9, 9, 1, 9, 9};
*/
/*
            int[] nums1 = {4, 9, 2, 4, 6};
            int[] nums2 = {9, 4, 0, 0, 2, 8, 4};
*/
/*

            int[] nums1 = {-4, -9, -2, -4, -6, 5, 7};
            int[] nums2 = {-9, -4, -0, -0, -2, -8, -4, 5, 7, 9};
*/


            longestCommonSubsequence(nums1, nums2);
        }
    }

    public int longestCommonSubsequence(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }


        // Идем из нижнего правого угла к т. 0,0 и восстанавливаем НОП
        int i = n;
        int j = m;

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        while (i > 0 && j > 0) {
            if (nums1[i - 1] != nums2[j - 1]) {
                if (dp[i][j - 1] > dp[i - 1][j]) {
                    j--;
                } else {
                    i--;
                }
            } else {
                list1.add(i);
                list2.add(j);
                i--;
                j--;
            }
        }

        Collections.reverse(list1);
        Collections.reverse(list2);

        StringBuilder path1 = new StringBuilder();
        StringBuilder path2 = new StringBuilder();

        for (Integer value : list1) {
            path1.append(value).append(" ");
        }


        for (Integer value : list2) {
            path2.append(value).append(" ");
        }

        System.out.println(dp[n][m]);
        System.out.println(path1);
        System.out.println(path2);

        return dp[n][m];
    }

    private void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array[i]));
        }
    }

    private void test() {
/*
           int[] nums1 = {4, 9, 2, 4, 6};
           int[] nums2 = {9, 4, 0, 0, 2, 8, 4};
*/

/*
            int[] nums1 = {1, 2, 1, 9, 1, 2, 1, 9};
            int[] nums2 = {9, 9, 1, 9, 9};*/
/*
            int[] nums1 = {1, 1, 1, 1};
            int[] nums2 = {2, 2};
*/
//        longestCommonSubsequence(nums1, nums2);
    }
}
