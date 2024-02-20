package leetcode.strings.firstunique;

import java.util.HashMap;
import java.util.Map;

// 387. First Unique Character in a String
// https://leetcode.com/problems/first-unique-character-in-a-string/description/?envType=daily-question&envId=2024-02-05
public class Solution {
    public static void main(String[] args) {
        new Solution().run(args);

    }

    private void run(String[] args) {
        String s = "leetcode";
        int pos = firstUniqChar(s);

        System.out.println(pos);
    }

    public int firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (map.get(ch) == 1) {
                return i;
            }
        }

        return -1;
    }
}
