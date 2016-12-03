package com.company.queue;

/**
 * Created by jbpark on 2016-12-03.
 */
public class Queue<T extends Comparable<T>> implements QueueInterface<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    @Override
    public void enqueue(T data) {
        Node<T> n = new Node<>(data);
        if (size == 0) {
            head = n;
            tail = head;
        } else {
            n.setPrevNode(tail);
            tail.setNextNode(n);
            tail = n;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (size == 0) {
            return null;
        }
        T data = head.getData();
        head = head.getNextNode();
        size--;
        return data;
    }

    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public String toString() {
        Node<T> n = head;
        String o = "[ ";
        while(n != null) {
            o += n.getData().toString() + " ";
            n = n.getNextNode();
        }
        o += "] ";
        return o;
    }
}
