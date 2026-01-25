package java.yandex.algo5.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// F. Миша и математика
// https://contest.yandex.ru/contest/59539/problems/F/
public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int count = getInt(reader);
            int[] nums = getArray(reader, count);

/*
            int count = 3;
            int[] nums = {5, 7, 2};
*/

            String signs = getSigns(nums);
            System.out.println(signs);
        }

    }


    private String getSigns(int[] nums) {
        if (nums.length < 1) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        char[] operands = new char[nums.length - 1];

        int firstOdd = -1;
        int countOdd = nums[0] % 2;
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] + nums[i + 1]) % 2 == 0) {
                operands[i] = 'x';
            } else {
                operands[i] = '+';
                if (nums[i + 1] % 2 != 0) {
                    countOdd++;
                }
            }
            if (firstOdd == -1 && nums[i] % 2 != 0) {
                firstOdd = i;
            }
        }

        if (countOdd % 2 == 0) {
            operands[firstOdd] = operands[firstOdd] == '+' ? 'x' : '+';
        }

        for (int i = 0; i < nums.length - 1; i++) {
            sb.append(operands[i]);
        }

        return sb.toString();
    }

    private int getInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

    private int[] getArray(BufferedReader reader, int limit) throws IOException {
        return Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).limit(limit).toArray();
    }

}
