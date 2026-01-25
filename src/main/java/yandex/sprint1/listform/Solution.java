package java.yandex.sprint1.listform;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// K. Списочная форма
// https://contest.yandex.ru/contest/22449/problems/K/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            String num1 = reader.readLine();
            String num2 = reader.readLine();

            num1 = num1.replace(" ","");

            int diff = num2.length() - num1.length();
            if (diff != 0) {
                if (diff > 0) {
                    num1 = "0".repeat(diff) + num1;
                } else {
                    num2 = "0".repeat(-1 * diff) + num2;
                }
            }

            StringBuilder sb = sum(num1, num2);
            String res = sb.toString().trim();
            System.out.println(res);
        }
    }

    private StringBuilder sum(String num1, String num2) {
        char[] charNum1 = num1.toCharArray();
        char[] charNum2 = num2.toCharArray();
        int lenNum1 = charNum1.length - 1;
        int lenNum2 = charNum2.length - 1;

        int rest = 0;

        StringBuilder sb = new StringBuilder();
        while (lenNum1 >= 0 || lenNum2 >= 0) {
            int number1 = charNum1[lenNum1] - '0';
            int number2 = charNum2[lenNum2] - '0';

            int sum = number1 + number2 + rest;
            rest = sum / 10;
            sb.append(sum % 10+" ");

            lenNum1--;
            lenNum2--;
        }

        if (rest > 0) {
            sb.append(rest+" ");
        }

        return sb.reverse();
    }

}
