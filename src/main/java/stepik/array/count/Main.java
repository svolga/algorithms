package stepik.array.count;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://stepik.org/lesson/1073880/step/7?unit=1083952

Вы получили набор чисел и конкретное число. Напишите программу, которая возвращает, сколько раз конкретное число встречается в этом наборе.

Входные данные
5
1 2 3 2 2
2

Выходные данные
3
*/
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] nums = Arrays.stream(line)
                .mapToInt(Integer::parseInt)
                .toArray();

        int target = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                count++;
            }
        }
        System.out.println(count);
    }

}
