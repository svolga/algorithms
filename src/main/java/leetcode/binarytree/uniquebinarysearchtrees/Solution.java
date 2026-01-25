package java.leetcode.binarytree.uniquebinarysearchtrees;

import java.math.BigInteger;

// 96. Unique Binary Search Trees
// https://leetcode.com/problems/unique-binary-search-trees/description/
//  количество различных BST- это каталонское число
// F(n) = (2*n)!/((n+1)!*n!)
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int n = 4;
        System.out.println(n + ": " + numTrees(n));
    }

    public int numTrees(int n) {
        BigInteger part1 = factorial(2 * n);
        BigInteger part2 = factorial(n + 1).multiply(factorial(n));
        return part1.divide(part2).intValue();
    }

    private BigInteger factorial(int value) {
        BigInteger result = BigInteger.valueOf(1);
        for (int i = value; i > 0; i--) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }


}
