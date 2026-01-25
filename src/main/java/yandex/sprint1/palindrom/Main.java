package java.yandex.sprint1.palindrom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main {

    public static void main(String[] args) throws IOException {
//        String str = "A man, a plan, a canal: Panama";

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(Locale.ROOT);

        int start = 0;
        int end = str.length() - 1;
        boolean isPalindrom = true;

        while (start < end) {
            if(str.charAt(start) != str.charAt(end)){
                isPalindrom = false;
                break;
            }
            ++start;
            --end;
        }

        System.out.println(isPalindrom ? "True" : "False");
    }

}
