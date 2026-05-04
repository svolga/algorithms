package stepik.binary.binarysearch.binsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://stepik.org/lesson/1221969/step/12?unit=1235378
Задача: 01-бинпоиск

Вам дана строка из ноликов и единичек. Гарантируется, что сперва в строке идут нолики, затем только единицы.
Вам нужно найти позиции последнего нуля и первой единицы.

Тестовые данные
Входные данные
8
00000111

Выходные данные
4 5
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split("");
        int[] nums = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();

        int left = -1;
        int right = nums.length;

        while (right - left > 1) {
            int mid = (left + right) / 2;

            if (nums[mid] == 0) {
                left = mid;
            } else {
                right = mid;
            }
        }

        System.out.printf("%d %d", left, right);

    }

}
