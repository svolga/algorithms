package ru.yandex.sprint5.differentbst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// I. Разные деревья поиска
// https://contest.yandex.ru/contest/24809/problems/I/
/*
Идея: https://www.baeldung.com/cs/calculate-number-different-bst
Количество различных деревьев BST (binary search tree) - каталонское число
вычисляется по формуле:

F(n) = n!/((n+1)!*n!)
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            long value = Integer.parseInt(reader.readLine());
            BigInteger bstCount = calculateBstCount(value);
            System.out.println(bstCount);
        }
    }

    private BigInteger calculateBstCount(long value) {
        BigInteger resultPart1 = factorial(2 * value);
        BigInteger resultPart2 = (factorial(value + 1)).multiply(factorial(value));
        BigInteger result = resultPart1.divide(resultPart2);
        return result;
    }

    private BigInteger factorial(long value) {
        BigInteger result = BigInteger.valueOf(1);
        for (long i = value; i > 0; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

}