package leetcode.hashtable.romtointeger;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
13. Roman to Integer
https://leetcode.com/problems/roman-to-integer/description/?envType=problem-list-v2&envId=hash-table
*/

public class Solution {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            Character cur = s.charAt(i);
            Character next = i + 1 < s.length() ? s.charAt(i + 1) : null;

            int curVal = map.get(cur);
            int nextVal = map.getOrDefault(next, 0);

            if (curVal < nextVal) {
                sum += nextVal - curVal;
                i += 2;
            } else {
                sum += curVal;
                i +=1;
            }
        }

        return sum;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(romanToInt("III"), 3);
        testing(romanToInt("MCMXCIV"), 1994);
    }

}
