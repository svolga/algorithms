package stepik.greedy.boat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
Задача «SOS»
https://stepik.org/lesson/1105114/step/9?unit=1116299

Нам необходимо переправить людей на лодках с одного берега на другой. Мы знаем массу каждого человека, а также грузоподъёмность каждой лодки. Одновременно на одной лодке могут плыть один или два человека с условием, что их общая масса не превышает грузоподъёмность лодки. Количество лодок не ограничено.

Формат входных данных
В первой строке вводится натуральное число
n≤5⋅10^4.
Во второй строке вводятся
n натуральных чисел через пробел - массы людей.
В третьей строке вводится грузоподъёмность каждой лодки limit.

Формат выходных данных
Выведите одно число - минимальное количество лодок, необходимое для того, чтобы переправить всех людей.

Комментарий по тестам
Тест №1: Можем разместить двух человек в одной лодке, так как
1+2≤3.
Тест №2: Можем разметить всех человек в трёх лодках, а именно
3,2,2+1.

Sample Input 1:

2
1 2
3
Sample Output 1:

1
Sample Input 2:

4
3 2 2 1
3
Sample Output 2:

3


 */
public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String[] line2 = br.readLine().split(" ");
        int[] nums = Arrays.stream(line2).mapToInt(Integer::parseInt).toArray();

        int limit = Integer.parseInt(br.readLine());

        int min = getMinBoards(nums, limit);
        System.out.println(min);

    }

    private static int getMinBoards(int[] nums, int limit) {

        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        int left = 0;
        int right = nums.length - 1;
        int count = 0;
        while (left <= right) {

            if (nums[left] + nums[right] <= limit) {
                count++;
                left++;
                right--;
            } else {
                count++;
                right--;
            }
        }
        return count;
    }


}
