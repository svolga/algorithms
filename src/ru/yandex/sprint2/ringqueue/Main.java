package ru.yandex.sprint2.ringqueue;

import java.util.Arrays;

// Очередь на кольцевом буфере
public class Main {

    public static void main(String[] args) {
        Queue queue = new Queue(5);

        queue.push(11);
        queue.print();

        queue.push(22);
        queue.print();

        queue.push(33);
        queue.print();

        queue.push(44);
        queue.print();

        queue.push(55);
        queue.print();

        queue.pop();
        queue.print();

        queue.pop();
        queue.print();

        queue.push(77);
        queue.print();

        queue.push(88);
        queue.print();
    }

}


class Queue {
    private Integer[] queue;
    private int max_n;
    private int head;
    private int tail;
    private int size;

    public Queue(int n) {
        this.max_n = n;
        this.head = 0;
        this.tail = 0;
        this.size = 0;
        queue = new Integer[n];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(int x) {
        if (size != max_n) {
            queue[tail] = x;
            tail = (tail + 1) % max_n;
            size++;
        }
    }

    public Integer pop() {
        if (isEmpty()) {
            return null;
        }

        Integer x = queue[head];
        queue[head] = null;
        head = (head + 1) % max_n;
        size--;
        return x;
    }

    public void print (){
        String str = Arrays.toString(queue);
        System.out.println(str);
    }

}
