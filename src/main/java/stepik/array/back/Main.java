package stepik.array.back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://stepik.org/lesson/1073880/step/11?unit=1083952

Дан массив целых чисел. Преобразовать исходный массив, переставляя в обратном порядке элементы между максимальным и минимальным значениями массива, включая их.

Входные данные
12 -30 23 43 1 -3 18 -25 44 31 -28 54 4 14 6 -40 12 -10 -23 21

Выходные данные
12 -30 23 43 1 -3 18 -25 44 31 -28 -40 6 14 4 54 12 -10 -23 21
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int[] nums = Arrays.stream(line)
                .mapToInt(Integer::parseInt)
                .toArray();

        int min = nums[0];
        int max = nums[0];
        int minPos = 0;
        int maxPos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
                minPos = i;
            }

            if (nums[i] > max) {
                max = nums[i];
                maxPos = i;
            }
        }

        int left = Math.min(minPos, maxPos);
        int right = Math.max(minPos, maxPos);

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
