package leetcode.greedy.twocity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
1029. Two City Scheduling
https://leetcode.com/problems/two-city-scheduling/description/
 */
public class Solution {

    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, (a, b) -> Integer.compare(a[1] - a[0], b[1] - b[0]));
        int n = costs.length / 2, res = 0;

        for (int i = 0; i < n; i++) {
            res += costs[i][1] + costs[i + n][0];
        }
        return res;
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        testing(twoCitySchedCost(new int[][]{{10, 20}, {30, 200}, {400, 50}, {30, 20}}), 110);
//        testing(twoCitySchedCost(new int[][]{{259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}}), 1859);
    }

}
