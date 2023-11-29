package ru.yandex.sprint3.mergesort3;

import java.util.Arrays;

// K. Сортировка слиянием
// https://contest.yandex.ru/contest/23638/problems/K/
public class Solution {

    public static int[] merge(int[] arr, int left, int mid, int right) {
        // Your code
        // “ヽ(´▽｀)ノ”
        int[] res = new int[arr.length];
        int l = left, r = mid, k = 0;

        while (l < mid && r < right) {
            if (arr[l] < arr[r]) {
                res[k] = arr[l];
                l++;
            } else {
                res[k] = arr[r];
                r++;
            }
            k++;
        }

        while (l < mid) {
            res[k] = arr[l];
            l++;
            k++;
        }

        while (r < right) {
            res[k] = arr[r];
            r++;
            k++;
        }

        return res;
    }

    public static void merge_sort(int[] arr, int left, int right) {
        // Your code
        // “ヽ(´▽｀)ノ”
        if (right - left <= 1) {
            return;
        }

        int mid = (left + right) / 2;

        int[] leftArray = Arrays.copyOfRange(arr, left, mid);
        int[] rightArray = Arrays.copyOfRange(arr, mid, right);

        merge_sort(leftArray, 0, leftArray.length);
        merge_sort(rightArray, 0, rightArray.length);

        System.arraycopy(leftArray, 0, arr, 0, leftArray.length);
        System.arraycopy(rightArray, 0, arr, leftArray.length, rightArray.length);

        int [] res = merge(arr, left, mid, right);
        for (int i = left; i<right; i++){
            arr[i] = res[i];
        }
    }


    public static void main(String[] args) {
/*
        int[] a = {1, 4, 9, 2, 10, 11};
        print(a);
        int[] b = merge(a, 0, 3, 6);
        print(b);
        int[] expected = {1, 2, 4, 9, 10, 11};
        assert Arrays.equals(b, expected);
        int[] c = {1, 4, 2, 10, 1, 2};
        print(c);
        merge_sort(c, 0, 6);
        int[] expected2 = {1, 1, 2, 2, 4, 10};
        print(expected2);
        assert Arrays.equals(c, expected2);
 */

// My test
        int[] a = {18, -19, 15, -8, 14, 6, -6, 8, 17};
        print(a);
        merge_sort(a, 0, 9);
        print(a);
/*

        int[] c = {1, 4, 2, 10, 1, 2};
        print(c);
        merge_sort(c, 0, 6);
        int[] expected2 = {1, 1, 2, 2, 4, 10};
        print(c);
        assert Arrays.equals(c, expected2);

*/
/*
        int[] d = {1, 4, 2, 10, 1, 2};
        print(d);
        merge_sort(d, 0, 6);
        print(d);
*/
    }

    private static void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

}
