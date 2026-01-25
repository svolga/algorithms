package java.yandex.sprint1.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringSizeTokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(stringSizeTokenizer.nextToken());

        int max = 0;
        String word = "";
        StringTokenizer stringTextTokenizer = new StringTokenizer(reader.readLine());
        while (stringTextTokenizer.hasMoreTokens()) {
            String text = stringTextTokenizer.nextToken();
            if (text.length()>max){
                max = text.length();
                word = text;
            }
        }
        System.out.println(word);
        System.out.println(max);
    }
}
