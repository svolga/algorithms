package stepik.greedy.discount;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Задача «Распродажа для хомяков»

Продавец предоставляет покупателю, делающему большую закупку, скидку по следующим правилам:

на каждый второй товар стоимостью больше
50
50 рублей предоставляется скидка
25
%
25%;
общая стоимость покупки со скидкой округляется вверх до целого числа рублей;
порядок товаров в списке определяет продавец и делает это так, чтобы общая сумма скидки была наименьшей.
По известной стоимости каждого товара в покупке необходимо определить общую стоимость покупки с учётом скидки и стоимость самого дорогого товара, на который будет предоставлена скидка.

Формат входных данных
Первая строка содержит натурально число
N
≤
1
0
4
N≤10
4
  - общее количество купленных товаров. В следующей строке записаны стоимости товаров:
N
N целых положительных чисел через пробел, каждое число не превышает
1
0
4
10
4
 .

Формат выходных данных
Программа должна вывести два целых числа: сначала общую стоимость покупки с учётом скидки, затем стоимость самого дорогого товара, на который будет предоставлена скидка (до применения скидки). Если скидка не будет предоставляться ни на один товар, то вторым значением выведите -1. Значения выводите в одну строку через пробел.

Замечание
Товары, стоимость которых
50
50 единиц или меньше, можно считать "белым шумом", то есть продавец не учитывает их порядок, когда предоставляет скидку (смотри комментарий по тестам).

Комментарий по тестам
Тест №1: При правильном расположении товаров продавцом скидка будет предоставлена на товары стоимостью
125 и 144, в таком случае стоимость покупки будет равна
50 + (125+144)⋅

50+(125+144)⋅0,75+215+320+490=1276,75. После округления вверх до целого числа получаем
1277.
Самый дорого товар, на который будет предоставлена скидка, будет иметь стоимость
144.

Тесты:
Sample Input 1:
6
125 50 490 215 144 320
Sample Output 1:

1277 144
Sample Input 2:

10
212 30 44 5 88 9 1011 982 192 10
Sample Output 2:

2513 192


 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        String line1 = br.readLine();

        int[] nums = Arrays.stream(line1.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] result = calculateDiscount(nums);
        System.out.println(String.format("%d %d", result[0], result[1]));
    }


    private static int[] calculateDiscount(int[] nums) {

        int[] array = Arrays.stream(nums)
                .filter(value -> value > 50)
                .sorted()
                .toArray();

        int sum = Arrays.stream(nums)
                .filter(value -> value <= 50)
                .sum();

        if (array.length == 0) {
            return new int[]{sum, -1};
        }

        int lastDiscountIndex = (array.length / 2);

        double discountedSum = 0;
        for (int i = 0; i < lastDiscountIndex; i++) {
            discountedSum += array[i];
        }
        sum += (int) Math.ceil(discountedSum * 0.75);

        for (int i = lastDiscountIndex; i < array.length; i++) {
            sum += array[i];
        }

        return new int[]{sum, array[lastDiscountIndex - 1]};
    }

}
