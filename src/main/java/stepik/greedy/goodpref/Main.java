package stepik.greedy.goodpref;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Задача «Хорошие префиксы»
https://stepik.org/lesson/1236735/step/5?unit=1250466
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] line2 = br.readLine().split(" ");
        int[] nums = Arrays.stream(line2)
                .mapToInt(Integer::parseInt)
                .toArray();


        long sum = 0;
        long max = 0;
        int countGoodPrefix = 0;
        for (int i = 0; i < N; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
            if (2 * max == sum) {
                countGoodPrefix++;
            }
        }

        System.out.println(countGoodPrefix);
    }

}
