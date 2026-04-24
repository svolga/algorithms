package stepik.greedy.car;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Задача «Водитель Коля»
https://stepik.org/lesson/1105114/step/11?unit=1116299

Коля едет из пункта
A в пункт B на автомобиле. Расстояние между этими пунктами равно
N километров. Известно, что с полным баком автомобиль способен проехать
k километров. Дана карта, на которой отмечены координаты бензоколонок, относительно пункта
A. Определите минимальное число заправок, которые придется сделать Коле чтобы успешно достичь пункта
B. Известно, что при выезде из пункта A бак был полон.

Формат входных данных
В первой строке вводятся числа N и k (натуральные, не превосходят 1000). В следующей строке вводится количество бензоколонок
S, потом следует S натуральных чисел, не превосходящих N - расстояния от пункта A до каждой заправки.
Заправки упорядочены по удаленности от пункта A.

Формат выходных данных
Если при данных условиях пункта B достичь невозможно, то вывести число −1.
Если решение существует, то вывести минимальное количество остановок на дозаправку,
которое нужно, чтобы достичь пункта B.

Комментарий по тестам
Тест №1: На пути есть только одна заправка в координате
50, на полном баке можем проехать максимум 20 километров, поэтому преодолеть
100 километров не получится. Выводим
−1.

Тест №2: На пути есть только одна заправка в координате
50, на полном баке можем проехать максимум 50 километров, поэтому доезжаем до этой заправки, заправляемся и проезжаем еще
50 километров. Итого преодолеваем путь в 100 километров, выводим значение 1.

Sample Input 1:
100 20
1 50
Sample Output 1:
-1

Sample Input 2:
100 50
1 50
Sample Output 2:
1

 */

class Main {
    public static void main(String[] args) throws Exception {
        // put your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nkArr = getArrayIntFromInteger(reader.readLine(), null);
        int N = nkArr[0], k = nkArr[1];
        int[] points = getArrayIntFromInteger(reader.readLine(), null);

        System.out.println(solve(N, k, points));
    }

    private static int solve(int N, int k, int[] points) {
        int n = points.length, count = 0, total = points[0], tmpK = k;
        points[0] = points[0] <= 0 ? points[0] : points[0] - 1;

        for (int i = 1; i < n; i++) {
            int dist = points[i] - points[i - 1];
            tmpK -= dist;

            if (tmpK == 0) {
                tmpK = k;
                count++;
            } else if (tmpK < 0) {
                return -1;
            }
        }


        return count;
    }

    private static int[] getArrayIntFromInteger(String s, String regex) throws Exception {
        if (s == null || s == "" || s.length() == 0) {
            throw new Exception("s is null");
        }

        if (regex == null || regex == "" || regex.length() == 0) {
            regex = " ";
        }

        return Arrays.stream(s.split(regex)).mapToInt(Integer::parseInt).toArray();
    }
}
