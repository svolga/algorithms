package stepik.binary.findnums;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
https://stepik.org/lesson/1221969/step/9?unit=1235378
Вам дан отсортированный массив
a из n целых чисел от 1 до 10^5.
Вам необходимо ответить на
q запросов вида «сколько чисел в массиве имеют значение от l до r.


Тестовые данные
Входные данные
7
1 1 3 4 4 7 9
7
1 1
1 10
5 6
2 8
3 4
9 9
10 20

Выходные данные
2
7
0
4
3
1
0
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] nums = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
        int q = Integer.parseInt(br.readLine());
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < q; i++) {
            String[] lineQuery = br.readLine().split(" ");

            list.add(new Integer[]{
                    Integer.parseInt(lineQuery[0]),
                    Integer.parseInt(lineQuery[1]),
            });
        }

/*        int[] nums = new int[]{1, 1, 3, 4, 4, 7, 9};
        List<Integer[]> list = List.of(
                new Integer[]{1, 1},  // 0, 1 -> 2
                new Integer[]{1, 10}, // 0, 6 -> 7
                new Integer[]{5, 6},  // 5, 4 -> 0
                new Integer[]{2, 8},  // 2, 5 -> 4
                new Integer[]{3, 4},  // 2, 4 -> 3
                new Integer[]{9, 9},  // 6, 6 -> 1
                new Integer[]{10, 20} // -1, -1 -> 0
        );*/


        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            int value = getCount(nums, list.get(i)[0], list.get(i)[1]);
            sb.append(value).append("\n");
        }
        System.out.println(sb);
    }

    private static int getCount(int[] nums, int minTarget, int maxTarget) {

        int minIdx = getMinIndex(nums, minTarget);
        int maxIdx = getMaxIndex(nums, maxTarget);

        if (minIdx > maxIdx) {
            return 0;
        }

        return maxIdx - minIdx;
    }

    private static int getMinIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = nums.length;
        while (left <=right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }

    private static int getMaxIndex(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int res = nums.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return res;
    }


}
