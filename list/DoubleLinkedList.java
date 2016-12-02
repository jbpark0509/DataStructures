package com.company.list;

/**
 * Created by jbpark on 2016-12-03.
 */
public class DoubleLinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> head;
    private Node<T> tail;
    private int length;

    /**
     * Insert at the beginning of list. Has O(1) run time.
     * @param data Element to insert.
     * @return boolean
     */
    @Override
    public boolean insert(T data) {
        Node<T> newHead = new Node<T>(data);
        newHead.setNextNode(head);
        if (head != null) head.setPrevNode(newHead);
        head = newHead;
        length++;
        return true;
    }

    /**
     * Insert at the end of list. Has O(1) run time.
     * @param data Element to insert.
     * @return boolean
     */
    private boolean insertAtEnd(T data) {
        Node<T> newTail = new Node<T>(data);
        newTail.setPrevNode(tail);
        if (tail != null) tail.setNextNode(newTail);
        tail = newTail;
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
        } else if (index == length - 1) {
            return insertAtEnd(data);
        }
        return insertAtIndex(index, data, head);
    }

    private boolean insertAtIndex(int index, T data, Node<T> n) {
        if (index == 1) {
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
        T data = head.getData();
        head = head.getNextNode();
        head.setPrevNode(null);
        length--;
        return data;
    }

    /**
     * Remove the last element in the list. Has O(1) run time.
     * @return Removed element.
     */
    private T removeAtEnd() {
        if (length == 0) {
            return null;
        }
        T data = tail.getData();
        tail = tail.getPrevNode();
        tail.setNextNode(null);
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
        return removeByIndex(index, head);
    }

    private T removeByIndex(int index, Node<T> n) {
        if (index == 1) {
            Node<T> nodeToRemove = n.getNextNode();
            T data = nodeToRemove.getData();
            n.setNextNode(nodeToRemove.getNextNode());
            length--;
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
        return removeByElement(data, null, head);
    }

    private T removeByElement(T data, Node<T> prev, Node<T> current) {
        if (current == null) {
            return null;
        } else if (current.getData().compareTo(data) == 0) {
            prev.setNextNode(current.getNextNode());
            T removedEl = current.getData();
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
        return search(data, head, 0);
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
