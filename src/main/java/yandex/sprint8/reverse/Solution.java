package java.yandex.sprint8.reverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// A. Разворот строки
// https://contest.yandex.ru/contest/26131/problems/A/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String str = reader.readLine();
            StringBuilder sb = new StringBuilder();
            String[] words = str.split(" ");
            for (int i = words.length - 1; i >= 0; i--) {
                sb.append(words[i]).append(" ");
            }
            System.out.println(sb);
        }
    }
}
