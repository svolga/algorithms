package stepik.arithm.recoursion.fibonacci;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        new Main().run(args);
    }

    private int fibo(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    private void run(String[] args) throws IOException {
        int index = getInputIndex();
        System.out.println(fibo(index));
    }

    private int getInputIndex() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            return Integer.parseInt(reader.readLine());
        }
    }

}
