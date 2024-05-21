package leetcode.array.bitchar;

// 717. 1-bit and 2-bit Characters
// https://leetcode.com/problems/1-bit-and-2-bit-characters/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {

        int[] bits = {0};
        System.out.println(isOneBitCharacter(bits));
    }

    public boolean isOneBitCharacter(int[] bits) {

        if (bits[bits.length - 1] == 1) {
            return false;
        }

        int i = 0;
        boolean mask = false;
        while (i < bits.length) {
            if (bits[i] == 0) {
                i++;
                mask = true;
            } else {
                i += 2;
                mask = false;
            }
        }
        return mask;

    }

}
