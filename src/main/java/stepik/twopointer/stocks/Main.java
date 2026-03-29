package stepik.twopointer.stocks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Задача «Покупаем, докупаем, фиксируем прибыль»
https://stepik.org/lesson/1135564/step/11?unit=1147202


Вам дан поминутный список стоимостей актива с некоторого момента времени. Стоимость актива постоянна в течение каждой минуты. Нам необходимо выбрать ровно одну минуту для покупки актива и ровно одну минуту для последующей продажи. Продать актив можно либо в момент покупки, либо позднее. Какую максимальную прибыль в таком случае мы сможем получить?

Формат входных данных
В первой строке вводится натуральное число N ≤ 10^5
  - количество минут. В следующей строке через пробел вводятся
N целых положительных чисел - стоимости актива в условных единицах для каждой минуты, значения не превышают
10^3.

Формат выходных данных
Выведите максимальную прибыль, которую можно получить при заданных условиях. Если прибыли достичь не получается, то необходимо вывести
0
0 (покупка и продажа в одну и ту же минуту).

Комментарий по тестам
Тест №1: Покупаем актив по стоимости 1, продаём по стоимости 6. Итоговая прибыль
6−1=5.
Тест №2: Прибыль достичь не получается, так как актив падает в цене. Выводим значение 0.

 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] line = br.readLine().split(" ");
        int[] nums = Arrays.stream(line).mapToInt(Integer::parseInt).toArray();

        // Минимальная цена
        int minPrice = Integer.MAX_VALUE;

        // Максимальная прибыль
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minPrice) {
                minPrice = nums[i];
            }
            maxProfit = Math.max(maxProfit, nums[i] - minPrice);
        }

        System.out.println(maxProfit);
    }

}
