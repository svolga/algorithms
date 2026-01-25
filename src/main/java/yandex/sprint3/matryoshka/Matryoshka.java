package java.yandex.sprint3.matryoshka;

public class Matryoshka {
    public static void buildMatryoshka(int size, int n) {
        if (n >= 1) {

            System.out.println("above n = " + n + "; size = " + size);

            System.out.println("Создаём низ матрёшки размера " + size + ".");
            buildMatryoshka(size - 1, n - 1);

            System.out.println("below n = " + n + "; size = " + size);

            System.out.println("Создаём верх матрешки размера " + size + ".");
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        buildMatryoshka(4, 3);
    }
}