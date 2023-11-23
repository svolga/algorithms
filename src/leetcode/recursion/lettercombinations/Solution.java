package leetcode.recursion.lettercombinations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args){
        List<String> result = letterCombinations("23");
        System.out.println(result);
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (!digits.isEmpty()) {
            Map<Integer, String> map = Map.of(
                    2, "abc",
                    3, "def",
                    4, "ghi",
                    5, "jkl",
                    6, "mno",
                    7, "pqrs",
                    8, "tuv",
                    9, "wxyz");

            generateRow("", 0, digits, map, result);
        }
        return result;
    }

    private void generateRow(String currentValue, int keyPosition, String keys, Map<Integer, String> map, List<String> result) {
        if (currentValue.length() == keys.length()) {
            result.add(currentValue);
            return;
        } else {
            int key = keys.charAt(keyPosition) - '0';
            String str = map.get(key);
            for (int j = 0; j < str.length(); j++) {
                String letter = Character.toString(str.charAt(j));
                generateRow(currentValue + letter, keyPosition + 1, keys, map, result);
            }
        }
    }

}