package java.yandex.sprint5.tree.thesametrees;

import java.util.ArrayList;
import java.util.List;

// D. Деревья - близнецы
// https://contest.yandex.ru/contest/24809/problems/D/
public class Solution {
/*
    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        Node node1 = new Node(1, null, null);
        Node node2 = new Node(2, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(1, null, null);
        Node node5 = new Node(2, null, null);
        Node node6 = new Node(3, node4, node5);
//        assert treeSolution(node3, node6);
//        boolean result = treeSolution(node3, node6);
//        System.out.println("the same: " + result);
    }
*/

    public static boolean treeSolution(Node head1, Node head2) {
        // Your code
        // “ヽ(´▽｀)ノ”
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        loadListFromTree(head1, list1);
        loadListFromTree(head2, list2);

        return list1.equals(list2);
    }

    private static void loadListFromTree(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }

        loadListFromTree(root.left, list);
        list.add(root.value);
        loadListFromTree(root.right, list);
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
        Node node2 = new Node(2, null, null);
        Node node3 = new Node(3, node1, node2);
        Node node4 = new Node(1, null, null);
        Node node5 = new Node(2, null, null);
        Node node6 = new Node(3, node4, node5);
        assert treeSolution(node3, node6);
    }
}
