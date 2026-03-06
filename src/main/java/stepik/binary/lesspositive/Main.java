package stepik.binary.lesspositive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Выведите значение наименьшего из всех положительных элементов в списке. Известно, что в списке есть хотя бы один положительный элемент.
 */
public class Main {

/*
5
5 -4 3 -2 1
*/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int search = Integer.parseInt(br.readLine());
        String line = br.readLine();

        int[] numbers = Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int result = Arrays.stream(numbers).filter(value -> value>0).min().getAsInt();

        System.out.println(result);
    }





}
