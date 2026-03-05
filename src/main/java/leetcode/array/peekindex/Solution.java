package leetcode.array.peekindex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 852. Peak Index in a Mountain Array
// https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
public class Solution {

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int index = 0;
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[mid + 1]) {
                right = mid;
                index = mid;
            }
            else {
                left = mid + 1;
                index = left;
            }
        }

        return index;
    }

    private static void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        System.out.println("Peak Index");
        testing(peakIndexInMountainArray(new int[]{0,1,0}), 1);
        testing(peakIndexInMountainArray(new int[]{0,2,1,0}), 1);
        testing(peakIndexInMountainArray(new int[]{0,10,5,2}), 1);
    }


}
