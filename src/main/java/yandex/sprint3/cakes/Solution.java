package java.yandex.sprint3.cakes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// D. Печеньки
// https://contest.yandex.ru/contest/23638/problems/D/
public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int childCount = Integer.parseInt(reader.readLine());
            StringTokenizer stzFactor = new StringTokenizer(reader.readLine());
            int cakeCount = Integer.parseInt(reader.readLine());
            StringTokenizer stzSize = new StringTokenizer(reader.readLine());

            Integer[] factors = new Integer[childCount];
            for (int i = 0; i < childCount; i++) {
                factors[i] = Integer.parseInt(stzFactor.nextToken());
            }

            Integer[] sizes = new Integer[cakeCount];
            for (int j = 0; j < cakeCount; j++) {
                sizes[j] = Integer.parseInt(stzSize.nextToken());
            }
/*
            Integer[] factors = {2, 1, 3};
            Integer[] sizes = {1,1};
*/
            int res = getFunnyChildren(factors, sizes);
            System.out.println(res);
        }
    }

    private int getFunnyChildren(Integer[] factors, Integer[] sizes) {
        Arrays.sort(factors, Collections.reverseOrder());
        Arrays.sort(sizes, Collections.reverseOrder());
        int f = 0;
        int s = 0;
        int count = 0;
        while (f < factors.length) {
            if (s < sizes.length && factors[f] <= sizes[s]) {
                count++;
                s++;
            }
            f++;
        }
        return count;
    }

}
