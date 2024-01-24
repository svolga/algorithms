package ru.yandex.sprint3.conference;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

// I. Любители конференций
// https://contest.yandex.ru/contest/23638/problems/I/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int count = Integer.parseInt(reader.readLine());
            Integer[] univers = new Integer[count];
            StringTokenizer stz = new StringTokenizer(reader.readLine());
            for (int i = 0; i < count; i++) {
                univers[i] = Integer.parseInt(stz.nextToken());
            }

            int limit = Integer.parseInt(reader.readLine());

/*
            int limit = 1;
            Integer[] univers = {1, 1, 1, 2, 2, 3};
*/

            StringBuilder sb = getUnivers(univers, limit);
            System.out.println(sb);
        }
    }

    private StringBuilder getUnivers(Integer[] univers, int limit) {

        Map<Integer, Integer> map = new HashMap<>();
        for (Integer univer : univers) {
            map.put(univer, map.getOrDefault(univer, 0) + 1);
        }

        Set<Vuz> setVuz = new TreeSet();
        map.forEach((id, count) -> {
            setVuz.add(new Vuz(id, count));
        });

        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Vuz vuz : setVuz) {
            if (i > limit) {
                break;
            }
            sb.append(vuz.id).append(" ");
            i++;
        }

        return sb;
    }

}


class Vuz implements Comparable<Vuz> {
    Integer id;
    Integer count;

    public Vuz(Integer id, Integer count) {
        this.id = id;
        this.count = count;
    }

    @Override
    public int compareTo(Vuz o) {
        if (this.count == o.count) {
            return this.id.compareTo(o.id);
        }
        return o.count.compareTo(this.count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vuz)) return false;
        Vuz vuz = (Vuz) o;
        return Objects.equals(id, vuz.id) && Objects.equals(count, vuz.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, count);
    }

    @Override
    public String toString() {
        return "Vuz{" +
                "id=" + id +
                ", count=" + count +
                '}';
    }
}
