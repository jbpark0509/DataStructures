package com.company.list;

/**
 * Created by jbpark on 2016-12-03.
 */
public class SingleLinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int length;

    /**
     * Insert at the beginning of list. Has O(1) run time.
     * @param data Data to insert
     * @return boolean
     */
    @Override
    public boolean insert(T data) {
        Node<T> newRoot = new Node<T>(data);
        newRoot.setNextNode(root);
        root = newRoot;
        length++;
        return true;
    }

    /**
     * Insert data at index. Has O(n) run time.
     * @param index
     * @param data
     * @return
     */
    @Override
    public boolean insert(int index, T data) {
        if (index < 0 || index > length) {
            return false;
        } else if (index == 0) {
            return insert(data);
        }
        insertAtIndex(index, data, root);
        return false;
    }

    private boolean insertAtIndex(int index, T data, Node<T> n) {
        if (index == 1) {
            System.out.println(data.toString());
            Node<T> newNode = new Node<>(data);
            newNode.setNextNode(n.getNextNode());
            n.setNextNode(newNode);
            length++;
            return true;
        }
        return insertAtIndex(index - 1, data, n.getNextNode());
    }

    /**
     * Remove the first element in the list. Has O(1) run time.
     * @return Removed element.
     */
    @Override
    public T remove() {
        if (length == 0) {
            return null;
        }
        T data = root.getData();
        Node<T> nodeToRemove = root;
        root = root.getNextNode();
        nodeToRemove = null;
        length--;
        return data;
    }

    /**
     * Remove element by index. Has O(n) run time.
     * @param index Index to remove
     * @return Removed element.
     */
    @Override
    public T remove(int index) {
        if (index < 0 || index > length) {
            return null;
        } else if (index == 0) {
            return remove();
        }
        return removeByIndex(index, root);
    }

    private T removeByIndex(int index, Node<T> n) {
        if (index == 1) {
            Node<T> nodeToRemove = n.getNextNode();
            T data = nodeToRemove.getData();
            n.setNextNode(nodeToRemove.getNextNode());
            nodeToRemove = null;
            return data;
        }
        return removeByIndex(index - 1, n.getNextNode());
    }

    /**
     * Remove element. Has O(n) run time.
     * @param data Data to remove.
     * @return Removed element.
     */
    @Override
    public T remove(T data) {
        return removeByElement(data, null, root);
    }

    private T removeByElement(T data, Node<T> prev, Node<T> current) {
        if (current == null) {
            return null;
        } else if (current.getData().compareTo(data) == 0) {
            prev.setNextNode(current.getNextNode());
            T removedEl = current.getData();
            current = null;
            length--;
            return removedEl;
        }
        return removeByElement(data, current, current.getNextNode());
    }

    /**
     * Search element by index
     * @param data Element to find
     * @return index
     */
    @Override
    public int search(T data) {
        return search(data, root, 0);
    }

    private int search(T data, Node<T> n, int index) {
        if (n == null) {
            return -1;
        } else if (n.getData().compareTo(data) == 0) {
            return index;
        }
        return search(data, n.getNextNode(), index+1);
    }

    @Override
    public int length() {
        return length;
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
