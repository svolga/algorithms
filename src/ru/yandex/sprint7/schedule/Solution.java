package ru.yandex.sprint7.schedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

// B. Расписание
// https://contest.yandex.ru/contest/25596/problems/B/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
/*

        double dbl = 10;
        BigDecimal bd = BigDecimal.valueOf(dbl);


        System.out.println(BigDecimal.valueOf(dbl).stripTrailingZeros().toPlainString());
*/

    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int count = Integer.parseInt(reader.readLine());
            List<Lesson> lessons = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                StringTokenizer stz = new StringTokenizer(reader.readLine());
                lessons.add(new Lesson(
                        Double.parseDouble(stz.nextToken()),
                        Double.parseDouble(stz.nextToken())
                ));
            }

            List<Lesson> result = getSchedule(lessons);

//            System.out.println(result);

            print(result);
        }

/*
       int count = 5;

        List<Lesson> lessons = new ArrayList<>();
        lessons.add(new Lesson(9, 10));
        lessons.add(new Lesson(9.3, 10.3));
        lessons.add(new Lesson(10, 11));
        lessons.add(new Lesson(10.3, 11.3));
        lessons.add(new Lesson(11, 12));

        List<Lesson> result = getSchedule(lessons);

        System.out.println(result);
 */
/*
        int count = 7;

        List<Lesson> lessons = new ArrayList<>();
        lessons.add(new Lesson(19, 19));
        lessons.add(new Lesson(7, 14));
        lessons.add(new Lesson(12, 14));
        lessons.add(new Lesson(8, 22));
        lessons.add(new Lesson(22, 23));
        lessons.add(new Lesson(5, 21));
        lessons.add(new Lesson(9, 23));

        List<Lesson> result = getSchedule(lessons);
        print(result);
*/
    }

    private void print(List<Lesson> lessons) {
        StringBuilder sb = new StringBuilder();
        sb.append(lessons.size()).append(System.lineSeparator());

        for (Lesson lesson : lessons) {
            sb.append(BigDecimal.valueOf(lesson.getStart()).stripTrailingZeros().toPlainString())
                    .append(" ").append(BigDecimal.valueOf(lesson.getEnd()).stripTrailingZeros().toPlainString())
                    .append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private List<Lesson> getSchedule(List<Lesson> lessons) {

        List<Lesson> result = new ArrayList<>();

        lessons.sort((o1, o2) -> {
                    if (o1.getEnd() == o2.getEnd()) {
                        return Double.compare(o1.getStart(), o2.getStart());
                    }
                    return Double.compare(o1.getEnd(), o2.getEnd());
                }
        );

        Lesson prev = new Lesson(0, 0);
        for (Lesson cur : lessons) {
            if (prev.getEnd() <= cur.getStart()) {
                prev = cur;
                result.add(prev);
            }
        }
        return result;
    }
}

class Lesson {
    private final Double start;
    private final Double end;

    public Lesson(double start, double end) {
        this.start = start;
        this.end = end;
    }

    public double getStart() {
        return start;
    }

    public double getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lesson)) return false;
        Lesson lesson = (Lesson) o;
        return Double.compare(lesson.getStart(), getStart()) == 0 && Double.compare(lesson.getEnd(), getEnd()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStart(), getEnd());
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
