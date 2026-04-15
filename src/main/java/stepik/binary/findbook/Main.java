package stepik.binary.findbook;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Бинарный поиск строк
https://stepik.org/lesson/1221969/step/5?unit=1235378

Входные данные
3
GreatExpectations
PrideAndPrejudice
WarAndPeace
WarAndPeace

Выходные данные
YES
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] rows = new String[N];
        for (int i = 0; i < N; i++) {
            rows[i] = br.readLine();
        }

        String target = br.readLine();

        int left = 0;
        int right = rows.length - 1;
        while (left <= right) {

            int mid = left + (right - left) / 2;

            int compared = rows[mid].compareTo(target);
            if(compared == 0) {
                System.out.println("YES");
                return;
            }
            else if(compared < 0) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        System.out.println("NO");
    }

}
