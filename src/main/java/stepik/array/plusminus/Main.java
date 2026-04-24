package stepik.array.plusminus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://stepik.org/lesson/1073880/step/10?unit=1083952

Дан массив. Преобразовать исходный массив, вычитая из значений отрицательных элементов массива количество положительных значений, а из значений положительных элементов массива количество отрицательных значений.

Входные данные
12 -30 23 43 1 -3 18 -25 44 31 -28 54 4 14 6 -40 12 -10 -23 21

Выходные данные
5 -43 16 36 -6 -16 11 -38 37 24 -41 47 -3 7 -1 -53 5 -23 -36 14
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        int[] nums = Arrays.stream(line)
                .mapToInt(Integer::parseInt)
                .toArray();

        int negativeCount = 0;
        int positiveCount = 0;
        for (int num : nums) {
            if (num < 0) {
                negativeCount++;
            } else if (num > 0) {
                positiveCount++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                nums[i] -= positiveCount;
            } else if (nums[i] > 0) {
                nums[i] -= negativeCount;
            }

            System.out.print(nums[i] + " ");
        }
    }
}
