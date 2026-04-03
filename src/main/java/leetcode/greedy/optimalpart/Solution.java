package leetcode.greedy.optimalpart;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
2405. Optimal Partition of String
https://leetcode.com/problems/optimal-partition-of-string/description/
 */
public class Solution {
    public int partitionString(String s) {

        Set<Character> set = new HashSet<>();

        int res = 1;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                    res++;
                    set.clear();
            }
            set.add(s.charAt(i));
        }

        return res;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(partitionString("abacaba"), 4);
//        testing(partitionString("ssssss"), 6);
    }

}
