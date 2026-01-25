package java.yandex.sprint8.comparestring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// K. Сравнить две строки
// https://contest.yandex.ru/contest/26131/problems/K/
/*
Алла придумала новый способ сравнивать две строки: чтобы сравнить строки a и b, в них надо оставить только те буквы,
которые в английском алфавите стоят на четных позициях. Затем полученные строки сравниваются по обычным правилам.
Помогите Алле реализовать новое сравнение строк.
*/
public class Solution {

    private final static Set<Character> evenLetters = new HashSet<>
            (Set.of('b', 'd', 'f', 'h', 'j', 'l', 'n', 'p', 'r', 't', 'v', 'x', 'z'));

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String str1 = reader.readLine();
            String str2 = reader.readLine();

            int value = compareStrings(str1, str2);
            System.out.println(value);
        }
    }

    private static int compareStrings(String str1, String str2) {

        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        str1.chars().filter(value -> evenLetters.contains((char) value)).forEach(value -> sb1.append((char) value));
        str2.chars().filter(value -> evenLetters.contains((char) value)).forEach(value -> sb2.append((char) value));

        int r = sb1.compareTo(sb2);
        if (r < 0) {
            return -1;
        }
        if (r > 0) {
            return 1;
        }

        return 0;
    }

}
