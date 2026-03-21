package stepik.greedy.cargo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Задача «Партия грузов»
https://stepik.org/lesson/1105114/step/5?unit=1116299

Для перевозки партии грузов различной массы выделен грузовик, но его грузоподъёмность ограничена, поэтому перевезти сразу все грузы не удастся. Грузы массой от
210 до 220 кг грузят в первую очередь, гарантируется, что все такие грузы поместятся.
На оставшееся после этого место стараются взять как можно больше грузов.
Если это можно сделать несколькими способами, выбирают тот способ,
при котором самый большой из выбранных грузов имеет наибольшую массу.
Если и при этом условии возможно несколько вариантов, выбирается тот,
при котором наибольшую массу имеет второй по величине груз, и т.д.
Известны количество грузов, масса каждого из них и грузоподъёмность грузовика.
Необходимо определить количество и общую массу грузов, которые будут вывезены при погрузке
по вышеописанным правилам.

Формат входных данных
Первая строка содержит два натуральных числа
N≤10^4
  (количество грузов)
M≤10^5
  (грузоподъёмность грузовика в кг). Далее в следующей строке задаются
N масс грузов в кг через пробел: целые положительные числа, меньшие 1000.

Формат выходных данных
Программа должна вывести два целых числа через пробел: сначала максимально возможное
количество грузов, затем их общую массу.


Sample Input 1:
6 615
140 215 120 160 100 340

Sample Output 1:
4 615

Sample Input 2:
7 1024
111 222 333 98 345 423 56

Sample Output 2:
5 1021

 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = br.readLine().split(" ");
        String[] line2 = br.readLine().split(" ");

        int N = Integer.parseInt(line1[0]); // количество грузов
        int M = Integer.parseInt(line1[1]); // грузоподъёмность грузовика в кг
        int[] weights = Arrays.stream(line2).mapToInt(Integer::parseInt).toArray();

        int[] results = calculate(weights, M);
        System.out.printf("%d %d%n", results[0], results[1]);
    }

    private static int[] calculate(int[] weights, int M) {
        int count = 0;
        int total = 0;
        for (int w : weights) {
            if (w <= 220 && w >= 210) {
                total += w;
                count++;
            }
        }

        weights = Arrays.stream(weights)
                .filter(w -> (w < 210 || w > 220))
                .sorted()
                .toArray();

        int iMax = 0;
        int N = weights.length;

        for (int i = 0; i < N; i++) {
            if (total + weights[i] < M) {
                total += weights[i];
                iMax = i;
                count++;
            } else {
                break;
            }
        }

        for (int j = iMax; j >= 0; j--) {
            for (int i = iMax + 1; i < N; i++) {
                if (total - weights[j] + weights[i] <= M) {
                    total = total - weights[j] + weights[i];
                    int temp = weights[j];
                    weights[j] = weights[i];
                    weights[i] = temp;
                }
            }
        }

        return new int[]{count, total};
    }

}
