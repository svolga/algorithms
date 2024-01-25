package ru.yandex.sprint3.clumb;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// N. Клумбы
// https://contest.yandex.ru/contest/23638/problems/N/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            int count = Integer.parseInt(reader.readLine());
            List<Interval> list = new ArrayList<>();
            for (int i=0; i<count; i++){
                StringTokenizer stz = new StringTokenizer(reader.readLine());
                list.add(new Interval(
                        Integer.parseInt(stz.nextToken()),
                        Integer.parseInt(stz.nextToken())
                ));
            }

            List<Interval> res = merge(list);

            StringBuilder sb = new StringBuilder();
            for (Interval re : res) {
                sb.append(re.getStart()).append(" ").append(re.getEnd()).append(System.lineSeparator());
            }
            System.out.println(sb);
        }

    }

    public List<Interval>  merge(List<Interval> intervals) {
        Comparator<Interval> intComparator = new Comparator<>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.getStart() - o2.getStart();
            }
        };

        intervals.sort(intComparator);

        List<Interval> res = new ArrayList<>();
        Interval curr = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).getStart() <= curr.getEnd()) {
                curr = new Interval(
                        Math.min(curr.getStart(), intervals.get(i).getStart()),
                        Math.max(curr.getEnd(), intervals.get(i).getEnd())
                );
            } else {
                res.add(curr);
                curr = intervals.get(i);
            }
        }
        res.add(curr);
        return res;
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