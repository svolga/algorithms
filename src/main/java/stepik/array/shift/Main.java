package stepik.array.shift;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://stepik.org/lesson/1073880/step/12?unit=1083952

У вас есть массив чисел и целое число k. Сдвиньте массив вправо на k шагов.

Входные данные
5
1 2 3 4 5
2

Выходные данные
4 5 1 2 3
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");

        int[] nums = Arrays.stream(line)
                .mapToInt(Integer::parseInt)
                .toArray();

        int k = Integer.parseInt(br.readLine());

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
