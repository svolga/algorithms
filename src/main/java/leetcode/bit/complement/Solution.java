package leetcode.bit.complement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Solution {

    public int bitwiseComplement(int n) {
        // !!!Should solve
        return 0;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
//        testing(getContition(new int[]{28, 28, 28}), 3);
        testing(bitwiseComplement(10), 2);
    }
}
