package ru.yandex.sprint5.tree.base;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

    }

}

// Дерево с произвольным кол-ом детей
class Node<T> {
    private T obj;
    private List<Node<T>> children;

    public Node(T obj) {
        this.obj = obj;
        this.children = new ArrayList<>();
    }

    public Node(T obj, List<Node<T>> children) {
        this.obj = obj;
        this.children = children != null ? children : new ArrayList<>();
    }
}

// Бинарное дерево
class NodeBin {
    public NodeBin(int obj, Node left, Node right) {
        this.obj = obj;
        this.left = left;
        this.right = right;
    }
    public int obj;
    public Node left;
    public Node right;
}