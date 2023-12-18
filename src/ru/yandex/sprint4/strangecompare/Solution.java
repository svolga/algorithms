package ru.yandex.sprint4.strangecompare;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// H. Странное сравнение
// https://contest.yandex.ru/contest/23991/problems/H/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
/*
            String str1 = "agg";
            String str2 = "xda";
*/

/*
aba
xxx
NO
 */

/*
mxyskaoghi
qodfrgmslc
YES
 */
            String str1 = reader.readLine();
            String str2 = reader.readLine();

            System.out.println(isEqual(str1, str2) ? "YES" : "NO");
        }
    }

    private boolean isEqual(String str1, String str2){
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();

        if (chars1.length != chars2.length) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> mapBack = new HashMap<>();

        for (int i = 0; i < str1.length(); i++) {

            Character key = str1.charAt(i);
            Character value = str2.charAt(i);
            Character savedValue = map.getOrDefault(key, value);

            if (value != savedValue) {
                return false;
            }

            Character savedKey = mapBack.getOrDefault(value, key);
            if (key != savedKey) {
                return false;
            }

            map.put(key, savedValue);
            mapBack.put(savedValue, key);
        }

        return true;
    }

}
