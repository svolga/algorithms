package java.yandex.sprint1.timesec;

public class Main {

    public static void main(String[] args) {
        long time_start = System.currentTimeMillis();
        long i = 0;
        while (i < 1_000_000_000L) {
            i++;
        }
        long time_finish = System.currentTimeMillis();
        long time_span = time_finish - time_start;
        System.out.println(time_span / 1000.0 + " seconds");
    }

}
