package java.yandex.sprint4.range;

class MaxSumRange {
    int startIndex;
    int endIndex;
    int currSum;

    public MaxSumRange(int startIndex, int endIndex, int currSum) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.currSum = currSum;
    }

    @Override
    public String toString() {
        return "MaxSumRange{" +
                "startIndex=" + startIndex +
                ", endIndex=" + endIndex +
                ", currSum=" + currSum +
                '}';
    }
}

public class Solution {

    private MaxSumRange getMaxSumRange(int[] array) {

        int currSum = 0;
        int startIndex = 0;
        MaxSumRange maxSumRange = null;

        for (int endIndex = 0; endIndex < array.length; endIndex++) {
            currSum += array[endIndex];

            if (maxSumRange == null || currSum > maxSumRange.currSum) {
                maxSumRange = new MaxSumRange(startIndex, endIndex, currSum);
            }

            if (currSum < 0) {
                currSum = 0;
                startIndex = endIndex + 1;
            }

        }
        return  maxSumRange;
    }


    private void run(String[] args) {
        int[] array = {2, -8, 3, -2, 4, -10};

        MaxSumRange maxSumRange = getMaxSumRange(array);

        System.out.println(maxSumRange);

    }

    public static void main(String[] args) {
        new Solution().run(args);
    }

}
