package stepik.dp.tickets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Задача «Покупка билетов»
https://stepik.org/lesson/1110493/step/6?unit=1121860

 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        int[] A = new int[N + 1];
        int[] B = new int[N + 1];
        int[] C = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            String[] line = br.readLine().split(" ");
            A[i] = Integer.parseInt(line[0]);
            B[i] = Integer.parseInt(line[1]);
            C[i] = Integer.parseInt(line[2]);
        }

        if (N == 1) {
            System.out.println(A[1]);
        } else {
            dp[1] = A[1];
            dp[2] = Math.min(A[1] + A[2], B[1]);

            for (int i = 3; i <= N; i++) {
                dp[i] = Math.min(dp[i - 1] + A[i],
                        Math.min(dp[i - 2] + B[i - 1], dp[i - 3] + C[i - 2]));
            }
            System.out.println(dp[N]);
        }

    }

}
