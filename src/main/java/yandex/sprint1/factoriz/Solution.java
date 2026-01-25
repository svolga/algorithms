package java.yandex.sprint1.factoriz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// J. Факторизация
// https://contest.yandex.ru/contest/22449/problems/J/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int value = Integer.valueOf(reader.readLine());
            List<Integer> result = getFactorization(value);

            StringBuilder sb = new StringBuilder();
            result.forEach(integer -> sb.append(integer).append(" "));
            System.out.println(sb);

        }
    }

    private List<Integer> getFactorization(int value) {

        List<Integer> list = new ArrayList<>();
        int current = value;

        int k = 2;
        while (k * k <= value) {
            if (value % k == 0) {
                value /= k;
                list.add(k);
            } else {
                ++k;
            }
        }

        if (value != 1){
            list.add(value);
        }

        return list;
    }
    
}
