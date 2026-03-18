package stepik.binary.transmitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Задача «Два передатчика»

На координатной прямой расположены точки. Необходимо поставить два передатчика одинакового радиуса действия так, чтобы каждая точка оказалась в зоне покрытия хотя бы одного из них.


Входные данные
В первой строке вводится количество точек: целое положительное значение 3≤n≤10^5.
В следующих n строках вводятся координаты точек на числовой прямой: числа с плавающей точкой, по модулю не превосходят
10^4, каждое число вводится с новой строки.

Выходные данные
Выведите одно число - наименьший возможный радиус передатчика для покрытия всех точек. Если точка находится на границе зоны, которую покрывает передатчик, то она также включается в покрытие. Значение вычислите с точностью
10^−6.

Комментарий по тестам
Тест №1: Минимальный радиус для покрытия равен 2.5. Первый передатчик ставим в координату 3.5, он покроет все точки из отрезка
[2;6], то есть в нашем случае это точки с координатами 1.0 2.0 6.0. Второй передатчик ставим в координату, например, 12.0. Тогда он покроет все точки из отрезка
[9,5;14,5], то есть будут покрыты точки с координатами 10.0 и 14.0.

Sample Input:
5
1.000000
2.000000
6.000000
10.000000
14.000000

Sample Output:
2.500000

 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int pointCount = Integer.parseInt(br.readLine());

        double[] points = new double[pointCount];
        for (int i = 0; i < pointCount; i++) {
            points[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(points);

        double R = getMinimalRadius(points, 0.0000001);

        System.out.printf("%.5f%n", R);
    }

    private static boolean isCanCover(double[] points, double R) {
        int n = points.length;
        int i = 0;

        double firstTransmitter = points[i] + 2 * R; // Зона покрытия первого передатчика
        while (i < n && points[i] <= firstTransmitter) {
            i += 1;
        }

        if (i == n) {
            return true;
        }

        double secondTransmitter = points[i] + 2 * R; // Зона покрытия второго передатчика
        while (i < n && points[i] <= secondTransmitter) {
            i += 1;
        }

        return i == n;
    }

    private static double getMinimalRadius(double[] points, double eps) {
        double left = 0.0;
        double right = points[points.length - 1] - points[0];

        while (right - left > eps) {
            double mid = (left + right) / 2;
            if (!isCanCover(points, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
