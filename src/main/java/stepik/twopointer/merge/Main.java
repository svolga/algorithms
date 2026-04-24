package stepik.twopointer.merge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Задача «Слияние»
https://stepik.org/lesson/1135564/step/1?unit=1147202

Вам даны два целочисленных массива, отсортированных в порядке неубывания. Необходимо объединить массивы в один так, чтобы отсортированность в порядке неубывания сохранилась.

Важно: Окончательный отсортированный массив должен сформироваться из первого массива. Чтобы это было возможно сделать, первый массив дополнен недостающими нулями при вводе.


Формат выходных данных
Выведите элементы итогового объединённого отсортированного в порядке неубывания массива. Элементы выводите в одну строку через пробел.

Замечание
Вы должны в первую очередь сформировать и заполнить значения в массив
a в указанном формате, а только после выводить его значения.

Sample Input 1:

3
1 2 3 0 0 0
3
2 5 6
Sample Output 1:

1 2 2 3 5 6
Sample Input 2:

4
1 5 10 44 0 0
2
12 22
Sample Output 2:

1 5 10 12 22 44
Напишите программу.

 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] line2 = br.readLine().split(" ");
        int[] nums1 = Arrays.stream(line2).mapToInt(Integer::parseInt).toArray();

        int M = Integer.parseInt(br.readLine());
        String[] line4 = br.readLine().split(" ");
        int[] nums2 = Arrays.stream(line4).mapToInt(Integer::parseInt).toArray();

        int p = M + N - 1;
        int p1 = N - 1;
        int p2 = M - 1;

        while (p2 >= 0) {
            if (p1>=0 && nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1];
                p1--;
            } else {
                nums1[p] = nums2[p2];
                p2--;
            }
            p--;
        }

        StringBuilder sb = new StringBuilder();
        for (int i : nums1) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

}
