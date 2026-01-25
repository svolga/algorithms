package java.yandex.sprint8.oftenword;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

// F. Частое слово
// https://contest.yandex.ru/contest/26131/problems/F/
public class Solution {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int count  = Integer.parseInt(reader.readLine());
            List<String> list = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                list.add(reader.readLine());
            }
/*
            List<String> list = List.of("ciwlaxtnhhrnenw", "ciwnvsuni", "ciwaxeujmsmvpojqjkxk", "ciwnvsuni",
                    "ciwnvsuni", "ciwuxlkecnofovq", "ciwuxlkecnofovq", "ciwodramivid", "ciwlaxtnhhrnenw", "ciwnvsuni");
*/

            Comparator<Item> comparator = new Comparator<Item>() {
                @Override
                public int compare(Item o1, Item o2) {
                    if (o1.getCount() == o2.getCount()) {
                        return o1.getWord().compareTo(o2.getWord());
                    }
                    return o2.getCount().compareTo(o1.getCount());
                }
            };

            Map<String, Item> map = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                Item cur = map.get(list.get(i));
                if (cur == null) {
                    cur = new Item(list.get(i), 0);
                }

                cur.setCount(cur.getCount() + 1);
                map.put(list.get(i), cur);
            }

            List<Item> ls = map.values().stream().sorted(comparator).limit(1).collect(Collectors.toCollection(ArrayList::new));
            if (ls.size() == 1){
                System.out.println(ls.get(0).getWord());
            }

        }
    }
}

class Item {
    private String word;
    private Integer count;

    public Item(String word, Integer count) {
        this.word = word;
        this.count = count;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Item{" +
                "word='" + word + '\'' +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(getWord(), item.getWord()) && Objects.equals(count, item.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWord(), count);
    }
}