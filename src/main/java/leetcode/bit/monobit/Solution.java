package leetcode.bit.monobit;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

// 3827. Count Monobit Integers
// https://leetcode.com/problems/count-monobit-integers/description/
public class Solution {

    int countMonobit(int n) {
// O = n*log(n)
        int count = 0;

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i <= n; i++) {
            String string = Integer.toBinaryString(i);
            map.clear();
            for (int j = 0; j < string.length(); j++) {
                Character c = string.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }

            if (map.getOrDefault('1', 0) > 0 &&
                map.getOrDefault('0', 0) > 0) {
                continue;
            }
            count++;
        }
        return count;

// O = log(n)
/*
        int count = 1;   // counts 0
        long curr = 1;

        while (curr <= n) {
            count++;
            curr = (curr << 1) | 1;
        }

        return count;
 */
    }

    private static void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    void test() {
        System.out.println("Fixed Tests: countMonobit");
        testing(countMonobit(1), 2);
        testing(countMonobit(4), 3);
    }

}
