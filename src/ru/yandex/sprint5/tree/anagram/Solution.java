package ru.yandex.sprint5.tree.anagram;

import java.util.ArrayList;
import java.util.List;

// C. Дерево - анаграмма
// https://contest.yandex.ru/contest/24809/problems/C/
public class Solution {
/*
    public static void main(String[] args) {
        new Solution().run(args);
    }

    private void run(String[] args) {
        Node node1 = new Node(3, null, null);
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(4, null, null);
        Node node4 = new Node(3, null, null);
        Node node5 = new Node(2, node1, node2);
        Node node6 = new Node(2, node3, node4);
        Node node7 = new Node(1, node5, node6);

        List<Integer> list = new ArrayList<>();
        loadArrayFromBst(node7, list);
        System.out.println(list);
        boolean isAnagram = isAnagram(list);
        System.out.println("isAnagram = " + isAnagram);
    }
*/

    private static boolean isAnagram(List<Integer> list) {

        if (list.size() % 2 == 0) {
            return false;
        }

        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static void loadArrayFromBst(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }
        loadArrayFromBst(node.left, list);
        list.add(node.value);
        loadArrayFromBst(node.right, list);
    }

    public static boolean treeSolution(Node head) {

        // Your code
        // “ヽ(´▽｀)ノ”
        List<Integer> list = new ArrayList<>();
        loadArrayFromBst(head, list);
        return isAnagram(list);
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
        Node node1 = new Node(3, null, null);
        Node node2 = new Node(4, null, null);
        Node node3 = new Node(4, null, null);
        Node node4 = new Node(3, null, null);
        Node node5 = new Node(2, node1, node2);
        Node node6 = new Node(2, node3, node4);
        Node node7 = new Node(1, node5, node6);
        assert treeSolution(node7);
    }
}
