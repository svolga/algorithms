package stepik.dp.rain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Задача «Подожди дожди»
https://stepik.org/lesson/1110493/step/8?unit=1121860
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] lines1 = br.readLine().split(" ");
        int N = Integer.parseInt(lines1[0]);
        int K = Integer.parseInt(lines1[1]);

        String[] lines2 = br.readLine().split(" ");
        int[]nums = Arrays.stream(lines2).mapToInt(Integer::parseInt).toArray();

        int[] mPrev = new int[N];
        Arrays.fill(mPrev, 0);
        int prevMax = 0;
        for (int i = 0; i < N; i++) {
            if (nums[i]>prevMax) {
                prevMax = nums[i];
            }
            mPrev[i] = prevMax;
        }

        int mdiff = 0;
        for (int i = K; i < N; i++) {
            mdiff = Math.max(mdiff, nums[i] + mPrev[i-K]);
        }

        System.out.println(mdiff);
    }


}
