package java.yandex.sprint4.preffhash2;

import java.util.Arrays;

public class Solution {


    /*
    def calc(a, m, length):
        result = [1, ]
        for c in range(0, length):
            result.append(result[c] * a % m)
        return result


    def find_hash(m, word, prefix):
        result = 0
        count = 0
        for c in word[::-1]:
            result = (result + ord(c) * prefix[count])
            count += 1
        return result % m


    if __name__ == '__main__':
        a = 1 //int(input())
        m = 10 //int(input())
        input_string = 'abc' //input()
        prefix = calc(a, m, (len(input_string) - 1))
        for i in range(int(input())):
            left, right = input().split()
            print(find_hash(
                m,
                input_string[int(left) - 1:int(right)],
                prefix
            ))
     */
    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        int a = 157;
        int m = 10;

        String str = "abcdefgh";

        /*
         result = [1, ]
    for c in range(0, length):
        result.append(result[c] * a % m)
    return result
         */
        int[] h = new int[str.length() + 1];
        for (int i = 0; i < str.length(); i++) {
            h[i + 1] += h[i] * a % m;
        }
        print(h);

    }


    private void print(long[] array) {
        System.out.println(Arrays.toString(array));
    }

    private void print(int[] array) {
        System.out.println(Arrays.toString(array));
    }

}
