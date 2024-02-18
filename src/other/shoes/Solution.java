package other.shoes;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);

    }

    private void run(String[] args) {
        int[] array = {2, 3, 4, 8, 10};
        int target = 11;
        int count = getPairs(array, target);
        System.out.println("Комбинаций --> " + count);
    }

    private int getPairs(int[] array, int target) {
        int count = 0;
        int left = 0;
        int right = left + 1;
        Arrays.sort(array);
        while (left < array.length - 1 && array[left] < target) {
            if (array[left] + array[right] <= target) {
                count++;
                System.out.println("left:" + left + "; right:" + right + "; --> " + array[left] + ";" + array[right]);
            }
            right++;
            if (right > array.length - 1) {
                left++;
                right = left + 1;
            }
        }
        return count;
    }


}
