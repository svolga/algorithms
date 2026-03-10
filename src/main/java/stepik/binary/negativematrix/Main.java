package stepik.binary.negativematrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Задача «Количество отрицательных в отсортированной матрице»
Дана матрица, элементы строк которой отсортированы по невозрастанию как по строкам,
так и по столбцам. Найти количество отрицательных элементов в этой матрице.

Пример ввода данных:
4 4
4 3 2 -1
3 2 1 -1
1 1 -1 -2
-1 -1 -2 -3
Ответ: 8
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line0 = br.readLine().split(" ");

        int N = Integer.parseInt(line0[0]); // Строк
        int K = Integer.parseInt(line0[1]); // Столбцов

        int[][] matrix = new int[N][K];

        String[] lines = new String[N];
        for (int r = 0; r < N; r++) {
            lines[r] = br.readLine();
        }

        for (int i = 0; i < N; i++) {
            String[] line1 = lines[i].split(" ");
            int[] row = Arrays.stream(line1).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < K; j++) {
                matrix[i][j] = row[j];
            }
        }

        int count = printMatrix(matrix, N, K);
        System.out.println(count);
    }

    private static int printMatrix(int[][] matrix, int N, int K) {

        int count = 0;
        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = K - 1;
            int firstMinus = K;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (matrix[i][mid] < 0) {
                    right = mid - 1;
                    firstMinus = mid;
                } else {
                    left = mid + 1;
                }
            }

            count += K - firstMinus;

        }
        return count;
    }

}
