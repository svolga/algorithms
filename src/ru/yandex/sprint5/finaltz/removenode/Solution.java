package ru.yandex.sprint5.finaltz.removenode;

// B. Удали узел
// https://contest.yandex.ru/contest/24810/problems/B/
// Номер посылки: 105561534
// Посылка: https://contest.yandex.ru/contest/24810/run-report/105561534/
/*
-- ПРИНЦИП РАБОТЫ --

   При удалении элемента дерева возможны варианты:
        1) у узла нет дочерних узлов;
        2) у узла есть левый дочерних узлов;
        3) у узла есть правый дочерних узлов;
        4) у узла есть оба ребёнка.

    В случае 1 просто удаляем узел, дополнительная работа не требуется.
    В случае 2 и 3 заменяем удаляемый узел на его потомка, на этом удаление заканчивается.
    В случае 4 находим в правом поддереве минимальный элемент и перемещаем его на место удаляемого узла.

    Источник информации:
    1) Лекции Яндекс
    2) Статья: https://tproger.ru/articles/dvoichnoe-binarnoe-derevo-udalenie-jelementa-i-skorost-raboty

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
    В худшем случае сложность оставляет O(h), где h - высота дерева.
    Если у каждой вершины ровно один ребенок, то высота и число элементов в нем совпадают, т.е. h = n, сложность
    составит O(n)
    Для сбалансированного дерева сложность O(h) ~ O(log n)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
    O(log n)

 */

// <template>
class Node {
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

public class Solution {

    public static void main(String[] args) {
        test();
    }

    public static Node remove(Node root, int key) {
        // Your code
        // “ヽ(´▽｀)ノ”
        if (root == null) {
            return null;
        }

        if (root.getValue() == key) {
            // Если дерево состояло из одной вершины,
            if (root.getLeft() == null && root.getRight() == null) {
                return null;
            }

            // Если мы удаляем лист, то дерево останется одним деревом
            if (root.getLeft() == null) {
                return root.getRight();
            }

            if (root.getRight() == null) {
                return root.getLeft();
            }

            // Есть два потомка
            Node minRightNode = findMinNode(root.getRight());
            // Минимальный элемент для правого поддерева
            root.setValue(minRightNode.getValue());
            // ищем в правом поддереве минимальный элемент, значение которого уже вставлено на место текущего
            root.setRight(remove(root.getRight(), minRightNode.getValue()));
            return root;
        }

        if (root.getValue() > key) {
            if (root.getLeft() != null) {
                root.setLeft(remove(root.getLeft(), key));
            }
        } else {
            if (root.getRight() != null) {
                root.setRight(remove(root.getRight(), key));
            }
        }

        return root;
    }

    private static Node findMinNode(Node node) {
        if (node.getLeft() == null) return node;
        return findMinNode(node.getLeft());
    }

    private static void test() {
        Node node1 = new Node(null, null, 2);
        Node node2 = new Node(node1, null, 3);
        Node node3 = new Node(null, node2, 1);
        Node node4 = new Node(null, null, 6);
        Node node5 = new Node(node4, null, 8);
        Node node6 = new Node(node5, null, 10);
        Node node7 = new Node(node3, node6, 5);
        Node newHead = remove(node7, 10);
        assert newHead.getValue() == 5;
        assert newHead.getRight() == node5;
        assert newHead.getRight().getValue() == 8;
    }
}
