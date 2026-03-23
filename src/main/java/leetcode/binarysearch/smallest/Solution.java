package leetcode.binarysearch.smallest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
744. Find Smallest Letter Greater Than Target
https://leetcode.com/problems/find-smallest-letter-greater-than-target/description/
 */
public class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        int left = 0;
        int right = letters.length - 1;

        if (target >= letters[right]) {
            return letters[0];
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return letters[left];

    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
//        testing(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'a'), 'c');
        testing(nextGreatestLetter(new char[]{'c', 'f', 'j'}, 'c'), 'f');
//        testing(nextGreatestLetter(new char[]{'x', 'x', 'y', 'y'}, 'z'), 'x');
    }

}
