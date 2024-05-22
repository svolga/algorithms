package ru.yandex.sprint8.camelcase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

// J. Случай верблюда
// https://contest.yandex.ru/contest/26131/problems/J/
public class Solution {

    public static void main(String[] args) throws IOException {

        Comparator<String> comparator = Comparator.naturalOrder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(reader.readLine());
            List<String> text = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                text.add(reader.readLine());
            }

            int m = Integer.parseInt(reader.readLine());
            Set<String> pattern = new TreeSet<>(comparator);
            for (int i = 0; i < m; i++) {
                pattern.add(reader.readLine());
            }

/*
            List<String> text = List.of("MamaMilaRamu", "MamaMia", "MonAmi");
            Set<String> pattern = new HashSet<>(List.of("MM", "MA"));
*/

            Set<String> result = new TreeSet<>(comparator);

            for (int i = 0; i < text.size(); i++) {

                String word = text.get(i);

                System.out.println("word = " + word);

                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < word.length(); j++) {
                    if (Character.isUpperCase(word.charAt(j))) {
                        sb.append(word.charAt(j));
                        System.out.println(sb);
                        if (pattern.contains(sb.toString())) {
                            result.add(word);
                            break;
                        }
                    }
                }
            }

            StringBuilder res = new StringBuilder();
            result.forEach(s -> res.append(s).append("\n"));
            System.out.println(res);
        }

    }

}
