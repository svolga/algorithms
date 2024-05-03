package ru.yandex.sprint8.insertstrings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

// E. Вставка строк
// https://contest.yandex.ru/contest/26131/problems/E/
public class Solution {

    public static void main(String[] args) throws IOException {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        };

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            StringBuilder text = new StringBuilder(reader.readLine());

//          StringBuilder text = new StringBuilder("kukareku");
//            map.put(1, "p");
//            map.put(2, "q");

            int count = Integer.parseInt(reader.readLine());
            Map<Integer, String> map = new TreeMap<>(comparator);
            for (int i = 0; i < count; i++) {
                StringTokenizer stz = new StringTokenizer(reader.readLine());
                String word = stz.nextToken();
                int pos = Integer.parseInt(stz.nextToken());
                map.put(pos, word);
            }

            map.forEach((position, value) -> {
                text.insert(position, value);
            });

            System.out.println(text);
        }
    }
}
