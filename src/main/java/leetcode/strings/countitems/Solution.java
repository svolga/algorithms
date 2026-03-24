package leetcode.strings.countitems;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
1773. Count Items Matching a Rule
https://leetcode.com/problems/count-items-matching-a-rule/description/
 */
public class Solution {

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {

        Map<String, Integer> map = new HashMap<>();
        map.put("type", 0);
        map.put("color", 1);
        map.put("name", 2);
        int idx = map.get(ruleKey);

        long count = items.stream()
                .filter(list -> list.get(idx).equals(ruleValue))
                .count();

        return (int)count;
    }


    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
// items[i] = [typei, colori, namei]
        List<List<String>> items = List.of(
                List.of("phone", "blue", "pixel"),
                List.of("computer", "silver", "lenovo"),
                List.of("phone", "gold", "iphone")
        );

        testing(countMatches(items, "color", "silver"), 1);

    }


}
