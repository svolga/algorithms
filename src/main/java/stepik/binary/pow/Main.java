package stepik.binary.pow;

/*
Вычисление корня через вещественный двоичный поиск
n
n-й степени
 */
public class Main {

    public static void main(String[] args) {

        int a = 2;
        int n = 2;
        double eps = 0.000001;
        double left = 0;
        double right = 1000;

        while (right - left > eps) {
            double mid = (left + right) / 2;
            if (Math.pow(mid, n) < a) {
                left = mid;
            } else {
                right = mid;
            }
        }

        System.out.println(right);


    }

}
