package com.company.stack;

/**
 * Created by jbpark on 2016-12-03.
 */
public class Stack<T extends Comparable<T>> implements StackInterface<T> {

    private Node<T> root;

    /**
     * Push to stack. Has O(1) run time.
     * @param data to push
     */
    @Override
    public void push(T data) {
        Node<T> n = new Node<>(data);
        n.setNextNode(root);
        root = n;
    }

    /**
     * Pop the last item in stack. Has O(1) run time.
     * @return
     */
    @Override
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T data = root.getData();
        root = root.getNextNode();
        return data;
    }

    /**
     * Returns the first item in stack without popping. Has O(1) run time.
     * @return
     */
    @Override
    public T peek() {
        return isEmpty() ? null : root.getData();
    }

    /**
     * Checks if stack is empty. Has O(1) run time.
     * @return
     */
    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public String toString() {
        Node<T> n = root;
        String o = "[ ";
        while(n != null) {
            o += n.getData().toString() + " ";
            n = n.getNextNode();
        }
        o += "] ";
        return o;
    }
}
