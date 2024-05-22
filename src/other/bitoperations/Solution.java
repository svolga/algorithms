package other.bitoperations;

// Битовые операции
public class Solution {
    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
//        testEven();
//        testChange();
//        testBitNot();
        testAddNUms();
    }

    // Сложение чисел без арифм. операций
    private void testAddNUms() {
        int x1 = 59;
        int x2 = 13;

        // Сначала XOR
        int res = x1 ^ x2;
        System.out.println(String.format("%d (%s) XOR %d (%s) = %d (%s)",
                x1, Integer.toBinaryString(x1),
                x2, Integer.toBinaryString(x2),
                res, Integer.toBinaryString(res)));

        // Теперь найдем какие биты нужно переносить с помощью &
        int div = x1 & x2;
        System.out.println(String.format("%d (%s) & %d (%s) = %d (%s)",
                x1, Integer.toBinaryString(x1),
                x2, Integer.toBinaryString(x2),
                div, Integer.toBinaryString(div)));

        // Сложить то, что получилось тем же способом



    }


    // Побитовое НЕ
    private void testBitNot() {
        int n = 1;
        int res = ~(n);
        System.out.println(String.format("Не для %d (%s) Равно = %d (%s)", n, Integer.toBinaryString(n), res, Integer.toBinaryString(res)));
    }

    private void testChange() {
        int i = 3;
        long x = 59;
        long y = changeBit(i, x);
        System.out.println("Было " + x + ", сдвинули на " + i + ", Результат = " + y);
    }

    // Изменить n-ый бит числа (сдвинуть + xor)
    private long changeBit(int n, long num) {
        return num ^ (1 << n - 1);
    }

    // Четность n-го бита числа (сдвинуть + И)
    private boolean isNbitEven(int n, long num) {
        return (num & (1 << n - 1)) == 0 ? true : false;
    }

    // Число четное (И последнего бита)
    private boolean isEven(long num) {
        return (num & 1) == 1 ? false : true;
    }

    private void testEven() {
        int a = 3;
        System.out.println("a << 1 = " + (a << 1));
        System.out.println("a >> 1 = " + (a >> 1));

        int x = 555;
        System.out.println("x << 1 = " + (x << 1));
        System.out.println("x >> 1 = " + (x >> 1));

        // Четность числа
        x = 2;
        System.out.println("Число " + x + " = " + (isEven(x) ? "Четно" : "Нечетно"));
        x = 3;
        System.out.println("Число " + x + " = " + (isEven(x) ? "Четно" : "Нечетно"));
        x = 5;
        System.out.println("Второй бит числа " + x + " = " + (isNbitEven(2, x) ? "Четно" : "Нечетно"));

    }

}
