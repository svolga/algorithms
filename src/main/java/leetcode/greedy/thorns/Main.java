package leetcode.greedy.thorns;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Задача «Шипы и монеты»
https://stepik.org/lesson/1236735/step/1?unit=1250466
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line1 = br.readLine();
        int N = Integer.parseInt(line1);

        String line2 = br.readLine();
        char[] array = line2.toCharArray();

        int count = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == '*' && array[i] == array[i - 1]) {
                break;
            }
            else if (array[i] == '@') {
                count++;
            }
        }

        System.out.println(count);
    }
}
