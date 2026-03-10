package stepik.binary.localmax;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Исследовательская задача «Локальный максимум»
Локальный максимум в массиве - это элемент, который строго больше своих соседей.
Найдите индекс любого из локальных максимумов в массиве.

Формат входных данных
Дан массив целых чисел размера

n (1 ≤ n < 10^6), элементы которого находятся в диапазоне от
− 2^31 до 2^31
 (индексирование начинается с нуля). Массив может быть считан с консоли, файла или задан при помощи случайной генерации. Соседние элементы массива всегда различны.

Для первого и последнего элемента массива положим, что значение недостающего соседа равно ∞
 (то есть значению, которое меньше любого возможного значения массива).

Формат выходных данных
Выведите одно число - индекс любого из локальных максимумов в массиве.
 */
public class Main {

    public static int solution1(String nums) {

        int[] arr = Arrays.stream(nums.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                return i;
            }
        }

        return -1;
    }

    private static void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        System.out.println("solution1");
        testing(solution1("2 4 7 0 5 9"), 2);
        testing(solution1("34 455 55 55 44 22"), 1);
        testing(solution1("4 -57 2 4 5 1 6 5"), 4);
        testing(solution1("4 -57 2 24 55 111 163 5"), 6);
        testing(solution1("-4 -57 -2 24 55 -111 -163 5"), 4);

    }


}
