package ru.yandex.sprint7.travel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

// J. Путешествие
// https://contest.yandex.ru/contest/25596/problems/J/
public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int count = Integer.parseInt(reader.readLine());
            int[] nums = new int[count];
            StringTokenizer stz = new StringTokenizer(reader.readLine());
            for (int i = 0; i < count; i++) {
                nums[i] = Integer.parseInt(stz.nextToken());
            }

            int res = lengthOfLIS2(nums);
        }

//        int[] nums = {7, 2, 1, 3, 8, 4, 9, 1, 2, 6, 5, 9, 3, 8, 1};
//        int[] nums = {4, 2, 9, 1, 13};
//        int[] nums = {1, 2, 4, 8, 16, 32};
//        int res = lengthOfLIS2(nums);
    }

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[nums.length];

        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
        }

        // Индекс последнего элемента НВП
        int pos = 0;
        int max = dp[0];
        for (int i = 0; i < n; i++) {
            if (dp[i] >= max) {
                max = dp[i];
                pos = i;
            }
        }

        System.out.println(max);
//        System.out.println("pos = " + pos);

        List<Integer> answer = new ArrayList<>();

        while (pos != -1) {
            answer.add(pos + 1);
            pos = prev[pos];
        }

        Collections.reverse(answer);

/*
        System.out.println("nums: " + Arrays.toString(nums));
        System.out.println("dp: " + Arrays.toString(dp));
        System.out.println("prev: " + Arrays.toString(prev));
*/
//        System.out.println("max = " + max);


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.size(); i++) {
            sb.append(answer.get(i)).append(" ");
        }
        sb.append(System.lineSeparator());
        System.out.println(sb);

        return max;

    }

}
