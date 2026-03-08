package stepik.binary.rightbinarysearch;

// Правый бинарный поиск в массиве
public class Main {

    public static void main(String[] args) {
        int[] sarr = new int[]{1, 2, 4, 4, 4, 5, 7, 9, 11};
        int target = 4;
        int x = getRbs(sarr, target);
        System.out.println("x = " + x); // 2
    }

    private static int getRbs(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;    // move right
            } else {
                right = mid - 1;   // move left
            }
        }

        if (right >= 0 && arr[right] == target) {
            return right;
        }

        return -1;
    }


}
