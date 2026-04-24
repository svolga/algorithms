package stepik.dp.base;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*
Материалы лекции
https://stepik.org/lesson/1110492/step/8?unit=1121859
 */
public class Main {

    // Вычисление n-го числа фибоначчи
    public int getFibonacci(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Кузнечик
    public int getGrig(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // Платная лестница
/*
    Мальчик подошел к платной лестнице. Чтобы наступить на любую ступеньку,
    нужно заплатить указанную на ней сумму. Мальчик умеет перешагивать на следующую
    ступеньку, либо перепрыгивать через ступеньку. Требуется узнать, какая наименьшая
    сумма понадобится мальчику, чтобы добраться до верхней ступеньки.
    Решение за O(n):
*/
    public int getStep(int[] costs, int n) {
        int[] dp = new int[n];
        dp[0] = costs[0];
        dp[1] = costs[1];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + costs[i];
        }

        return dp[n - 1];
    }

    /*
    Последовательность из 0 и 1
    Требуется подсчитать количество последовательностей длины
    N, состоящих из 0 и 1, в которых никакие две единицы не стоят рядом. Решение за O(N):
    */
    public int getSequence(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        dp[1] = 2;
        dp[2] = 3;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    /*
    Калькулятор
    Имеется калькулятор, который выполняет три операции:

    Прибавить к числу X единицу.
     Умножить число X на 2.
    Умножить число X на 3.
    Определите, какое наименьшее число операций необходимо для того, чтобы получить из числа
    1 заданное число N. Решение за O(N):
     */
    public int getCalc(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 0);
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= n; i++) {

            if (i % 2 == 0 && i % 3 == 0) {
                dp[i] = Math.min(dp[i - 1], Math.min(dp[i / 2], dp[i / 3])) + 1;
            } else if (i % 2 == 0 && i % 3 != 0) {
                dp[i] = Math.min(dp[i - 1], dp[i / 2]) + 1;
            } else if (i % 2 != 0 && i % 3 == 0) {
                dp[i] = Math.min(dp[i - 1], dp[i / 3]) + 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }

        return dp[n];
    }

    private void testing(int actual, int expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void testCalc() {
        testing(getCalc(5), 3);
        testing(getCalc(32718), 17);
    }

    @Test
    public void testSequence() {
        testing(getSequence(3), 5);
    }

    @Test
    public void testStep() {
        testing(getStep(new int[]{1, 3, 1}, 3), 2);
    }

    @Test
    public void testGrig() {
        testing(getGrig(5), 8);
    }

    @Test
    public void testFibonacci() {
        testing(getFibonacci(4), 3);
        testing(getFibonacci(7), 13);
        testing(getFibonacci(10), 55);
    }


}
