package java.yandex.sprint4.section;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

// D. Кружки
// https://contest.yandex.ru/contest/23991/problems/D/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            Set<String> set = new LinkedHashSet<>();
            for (int i = 0; i < count; i++) {
                String title = reader.readLine();
                set.add(title);
            }
            for (String s : set) {
                System.out.println(s);
            }
        }
    }

}
