package codewars.sum.arrays;

// https://www.codewars.com/kata/53dc54212259ed3d4f00071c/train/java

public class SumArray {

    public static void main(String[] args) {
        double[] a = {};
        double result = sum(a);
        System.out.println(result);
    }

    public static double sum(double[] numbers) {
        double sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return sum;
    }


}
