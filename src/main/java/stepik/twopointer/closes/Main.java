package stepik.twopointer.closes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Задача «Стильная одежда»
https://stepik.org/lesson/1135564/step/6?unit=1147202

Маша обожает шоппинг. Как-то раз она загорелась идеей подобрать себе майку и юбку так, чтобы выглядеть
в них максимально стильно. В понимании Маши стильность одежды тем больше, чем меньше разница в цвете
элементов её одежды.

В наличии имеется N маек и M юбок, про каждый элемент известен его цвет (целое число).
Помогите Маше выбрать одну майку и одну юбку так, чтобы разница в их цвете была как можно меньше.

Формат входных данных
В первой строке вводится натуральное значение
N
≤
100

000
N≤100 000. Во второй строке вводится
N
N целых чисел от
1
1 до
10

000

000
10 000 000 - цвета имеющихся в наличии маек. Гарантируется, что номера цветов идут в возрастающем порядке (в частности, цвета никаких двух маек не совпадают).

Далее в том же формате идёт описание юбок: их количество 1≤M≤1≤M≤100 000 и в следующей строке
M от 1 до 10 000 000 в возрастающем порядке - цвета юбок.

Формат выходных данных
Выведите пару неотрицательных чисел через пробел - цвет майки и цвет юбки, которые следует выбрать Маше. Если вариантов выбора несколько, выведите любой из них.

Замечание
Для задачи может существовать несколько ответов. Тестирующая система будет засчитывать любой из корректных.

Комментарий по тестам
Тест №1: Выбираем майку с значением 3 и юбку с значением 3. Тогда разница будет минимальна и равна нулю.
Тест №2: Выбираем майку с значением 4 и юбку с значением 3. Тогда разница будет минимальна и равна единице.

Sample Input 1:

2
3 4
3
1 2 3
Sample Output 1:
3 3

Sample Input 2:

2
4 5
3
1 2 3
Sample Output 2:
4 3

 */
public class Main {

    public static void main(String[] args) throws IOException {

       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] line1 = br.readLine().split(" ");
        int[] nums1 = Arrays.stream(line1).mapToInt(Integer::parseInt).toArray();

        int M = Integer.parseInt(br.readLine());
        String[] line2 = br.readLine().split(" ");
        int[] nums2 = Arrays.stream(line2).mapToInt(Integer::parseInt).toArray();
        
        int minDiff = Integer.MAX_VALUE;
        int i = 0;
        int j = 0;
        int[] result = new int[]{0, 0};
        while (i < nums1.length && j < nums2.length) {
            int curDiff = Math.abs(nums1[i] - nums2[j]);

            if (curDiff < minDiff) {
                result = new int[]{nums1[i], nums2[j]};
                minDiff = Math.min(curDiff, minDiff);
            }
            if(nums1[i] < nums2[j]) {
                i++;
            }
            else {
                j++;
            }
        }

        System.out.println(String.format("%d %d", result[0], result[1]));
    }

}
