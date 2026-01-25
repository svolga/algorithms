package java.yandex.sprint4.competition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

// G. Соревнование
// https://contest.yandex.ru/contest/23991/problems/G/

public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    private int[] getInput() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            int[] array = new int[count];

            String line = reader.readLine();
            StringTokenizer stz = new StringTokenizer(line);
            for (int i = 0; i < count; i++) {
                array[i] = Integer.parseInt(stz.nextToken());
            }
            return array;
        }
    }

    private void run(String[] args) throws IOException {
        //int[] array = {0, 0, 1, 0, 1, 1, 1, 0, 0, 0};
//        int[] array = {0, 1, 0};
//        int[] array = {0, 0, 1, 0, 0, 0, 1, 0, 0, 1};
//        List<SumRange> sumRange = new ArrayList<>();
        int[] array = getInput();

        int[] sDiff = new int[array.length + 1];
        int countZero = 0;
        int countOne = 0;

        for (int i = 1; i < array.length + 1; i++) {
            if (array[i - 1] == 0) {
                countZero++;
            }
            if (array[i - 1] == 1) {
                countOne++;
            }
            sDiff[i] = countZero - countOne;
        }

        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sDiff.length; i++) {
            int key = sDiff[i];

            int pos = map.getOrDefault(key, i);
            map.put(key, pos);

            int diff = i - pos;
            if (max < diff) {
                max = diff;
            }
        }

        System.out.println(max);

    }
}
