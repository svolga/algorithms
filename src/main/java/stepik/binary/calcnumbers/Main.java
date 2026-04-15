package stepik.binary.calcnumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://stepik.org/lesson/1221969/step/6?unit=1235378

Создайте программу, которая выполняет бинарный поиск для определения количества элементов в отсортированном векторе, которые не превышают заданного значения.

Входные данные
5
1 3 5 7 9
3
3
4
9

Выходные данные
2
2
5
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] line1 = br.readLine().split(" ");
        int[] nums = Arrays.stream(line1).mapToInt(Integer::parseInt).toArray();

        int q = Integer.parseInt(br.readLine());
        int[] qs = new int[q];
        for (int i = 0; i < q; i++) {
            qs[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < qs.length; i++) {
            System.out.println(search(nums, qs[i]));
        }
    }

    private static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int lastValue = 0;
        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                left = mid + 1;  // Переходим в правую половину массива для поиска последнего вхождения
                lastValue = mid + 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                lastValue = mid;
                right = mid - 1;
            }
        }
        return lastValue;
    }

}
