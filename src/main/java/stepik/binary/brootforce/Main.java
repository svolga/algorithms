package stepik.binary.brootforce;

import org.junit.jupiter.api.Test;
/*
    Найти сумму двух максимальных чисел за O(N)
 */

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Main {

    private int getTwoMax(int[] array) {

        int max1 = 0;
        int max2 = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > max1) {
                max2 = max1;
                max1 = array[i];
            } else if (array[i] > max2) {
                max2 = array[i];
            }
        }
        return max1 + max2;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {

        testing(getTwoMax(new int[]{20, 10, 1, 5, 6, 20, 100, 99, 3}), 199);

    }

}
