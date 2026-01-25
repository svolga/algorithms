package java.yandex.sprint3.recursion;

public class Binary2 {
    public static void main(String[] args) {
        new Binary2().run(args);
    }

    private void run(String[] args) {
        genBinary(3, "");
    }

    static void genBinary(int n, String prefix) {
        if (n == 0) {
            System.out.println(prefix);
        } else {
            genBinary(n - 1, prefix + "0");
            genBinary(n - 1, prefix + "1");
        }
    }


}
