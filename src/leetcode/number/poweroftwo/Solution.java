package leetcode.number.poweroftwo;

// 231. Power of Two
// https://leetcode.com/problems/power-of-two/description/?envType=daily-question&envId=2024-02-19
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {

        int n = 32;

        boolean result = isPowerOfTwo(n);

        System.out.println(n + ": " + (result ? "true" : false));

    }

    public boolean isPowerOfTwo(int n) {
        for (int i = 0; i < 31; i++) {
            if (Math.pow(2, i) == n) {
                return true;
            }
        }
        return false;
    }


}
