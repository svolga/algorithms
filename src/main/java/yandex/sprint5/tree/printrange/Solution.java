package java.yandex.sprint5.tree.printrange;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

// K. Выведи диапазон
// https://contest.yandex.ru/contest/24809/problems/K/
/*
Идея: Ищем в диапазоне k1 ... k2
 1) Е. root.key>=k1, то рекурсивно ищем в левом поддереве
 2) Е. root.key>=k1 && root.key<=k2, то печатаем
 3) Е. root.key <=k2, то рекурсивно ищем в правом поддереве

Сложность O(h+k), где где h –— глубина дерева, k  — число элементов в ответе
 */

public class Solution {
/*
    public static void main(String[] args) throws IOException {
        test();
    }
*/
    public static void printRange(Node root, int L, int R, BufferedWriter writer) throws IOException {
        // Your code
        // “ヽ(´▽｀)ノ”
        if (root == null) {
            return;
        }
        if (root.getValue() >= L) {
            printRange(root.getLeft(), L, R, writer);
        }
        if (root.getValue() >= L && root.getValue() <= R) {
            writer.append(String.valueOf(root.getValue()))
                    .append(System.lineSeparator());
        }
        if (root.getValue() <= R) {
            printRange(root.getRight(), L, R, writer);
        }
    }

    // <template>
    private static class Node {
        private int value;
        private Node left;
        private Node right;

        Node(Node left, Node right, int value) {
            this.left = left;
            this.right = right;
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
    // <template>

    private static void test() throws IOException {
        Node node1 = new Node(null, null, 2);
        Node node2 = new Node(null, node1, 1);
        Node node3 = new Node(null, null, 8);
        Node node4 = new Node(null, node3, 8);
        Node node5 = new Node(node4, null, 9);
        Node node6 = new Node(node5, null, 10);
        Node node7 = new Node(node2, node6, 5);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        printRange(node7, 2, 8, writer);
        writer.flush();
        // expected output: 2 5 8 8
    }
}
