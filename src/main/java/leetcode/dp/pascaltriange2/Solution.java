package leetcode.dp.pascaltriange2;

import java.util.ArrayList;
import java.util.List;

// 119. Pascal's Triangle II
// https://leetcode.com/problems/pascals-triangle-ii/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int row = 7;
        System.out.println(getRow(row));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex);
        list.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--) {
                list.set(j, list.get(j - 1) + list.get(j));
            }
            list.add(1);
        }
        return list;
    }


}
