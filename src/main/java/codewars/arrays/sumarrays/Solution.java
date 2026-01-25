package java.codewars.arrays.sumarrays;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        double dbl = sum(new double[] {1, 2, 3});
        System.out.println(dbl);

    }

    public static double sum(double[] numbers) {
        return Arrays.stream(numbers).sum();
    }

}
