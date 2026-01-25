package java.leetcode.number.uniquenumber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// 1207. Unique Number of Occurrences
// https://leetcode.com/problems/unique-number-of-occurrences/description/?envType=daily-question&envId=2024-01-17
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        boolean res = uniqueOccurrences(arr);

        System.out.println(res);
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> targetSet = new HashSet<>(map.values());
        return targetSet.size() == map.size();
    }

}
