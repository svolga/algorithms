package java.yandex.sprint4.sumfour;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;


// J. Сумма четвёрок
// https://contest.yandex.ru/contest/23991/problems/J/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {
/*
        int target = 10;
        int[] array = {2, 3, 2, 4, 1, 10, 3, 0};
*/

/*
        int target = 0;
        int[] array = {1, 0, -1, 0, 2, -2};
*/

//        Set<MyArray> res = effectiveSolution4(target, array);
//        res.forEach(myArray -> System.out.println(Arrays.toString(myArray.getArray())));

/*

        List<List<Integer>> res = fourSum(array, target);
        System.out.println(res);
*/

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            int target = Integer.parseInt(reader.readLine());

            int[] array = new int[count];

            StringTokenizer stz = new StringTokenizer(reader.readLine());
            for (int i = 0; i < count; i++) {
                array[i] = Integer.parseInt(stz.nextToken());
            }

            List<List<Integer>> list = fourSum(array, target);
            System.out.println(list.size());
            StringBuilder sb = new StringBuilder();

            for (List<Integer> integers : list) {
                for (Integer integer : integers) {
                    sb.append(integer).append(" ");
                }
                sb.append(System.lineSeparator());
            }
            System.out.println(sb);
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {

        Arrays.sort(nums);
        int n = nums.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int start = j + 1;
                int end = n - 1;

                while (start < end) {
                    long sum = (long) nums[i] + nums[j] + nums[start] + nums[end];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));

                        start++;
                        end--;

                        while (start < end && nums[start] == nums[start - 1]) {
                            start++;
                        }

                        while (start < end && nums[end] == nums[end + 1]) {
                            end--;
                        }
                    } else if (sum < target) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }

        return result;
    }

}