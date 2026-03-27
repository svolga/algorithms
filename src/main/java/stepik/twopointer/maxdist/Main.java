package stepik.twopointer.maxdist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Задача «Город Мечта»
https://stepik.org/lesson/1135564/step/3?unit=1147202
 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = br.readLine().replace("\r\n","").split(" ");
        long N = Integer.parseInt(line1[0]);
        long R = Integer.parseInt(line1[1]);

        String[] line2 = br.readLine().split(" ");
        long[] nums = Arrays.stream(line2).mapToLong(Long::parseLong).toArray();

        int left  = 0;
        int right = 0;

        long count = 0;
        while (right < nums.length) {
            if (nums[right] - nums[left] > R) {
                count += N-right;
                left++;
            }
            else{
                right++;
            }
        }

        System.out.println(count);

    }

}