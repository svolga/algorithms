package leetcode.dp.stairs;

import java.util.ArrayList;
import java.util.List;

// 70. Climbing Stairs
// https://leetcode.com/problems/climbing-stairs/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);

    }

    private void run(String[] args) {
        int n = 4;
        int res = climbStairs(n);
        System.out.println(n + ": " + res);
    }

    public int climbStairs(int n) {
        if (n == 0 || n == 1){
            return n;
        }

        List<Integer> list = new ArrayList<>();
        list.add(0, 1);
        list.add(1, 1);

        for (int i = 2; i <= n; ++i) {
            list.add(i, list.get(i - 1) + list.get(i - 2) );
        }
        return list.get(n);
    }


}
