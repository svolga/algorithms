package stepik.recurse.revision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
https://stepik.org/lesson/1073852/step/13?unit=1083924
Этот алгоритм вычисляет какую-то величину, однако время его работы экспоненциально от n.
К тому же, построить его дерево рекурсии не так просто:
аргумент calculate(initial_value % n) ведет себя недостаточно закономерным образом.

Подумайте, как можно переписать этот алгоритм так,
чтобы вычисление величины calculate(n) происходило за O(n).
 */
public class Main {

    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int res = calculate(n);
        System.out.println(res);
    }

    private static int getCache(int key) {
        if (!map.containsKey(key)) {
            map.put(key, calculate(key));
        }
        return map.get(key);
    }

    private static int calculate(int n) {

        if (n <= 1) {
            return 1;
        }

        int initial_value = (n * n) / 3 + getCache(n - 2);
        while (initial_value % 2 == 0) {
            initial_value = initial_value / 2;
        }

        initial_value += getCache(2 * n / 3);
        int value = getCache(initial_value % n);
        return value + getCache(n / 2) + n;
    }

}
