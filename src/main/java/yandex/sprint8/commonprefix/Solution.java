package java.yandex.sprint8.commonprefix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// D. Общий префикс
// https://contest.yandex.ru/contest/26131/problems/D/
public class Solution {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int count = Integer.parseInt(reader.readLine());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                list.add(reader.readLine());
            }
/*
            list.add("qwe");
            list.add("qwerty");
            list.add("qwerpy");
*/

            int pos = getCommonPrefix(list);
            System.out.println(pos);
        }
    }

    private static int getCommonPrefix(List<String> list) {
        if (list.size() == 1) {
            return list.get(0).length();
        }

        long letterCount = Integer.MAX_VALUE;
        for (String item : list) {
            letterCount = Math.min(letterCount, item.length());
        }

        int pos = 0;
        int i = 1;
        while (pos < letterCount) {
            if (list.get(i).charAt(pos) != list.get(0).charAt(pos)) {
                break;
            }

            if (i < list.size() - 1) {
                i++;
            } else {
                pos++;
                i = 1;
            }
        }

        return pos;
    }
}

