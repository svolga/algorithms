package java.yandex.sprint4.breakhash;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

// B. Сломай меня
// https://contest.yandex.ru/contest/23991/problems/B/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private String getRandomString(int length) {
        String chars = "abcdefjhijklmnopqrstuvwxyz";

        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(ThreadLocalRandom.current().nextInt(0, chars.length())));
        }
        return sb.toString();
    }

    private void run(String[] args) {

        int a = 1000;
        int m = 123_987_123;

        int len1 = 20;
// khjnxoojcx --> yucmjbdzjk
// zhijviuehkuudsshxxjw --> iycpazcylxdfjploynzc
        int count = 100_000;
        Map<Long, String> map = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String str = getRandomString(len1);
            long h = hash(str, a, m);
            if (map.containsKey(h) && !str.equals(map.get(h))) {
                System.out.println("FOUND: hash " + h + " Строки: " + map.get(h) + " --> " + str);
//                break;
            } else {
                map.put(h, str);
            }
        }
    }

    private long hash(String str, int a, int m) {
        long h = 0;
        for (int i = 0; i < str.length(); i++) {
            h = (h * a + (int) str.charAt(i)) % m;
        }
        return h;
    }
}
