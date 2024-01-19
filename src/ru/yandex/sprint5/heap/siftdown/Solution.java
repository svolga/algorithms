package ru.yandex.sprint5.heap.siftdown;

import java.util.Arrays;

// L. Просеивание вниз
// https://contest.yandex.ru/contest/24809/problems/L/
public class Solution {

    public static void main(String[] args) {
        test();
    }

    public static int siftDown(int[] heap, int idx) {
        // Your code
        // “ヽ(´▽｀)ノ”
        int left;
        int right;

        while (idx < heap.length) {
            left = 2 * idx;
            right = 2 * idx + 1;

            // Нет дочерних узлов
            if (heap.length - 1 < left) {
                break;
            }

            int indexLargest = left;
            if (right < heap.length && heap[left] < heap[right]) {
                indexLargest = right;
            }

            if (heap[idx] < heap[indexLargest]) {
                int temp = heap[idx];
                heap[idx] = heap[indexLargest];
                heap[indexLargest] = temp;
                idx = indexLargest;
            }
            else{
                break;
            }
        }

        return idx;
    }

    private static void test() {
        int[] sample = {-1, 12, 1, 8, 3, 4, 7};
//        int[] sample = {-1, 12, 1, 8, 3, 4, 7, 9, -1, -1, 6};

        System.out.println(Arrays.toString(sample));
        int result = siftDown(sample, 2);
//        int result = siftDown(sample, 2);
        System.out.println(Arrays.toString(sample));
        System.out.println("result = " + result);
        assert result == 5;
    }

}