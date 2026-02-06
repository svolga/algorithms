package codewars.growth.population;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Growth of a Population
// https://www.codewars.com/kata/563b662a59afc2b5120000c6/train/java

public class Main {

    public static void main(String[] args) {

    }

    public static int nbYear(int p0, double percent, int aug, int p) {
        int year = 0;
        int current = p0;

        while (current < p) {
            current += (int)(current * 0.01 * percent) + aug;
            year++;

        }
        return year;
    }

    private static void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        System.out.println("Fixed Tests: nbYear");
        testing(nbYear(1500, 5, 100, 5000), 15);
        testing(nbYear(1500000, 2.5, 10000, 2000000), 10);
        testing(nbYear(1500000, 0.25, 1000, 2000000), 94);
    }

}
