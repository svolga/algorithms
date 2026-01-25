package java.yandex.sprint3.sort.bignumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

// H. Большое число
// https://contest.yandex.ru/contest/23638/problems/H/
public class Solution {

    public static void main(String[] args) throws IOException {
        new Solution().run(args);
    }

    static void insertionSortByComparator(int[] array, Comparator<Integer> less) {
        for (int i = 1; i < array.length; i++) {
            int item_to_insert = array[i];
            int j = i;
            // заменим сравнение item_to_insert < array[j-1] на компаратор less
            while (j > 0 && less.compare(item_to_insert, array[j - 1]) < 0) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = item_to_insert;
        }
    }

    private void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    private int compare(String card1, String card2) {
        int length1 = card1.length();
        int length2 = card2.length();
        int len = length1 == length2 ? length1 : length1 + length2;
        for (int i = 0; i < len; i++) {
            char ac = i < length1 ? card1.charAt(i) : card2.charAt(i - length1);
            char bc = i < length2 ? card2.charAt(i) : card1.charAt(i - length2);
            if (ac == bc) continue;
            return ac < bc ? -1 : 1;
        }
        return 0;
    }

    private void run(String[] args) throws IOException {
        int[] numbers = getInput();
        Comparator<Integer> comparator = (card1, card2) -> {
            String strCard1 = card1.toString();
            String strCard2 = card2.toString();
            if (strCard1.length() == strCard2.length()) {
                return Integer.compare(Integer.parseInt(strCard2), Integer.parseInt(strCard1));
            } else {
                String strCard12 = strCard1 + strCard2;
                String strCard21 = strCard2 + strCard1;
                return Integer.compare(Integer.parseInt(strCard21), Integer.parseInt(strCard12));
            }
        };

        insertionSortByComparator(numbers, comparator);

        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number);
        }
        System.out.println(sb);
    }

    private int[] getInput() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int length = Integer.parseInt(reader.readLine());
            String str = reader.readLine();

            int[] numbers = new int[length];
            StringTokenizer stringTokenizer = new StringTokenizer(str);
            for (int i = 0; i < length; i++) {
                numbers[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            return numbers;
        }
    }

}
