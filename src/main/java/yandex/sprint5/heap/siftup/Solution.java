package java.yandex.sprint5.heap.siftup;

// M. Просеивание вверх
// https://contest.yandex.ru/contest/24809/problems/M/

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        test();
    }

    public static int siftUp(int[] heap, int idx) {
        // Your code
        // “ヽ(´▽｀)ノ”
        while (idx > 1) {
            int parentIndex = idx / 2;

            if (heap[parentIndex] < heap[idx]) {
                int temp = heap[parentIndex];
                heap[parentIndex] = heap[idx];
                heap[idx] = temp;
                idx = parentIndex;
            } else {
                break;
            }
        }
        return idx;
    }

    private static void test() {
        int[] sample = {-1, 12, 6, 8, 3, 15, 7};

        int result = siftUp(sample, 5);
        System.out.println("result = " + result);
        System.out.println(Arrays.toString(sample));
        assert result == 1;
    }

/*
    // Просеивание вверх
    public static void siftUp(List<Integer> heap, int index) {
        if (index == 1) {
            return;
        }

        int parentIndex = index / 2;
        if (heap.get(parentIndex - 1) < heap.get(index - 1)) {
            int temp = heap.get(parentIndex - 1);
            heap.set(parentIndex - 1, heap.get(index - 1));
            heap.set(index - 1, temp);
            siftUp(heap, parentIndex);
        }
    }

    public static void heapAdd(List<Integer> heap, int key) {
        int index = heap.size() + 1;
        heap.add(key);
        siftUp(heap, index);
    }
 */

}
