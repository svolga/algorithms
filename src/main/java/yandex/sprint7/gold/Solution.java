package java.yandex.sprint7.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

// C. Золотая лихорадка
// https://contest.yandex.ru/contest/25596/problems/C/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    private void run(String[] args) throws IOException {
/*
        int totalWeight = 10;
        int count = 3;

        List<Gold> golds = new ArrayList<>();

        golds.add(new Gold(8, 1));
        golds.add(new Gold(2, 10));
        golds.add(new Gold(4, 5));

        System.out.println(golds);
 */

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int totalWeight = Integer.parseInt(reader.readLine());
            int count = Integer.parseInt(reader.readLine());
            List<Gold> golds = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                StringTokenizer stz = new StringTokenizer(reader.readLine());
                golds.add(
                        new Gold(
                                Integer.parseInt(stz.nextToken()),
                                Integer.parseInt(stz.nextToken())
                        ));
            }

            long result = getMaxSum(golds, totalWeight);
            System.out.println(result);
        }
    }

    private long getMaxSum(List<Gold> golds, int capacity) {

        Comparator<Gold> comparator = (o1, o2) -> (int) o2.getPrice() - (int) o1.getPrice();

        golds.sort(comparator);
        long result = 0;
        for (Gold gold : golds) {
            if (capacity == 0) {
                break;
            }
            long price = gold.getPrice();
            long maxWeigth = Math.min(capacity, gold.getWeight());
            result += price * maxWeigth;
            capacity -= maxWeigth;
        }

        return result;
    }
}


class Gold {
    private final long weight;
    private final long price;

    public Gold(long price, long weight) {
        this.price = price;
        this.weight = weight;
    }

    public long getWeight() {
        return weight;
    }

    public long getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Gold{" +
                "weight=" + weight +
                ", price=" + price +
                '}';
    }
}
