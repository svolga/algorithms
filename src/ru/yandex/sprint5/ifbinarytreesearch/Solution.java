package ru.yandex.sprint5.ifbinarytreesearch;

import java.util.ArrayList;
import java.util.List;

//  E. Дерево поиска
// https://contest.yandex.ru/contest/24809/problems/E/

public class Solution {

    public static void main(String[] args) {
//        test2();
        //
/*
        Node node2 = new Node(3);
        Node node1 = new Node(5);
        Node root = new Node(2, node1, node2);
*/

        Node node5 = new Node(25);
        Node node6 = new Node(6);
        Node node3 = new Node(3, node5, node6);
        Node node1 = new Node(1, node3, null);

        Node node9 = new Node(9);
        Node node8 = new Node(8, node9, null);
        Node node7 = new Node(7);
        Node node4 = new Node(4, node7, node8);
        Node node2 = new Node(24, null, node4);
        Node root = new Node(10, node1, node2);

        boolean isBinarySearch = treeSolution(root);
        System.out.println("isBinarySearch = " + isBinarySearch);
        //

    }

    public static boolean treeSolution(Node head) {
        // Your code
        // “ヽ(´▽｀)ノ”

        List<Integer> list = new ArrayList<>();
        createInOrderTraverse(head, list);

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }
        return true;
    }


    private static void createInOrderTraverse(Node head, List<Integer> list) {
        if (head == null) {
            return;
        }
        createInOrderTraverse(head.left, list);
        list.add(head.value);
        createInOrderTraverse(head.right, list);
    }


    // <template>
    private static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
    // <template>

        private static void test() {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(8, null, null);
        Node node5 = new Node(5, node3, node4);
        assert treeSolution(node5);
        node2.value = 5;
        assert !treeSolution(node5);
    }
}
