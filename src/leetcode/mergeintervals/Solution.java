package leetcode.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// 56. Merge Intervals
// https://leetcode.com/problems/merge-intervals/description/
public class Solution {

    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int[][] m = {{1, 3}, {6, 10}, {15, 18}, {2, 8}};
//        int[][] m = {{1, 4}, {2, 3}};
        int[][] out = merge(m);
        System.out.println(out);
    }

    public int[][] merge(int[][] intervals) {
        Comparator<Interval> intComparator = new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.getStart() - o2.getStart();
            }
        };

        List<Interval> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int[] item = intervals[i];
            list.add(new Interval(item[0], item[1]));
        }
        list.sort(intComparator);

        List<Interval> res = new ArrayList<>();
        Interval curr = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getStart() <= curr.getEnd()) {
                curr = new Interval(
                        Math.min(curr.getStart(), list.get(i).getStart()),
                        Math.max(curr.getEnd(), list.get(i).getEnd())
                        );
            } else {
                res.add(curr);
                curr = list.get(i);
            }
        }
        res.add(curr);

        int[][] out = new int[res.size()][];
        for (int i = 0; i < res.size(); i++) {
            Interval interval = res.get(i);
            int[] item = {interval.getStart(), interval.getEnd()};
            out[i] = item;
        }

        return out;
    }

}


class Interval {
    private final int start;
    private final int end;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public Interval(int[] x) {
        this.start = x[0];
        this.end = x[1];
    }

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}