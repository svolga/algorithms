package stepik.binary.checkword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*

https://stepik.org/lesson/1221969/step/7?unit=1235378
Дан отсортированный массив чисел и число N. Необходимо написать программу, которая использует встроенный алгоритм бинарного поиска, чтобы определить, присутствует ли N в данном массиве.

Входные данные
5
-10 -1 0 3 10
3

Выходные данные
YES
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");
        int[] nums = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();

        int target = Integer.parseInt(br.readLine());

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                System.out.println("YES");
                return;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }

        System.out.println("NO");
    }

}
