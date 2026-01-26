package codewars.find.aximum.and.minimum.values;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Find Maximum and Minimum Values of a List
// https://www.codewars.com/kata/577a98a6ae28071780000989/solutions/java

public class Kata {

    public int min(int[] list) {

        int min = list[0];
        for (int i = 1; i < list.length; i++) {
            min = Math.min(min, list[i]);
        }
        return min;
    }

    public int max(int[] list) {
        int max = list[0];
        for (int i = 1; i < list.length; i++) {
            max = Math.max(max, list[i]);
        }
        return max;
    }

    @Test
    public void testExamples() {
        assertEquals(-110, min(new int[]{-52, 56, 30, 29, -54, 0, -110}));
        assertEquals(0, min(new int[]{42, 54, 65, 87, 0}));
        assertEquals(566, max(new int[]{4,6,2,1,9,63,-134,566}));
        assertEquals(5, max(new int[]{5}));
    }

}
