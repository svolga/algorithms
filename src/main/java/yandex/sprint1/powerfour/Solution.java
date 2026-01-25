package java.yandex.sprint1.powerfour;

// I. Степень четырёх
// https://contest.yandex.ru/contest/22449/problems/I/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int value = Integer.parseInt(reader.readLine());
            boolean isValid = isPower(value);
            System.out.println(isValid ? "True" : "False");
        }
    }

    private boolean isPower(int value) {

        int result = 1;
        int j = 0;
        while (result < value) {
            result *= 4;
            j++;
        }
        return result == value;
    }

}
