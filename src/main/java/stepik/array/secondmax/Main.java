package stepik.array.secondmax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://stepik.org/lesson/1073880/step/8?unit=1083952
Найдите второе по величине число в массиве чисел. Максимальное число в массиве встречается единожды.


Входные данные
5
1 3 3 5 4

Выходные данные
4

 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line = br.readLine().split(" ");
        int[] nums = Arrays.stream(line)
                .mapToInt(Integer::parseInt)
                .toArray();

        Arrays.sort(nums);
        int value = nums.length > 1 ? nums[nums.length-2] : 0;

        System.out.println(value);
    }
}
