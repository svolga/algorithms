package leetcode.greedy.mergeintervals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/*
56. Merge Intervals
https://leetcode.com/problems/merge-intervals/description/
 */

public class Solution {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> output = new ArrayList<>();
        output.add(intervals[0]);

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            int lastend = output.get(output.size() - 1)[1];

            if (start <= lastend) {
                output.get(output.size() - 1)[1] = Math.max(lastend, end);
            }
            else{
                output.add(new int[]{start, end});
            }
        }

        return output.toArray(new int[output.size()][]);
    }

    private void testing(int[][] actual, int[][] expected) {
        assertArrayEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}),
                new int[][]{{1, 6}, {8, 10}, {15, 18}}
        );
        testing(merge(new int[][]{{1, 4}, {4, 5}}),
                new int[][]{{1, 5}}

        );
        testing(merge(new int[][]{{4, 7}, {1, 4}}), new int[][]{{1, 7}});
    }

}
