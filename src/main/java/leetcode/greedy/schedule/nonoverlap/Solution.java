package leetcode.greedy.schedule.nonoverlap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
435. Non-overlapping Intervals
https://leetcode.com/problems/non-overlapping-intervals/description/
 */
public class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[1], o2[1]));

        int prevEnd = intervals[0][1];
        int res = 0;
        int N = intervals.length;
        for (int i = 1; i < N; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (start < prevEnd) {
                res++;
            } else {
                prevEnd = end;
            }
        }

        return res;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}), 1);
        testing(eraseOverlapIntervals(new int[][]{{1,2},{1,2},{1,2}}), 2);
        testing(eraseOverlapIntervals(new int[][]{{1,2},{2,3}}), 0);
    }
}
