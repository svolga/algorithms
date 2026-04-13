package leetcode.binarysearch.firstlast;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
34. Find First and Last Position of Element in Sorted Array
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) return new int[]{-1, -1};

        int firstTrueIndex = findFirstTrue(nums, target, false);

        if (firstTrueIndex == -1 || nums[firstTrueIndex] != target){
            return new int[] {-1, -1};
        }

        int afterLastIndex = findFirstTrue(nums, target, true);
        int lastTrueIndex;
        if (afterLastIndex == -1) {
            lastTrueIndex = nums.length - 1;
        } else {
            lastTrueIndex = afterLastIndex - 1;
        }

        return new int[]{firstTrueIndex, lastTrueIndex};

    }

    private int findFirstTrue(int[] nums, int target, boolean isGreater) {

        int firstTrueIndex = -1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            boolean feasible;
            int mid = (right + left) / 2;

            if (isGreater) {
                feasible = nums[mid] > target;
            }
            else{
                feasible = nums[mid] >= target;
            }

            if (feasible) {
                firstTrueIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return firstTrueIndex;
    }


    private void testing(int[] actual, int[] expected) {
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8), new int[]{3, 4});
        testing(searchRange(new int[]{5,7,7,8,8,10}, 6), new int[]{-1, -1});
        testing(searchRange(new int[]{}, 0), new int[]{-1, -1});
        testing(searchRange(new int[]{2, 2}, 3), new int[]{-1, -1});
        testing(searchRange(new int[]{1,2,3}, 2), new int[]{1, 1});
        testing(searchRange(new int[]{1,2,3}, 1), new int[]{0, 0});
        testing(searchRange(new int[]{1, 2, 2, 3, 3, 3, 4, 5, 5, 5, 5, 6, 7}, 3), new int[]{3, 5});
    }
}
