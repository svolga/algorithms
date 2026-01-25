package java.yandex.sprint1.factorization;

public class Main {

    private boolean isPrime(int value) {
        if (value == 1)
            return false;

        int i = 2;
        while (i * i < value) {
            if (value % i == 0) {
                return false;
            }
            ++i;
        }
        return true;
    }

    private void run() {

//        int

        System.out.println("111111111111");
    }

    public static void main(String[] args) {
        new Main().run();
    }

}
