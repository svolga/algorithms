package stepik.recurse.closestnum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://stepik.org/lesson/1221969/step/10?unit=1235378
Задача: найти ближайшее число в массиве

Входные данные
5
9 4 8 1 4
5
1 3 6 9 10

Выходные данные
1
4
4
9
9
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] line1 = br.readLine().split(" ");

        int[] a = Arrays.stream(line1).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(br.readLine());

        String[] line2 = br.readLine().split(" ");
        int[] q = Arrays.stream(line2).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(a);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q.length; i++) {
            int min = closestNum(a, q[i]);
            sb.append(min + "\n");
        }
        System.out.println(sb);

    }

    public static int closestNum(int[] arr, int target) {

        int index = Arrays.binarySearch(arr, target);
        if (index >= 0) return arr[index];

        int insertIndex = -(index + 1);

        // Граничные случаи
        if (insertIndex == 0) return arr[0];
        if (insertIndex == arr.length) return arr[arr.length - 1];

        // Сравнение соседей
        int left = arr[insertIndex - 1];
        int right = arr[insertIndex];

        return Math.abs(target - left) <= Math.abs(target - right) ? left : right;
    }

}
