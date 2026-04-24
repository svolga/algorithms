package stepik.array.less;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://stepik.org/lesson/1073880/step/13?unit=1083952

Дан массив, состоящий из целых чисел. Напишите программу, которая в данном массиве определит количество элементов, у которых два соседних и, при этом, оба соседних элемента меньше данного.\

 Входные данные
 5
1 5 1 5 1

Выходные данные
2
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");

        int[] nums = Arrays.stream(line)
                .mapToInt(Integer::parseInt)
                .toArray();

        int count = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1] && nums[i] > nums[i - 1]) {
                count++;
            }
        }

        System.out.println(count);
    }
}
