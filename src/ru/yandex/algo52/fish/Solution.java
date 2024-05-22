package ru.yandex.algo52.fish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// B. Продавец рыбы
// https://contest.yandex.ru/contest/59540/problems/B/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
/*

            String[] line1 = reader.readLine().strip().split(" ");
            int count = Integer.parseInt(line1[0]);
            int limit = Integer.parseInt(line1[1]);

            String[] line2 = reader.readLine().strip().split(" ");
            int[] nums = Arrays.stream(line2).mapToInt(Integer::parseInt).limit(count).toArray();
*/
            int limit = 2;
            int[] nums = {1, 2, 3, 4, 5};
            int profit = getProfit(nums, limit);
            System.out.println("p=" + profit);
        }

    }


    private int getProfit(int[] nums, int limit) {

        int profit = 0;

  /*      for (int i = 0; i < nums.length - limit; i++) {
            int[] ns = new int[limit + 1];
            ns[0] = 0;
            int max = 0;
            for (int j = 1; j <= limit; j++) {
                int dif = nums[i + j] - nums[i + j - 1];
                max = Math.max(dif, ns[j-1] + dif);
                ns[j] = max;
            }

            profit = Math.max(profit, max);
        }
*/

        int left = 0;
        int right = limit;

        while (right <= nums.length) {

            System.out.println("left = " + left);
            int[] ns = new int[limit + 1];
            ns[0] = 0;
            int max = 0;
//
            int maxProfit = 0;
            int minValue = nums[0];

            for (int i = left; i < nums.length; i++)
            {
                if (nums[i] < minValue)
                {
                    minValue = nums[i];
                    continue;
                }
                else
                {
                    if (nums[i] - minValue > maxProfit)
                        maxProfit = nums[i] - minValue;
                }
            }


/*
            for (int j = 1; j <= limit; j++) {

                int dif = nums[left + j - 1] - nums[left + j];
                max = Math.max(dif, ns[j - 1] + dif);
                ns[j - 1] = max;

                System.out.println(nums[left + j]);
            }

            profit = Math.max(profit, max);*/

//

/*
int maxProfit = 0;
int minValue = prices[0];

 for (int i = 1; i < prices.Length; i++)
 {
    if (prices[i] < minValue)
    {
        minValue = prices[i];
        continue;
    }
 else
 {
     if (prices[i] - minValue > maxProfit)
     maxProfit = prices[i] - minValue;
 }
}
*/

//

            left++;
            right++;

        }


        return profit;
    }

    private int getInt(BufferedReader reader) throws IOException {
        return Integer.parseInt(reader.readLine());
    }

}
