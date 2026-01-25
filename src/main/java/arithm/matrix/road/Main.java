package java.arithm.matrix.road;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://stepik.org/lesson/283897/step/2?unit=265205
public class Main {

    public static void main(String[] args) throws IOException {
        new Main().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int size = Integer.valueOf(reader.readLine());

            int[][] matrix = new int[size][size];

            for (int i = 0; i < size; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

                int j = 0;
                while (stringTokenizer.hasMoreElements()) {
                    int value = Integer.valueOf(stringTokenizer.nextToken());
                    matrix[i][j] = value;
                    j++;
                }
            }

            int count = 0;

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (matrix[i][j] == 1 && matrix[j][i] == 1) {
                        count++;
                    }
                }
            }
            System.out.println(count/2);
        }
    }

}
