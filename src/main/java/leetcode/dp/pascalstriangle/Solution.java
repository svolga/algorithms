package java.leetcode.dp.pascalstriangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 118. Pascal's Triangle
// https://leetcode.com/problems/pascals-triangle/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int numRows = 5;
        List<List<Integer>> list = generate(numRows);
        System.out.println(list.toString());
    }

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            Integer[] arr = new Integer[i + 1];
            Arrays.fill(arr, 1);
            list.add(i, Arrays.asList(arr));
        }

        for (int i = 2; i < numRows; i++) {
            List<Integer> prev = list.get(i - 1);
            List<Integer> curr = list.get(i);
            for (int j = 1; j < i; j++) {
                curr.set(j, prev.get(j - 1) + prev.get(j));
            }
        }

        return list;
    }

}
