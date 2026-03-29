package leetcode.twopointer.threesum;

/*
15. 3Sum
https://leetcode.com/problems/3sum/description/
 */

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
15. 3Sum
https://leetcode.com/problems/3sum/description/
 */
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                break;
            }

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                }

            }
        }
        return result;
    }

    private void testing(List<List<Integer>> actual, List<List<Integer>> expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(threeSum(new int[]{-1, 0, 1, 2, -1, -4}), List.of(List.of(-1, -1, 2), List.of(-1, 0, 1)));
        testing(threeSum(new int[]{0, 1, 1}), List.of());
        testing(threeSum(new int[]{0, 0, 0}), List.of(List.of(0, 0, 0)));
    }

}
