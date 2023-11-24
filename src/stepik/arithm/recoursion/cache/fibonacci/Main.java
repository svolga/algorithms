package stepik.arithm.recoursion.cache.fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

    private Map<Integer, Long> cacheFibo = new HashMap<>();

    public static void main(String[] args) throws IOException {
        new Main().run(args);
    }

    private void fibo(int index, int n) {
        if (index == 0 || index == 1) {
            cacheFibo.put(index, (long)index);
        } else {
            cacheFibo.put(index, cacheFibo.get(index - 1) + cacheFibo.get(index - 2));
        }

        if (index == n) {
            return;
        }

        fibo(index + 1, n);
    }

    private void run(String[] args) throws IOException {
        int index = getInputIndex();
        fibo(0, index);
        System.out.println(cacheFibo.get(index));
    }

    private int getInputIndex() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return Integer.parseInt(reader.readLine());
        }
    }

}
