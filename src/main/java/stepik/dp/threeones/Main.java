package stepik.dp.threeones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

/*
Задача «Мы запрещаем три единицы»
https://stepik.org/lesson/1110493/step/1?unit=1121860

Определите количество последовательностей из нулей и единиц длины
N (длина - это общее количество нулей и единиц), в которых никакие три единицы не стоят рядом.

Формат входных данных
На вход программе подаётся натуральное число N≤40.

Формат выходных данных
Выведите количество искомых последовательностей длины N.

Комментарий по тестам
Тест №1:
N=1, возможные последовательности
0;1.
Итого: 2 последовательности.

Тест №2:
N=3, возможные последовательности
000;001;010;011;100;101;110.
Итого: 7 последовательностей.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long P = getTreeOnes(N);
        System.out.println(P);
    }

    private static long getTreeOnes(int n) {
        Map<Integer, Integer> map = Map.of(1, 2, 2, 4, 3, 7);

        if (n <= 3) {
            return map.get(n);
        }

        long dp1 = map.get(1);
        long dp2 = map.get(2);
        long dp3 = map.get(3);
        long value = 0;
        for (int i = 4; i <= n; i++) {
            value = dp1 + dp2 + dp3;
            dp1 = dp2;
            dp2 = dp3;
            dp3 = value;
        }
        return value;
    }

}
