package leetcode.twopointer.twosum;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
167. Two Sum II - Input Array Is Sorted
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
*/
public class Solution {

    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] < target) {
                left++;
            }
            else if (numbers[left] + numbers[right] > target) {
                right--;
            }
            else{
                break;
            }
        }

        return new int[]{left + 1, right + 1};
    }

    private void testing(int[] actual, int[] expected) {
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{1, 2});
        testing(twoSum(new int[]{2,3,4}, 6), new int[]{1, 3});
        testing(twoSum(new int[]{-1,0}, -1), new int[]{1, 2});
    }
}
