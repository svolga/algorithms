package stepik.binary.badcolumns;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Задача «Плохие столбцы»

С консоли подаются строки одинакового размера. Каждая вводится в новой строке,
образуя тем самым матрицу. Нужно определить, какое количество столбцов в
образованной матрице будет находиться не в лексикографическом порядке.
Лексикографический порядок - отношение линейного порядка на множестве слов
над некоторым упорядоченным алфавитом (в нашем случае алфавит английский).
Простым языком, это порядок символов как в алфавите: чем позже буква, тем она "больше".
Sample Input:
3 3
cba
daf
ghi
Sample Output:
1

 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = br.readLine().split(" ");

        int N = Integer.parseInt(line1[0]);
        int M = Integer.parseInt(line1[1]);

        String [] rows = new String[N];
        for (int i = 0; i < N; i++) {
            rows[i] = br.readLine();
        }

        int count = 0;
        for (int j = 0; j < M; j++) {

            Character[] chs = new Character[N];
            for (int i = 0; i < N; i++) {
                chs[i] = rows[i].charAt(j);
            }

            Character[] chsCopy = Arrays.copyOf(chs, N);
            Arrays.sort(chs);
            int isEqual = Arrays.compare(chs, chsCopy);

            if (isEqual != 0) {
                ++count;
            }

        }
        System.out.println(count);
    }

}
