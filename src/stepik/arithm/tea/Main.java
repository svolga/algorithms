package stepik.arithm.tea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://stepik.org/lesson/283896/step/6?unit=265204
public class Main {

    public static void main(String[] args) throws IOException {
        new Main().run(args);
    }

    private void run(String[] args) throws IOException {
        int length = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int rowCount = Integer.valueOf(reader.readLine());
            for (int i = 0; i < rowCount; i++) {
                StringTokenizer stringTokenizer = new StringTokenizer(reader.readLine());

                int left = Integer.valueOf(stringTokenizer.nextToken());
                int right = Integer.valueOf(stringTokenizer.nextToken());
                int stepCount = Integer.valueOf(stringTokenizer.nextToken());

                length += stepCount * (left - right);
            }
            length = Math.abs(length) / 100;
        }

        System.out.println(length);
    }

}
