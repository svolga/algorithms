package stepik.binary.findstream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Vector;
import java.util.stream.IntStream;

/*
https://stepik.org/lesson/1221969/step/8?unit=1235378

У вас есть вектор целых чисел, который отсортирован в порядке возрастания. Напишите программу, которая принимает целое число N и использует встроенный алгоритм std::lower_bound для определения первого элемента в векторе, который не меньше N.

Входные данные
5
1 2 3 4 5
3

Выходные данные
2

 */
public class Solution {
    public static void main(String[] args) throws IOException {

/*        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] nums = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(br.readLine());*/

        String[] line = new String[]{"-1", "-2"};
        int[] nums = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();
        int target = 3;

        Vector<Integer> vector = new Vector<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            vector.add(nums[i]);
        }

        int maxIdx = IntStream.range(0, vector.size())
                .filter(i -> vector.get(i) >= target)
                .max()
                .orElse(-1);

        if (maxIdx == -1) {
            System.out.println(-1);
            return;
        }

        int maxVal = vector.get(maxIdx);

        int idx = IntStream.range(0, vector.size())
                .filter(i -> vector.get(i) == maxVal)
                .findFirst()
                .orElse(-1);

        System.out.println(idx);

    }
}
