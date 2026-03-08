package stepik.binary.leftbinarysearch;

// Левый бинарный поиск в массиве
public class Main {

    public static void main(String[] args) {
        int[] sarr = new int[]{1, 2, 4, 4, 4, 5, 7, 9, 11};
        int target = 4;
        int x = getLbs(sarr, target);
        System.out.println("x = " + x); // 2
    }

    private static int getLbs(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= target) {
                right = mid - 1;   // move left
            } else {
                left = mid + 1;    // move right
            }
        }

        if (left < arr.length && arr[left] == target) {
            return left;
        }

        return -1;
    }

}
