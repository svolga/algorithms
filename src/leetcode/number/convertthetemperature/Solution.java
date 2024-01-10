package leetcode.number.convertthetemperature;

import java.util.Arrays;

// 2469. Convert the Temperature
// https://leetcode.com/problems/convert-the-temperature/description/

public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
/*
Kelvin = Celsius + 273.15
Fahrenheit = Celsius * 1.80 + 32.00
 */
//        double celsius = 36.50;
        double celsius = 122.11;
        System.out.println("celsius = " + celsius);
        double[] ans = convertTemperature(celsius);
        System.out.println("res = "+ Arrays.toString(ans));
    }

    public double[] convertTemperature(double celsius) {
        double kelvin = celsius + 273.15;
        double fahrenheit = celsius * 1.80 + 32.00;
        return new double[]{kelvin, fahrenheit};
    }

}
