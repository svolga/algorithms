package java.leetcode.number.singlenumber;

// 136. Single Number
// https://leetcode.com/problems/single-number/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
//        int[] nums = {2, 2, 1};
//        int[] nums = {1};
        int result = singleNumber(nums);
        System.out.println("result = " + result);
    }

    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            System.out.println(num + " ^ " + xor + " = " + (xor ^ num));
            xor = xor ^ num;
        }
        return xor;
/*
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return map.entrySet()
                .stream()
                .filter(m -> m.getValue() == 1)
                .mapToInt(value -> value.getKey())
                .findFirst()
                .getAsInt();
 */
/*
        xor
        0 0 => 0
        0 1 => 1
        1 0 => 1
        1 1 => 0
 */

    }

}
