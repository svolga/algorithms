package java.yandex.sprint4.anagramgroup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

// F. Анаграммная группировка
// https://contest.yandex.ru/contest/23991/problems/F/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            String str = reader.readLine();
//          String str = "tan eat tea ate nat bat";

            StringTokenizer stz = new StringTokenizer(str);
            Map<String, StringBuilder> map = new LinkedHashMap<>();
            int i = 0;
            while (i < count) {
                String subStr = stz.nextToken();
                char[] chars = subStr.toCharArray();
                Arrays.sort(chars);
                subStr = new String(chars);

                StringBuilder sb = map.getOrDefault(subStr, new StringBuilder());
                sb.append(i + " ");
                map.put(subStr, sb);
                i++;
            }

            map.forEach((s, stringBuilder) -> {
                System.out.println(stringBuilder);
            });
        }
    }

    private void print(Character[] chars) {
        System.out.println(Arrays.toString(chars));
    }

}
