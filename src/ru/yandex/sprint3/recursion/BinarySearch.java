package ru.yandex.sprint3.recursion;

public class BinarySearch {

    private int binarySearch(int[] list, int start, int end, int search) {

        if (end <= start) {
            return -1;
        }

        int mid = (end + start) / 2;
        int value = list[mid];
        if (search == value) {
            return mid;
        } else if (search < value) {
            return binarySearch(list, start, mid, search);
        } else {
            return binarySearch(list, mid + 1, end, search);
        }

    }

    private void run(String[] args) {
        int[] list = new int[]{1, 2, 14, 20, 22, 25, 29, 30, 31, 65, 67, 69, 70, 86, 89, 91, 125, 225, 230, 350};

        int index = binarySearch(list, 0, list.length - 1, 25);
        if (index >= 0) {
            System.out.println("index = " + index + "; value = " + list[index]);
        } else {
            System.out.println("Элемент не найден");
        }
    }

    public static void main(String[] args) {
        new BinarySearch().run(args);
    }


}
