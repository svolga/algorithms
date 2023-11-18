package ru.yandex.sprint3.recursion;

public class Binary {

    public static void main(String[] args) {
        new Binary().run(args);
    }

    private void run(String[] args) {
        int value = 4;
        String result = asBinaryString(value);
        System.out.println("in: " + value + "; out = " + result);
    }

    public String asBinaryString(int n) {
        if (n < 0) {
            return "-" + asBinaryString(-n);
        }
        if (n == 0 || n == 1) {
            return Integer.toString(n);
        }
        int lastDigit = n % 2;
        return asBinaryString(n / 2) + Integer.toString(lastDigit);
    }


}
