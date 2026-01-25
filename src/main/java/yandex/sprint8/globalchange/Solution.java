package java.yandex.sprint8.globalchange;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// H. Глобальная замена
// https://contest.yandex.ru/contest/26131/problems/H/
public class Solution {
    public static void main(String[] args) throws IOException {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String text = reader.readLine();
            String pattern = reader.readLine();
            String replace = reader.readLine();

/*
            String text = "aaa";
            String pattern = "a";
            String replace = "ab";
*/

            String newText = text.replaceAll(pattern, replace);
            System.out.println(newText);
        }
    }

}
