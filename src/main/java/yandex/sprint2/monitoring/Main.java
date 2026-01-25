package java.yandex.sprint2.monitoring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://contest.yandex.ru/contest/22779/problems/
// A. Мониторинг

public class Main {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int rowCount = Integer.valueOf(reader.readLine());
            int colCount = Integer.valueOf(reader.readLine());

            int[][] inArray = new int[rowCount][colCount];

            for (int i = 0; i < rowCount; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < colCount; j++) {
                    inArray[i][j] = Integer.valueOf(stringTokenizer.nextToken());
                }
            }

            int[][] transpArray = new int[colCount][rowCount];
            for (int i = 0; i < rowCount; i++) {
                for (int j = 0; j < colCount; j++) {
                    transpArray[j][i] = inArray[i][j];
                }
            }
            System.out.println(convertArrayToString(transpArray, colCount, rowCount));
        }
    }

    private static String convertArrayToString(int[][] inArray, int rowCount, int colCountj) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCountj; j++) {
                sb.append(inArray[i][j] + " ");
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

}
