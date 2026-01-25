package java.yandex.algo5.format;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// C. Форматирование файла
// https://contest.yandex.ru/contest/59539/problems/C/
public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
/*
            int count = getInt(reader);
            int[] nums = new int[count];
            for (int i = 0; i < count; i++) {
                nums[i] = getInt(reader);
            }*/

            // int[] nums = {1, 4, 12, 9, 0};
            long[] nums = {5, 0, 1, 2, 3, 1000000000};
//            int[] nums = {5, 0, 1, 2, 3};
//            int[] nums = {1000000000};
            long sum = 0;
            for (long k : nums) {
                long d = k / 4;
                long m = Math.min(k % 4, 2);
                long v = d + m;
                sum += v;
            }
            System.out.println(sum);
        }
    }

    private int getInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

}
