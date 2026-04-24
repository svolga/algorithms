package stepik.array.minus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://stepik.org/lesson/1073880/step/9?unit=1083952

Дан массив чисел. Преобразовать исходный массив, вычитая максимальное значение массива из элементов массива, идущих после минимального.

Входные данные
12 -30 23 43 1 -3 18 -25 44 31 -28 54 4 14 6 -40 12 -10 -23 21

Выходные данные
12 -30 23 43 1 -3 18 -25 44 31 -28 54 4 14 6 -40 -42 -64 -77 -33

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

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
                minPos = i;
            }

            if (nums[i] > max) {
                max = nums[i];
            }
        }

        for (int i = minPos + 1; i < nums.length; i++) {
            nums[i] = nums[i] - max;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : nums) {
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }

}
