package leetcode.array.maximum;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


/*
624. Maximum Distance in Arrays
https://leetcode.com/problems/maximum-distance-in-arrays/description/
 */

public class Solution {

    public int maxDistance(List<List<Integer>> arrays) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < arrays.size() - 1; i++) {
            List<Integer> list = arrays.get(i);
            List<Integer> listPrev = arrays.get(i-1);

            min = Math.min(min, list.get(0));
            max = Math.max(max, listPrev.get(list.size() - 1));
        }
        return max - min;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {

        List<List<Integer>> arrays = new ArrayList<>();


        arrays.add(List.of(1,2,3));
        arrays.add(List.of(4,5));
        arrays.add(List.of(1,2,3));
        testing(maxDistance(arrays), 4);



/*
        arrays.add(List.of(1,2,3,4));
        arrays.add(List.of(0,3,6,8));
        arrays.add(List.of(99,102,200));
        arrays.add(List.of(2,5,9,18));
        arrays.add(List.of(44,45,46,47));

        testing(maxDistance(arrays), 200);*/





/*

        arrays.add(List.of(1));
        arrays.add(List.of(2));
        testing(maxDistance(arrays), 1);
*/


    }

}
