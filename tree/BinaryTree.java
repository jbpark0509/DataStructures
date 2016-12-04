package com.company.tree;

/**
 * Created by jbpark on 2016-12-04.
 */
public class BinaryTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    /**
     * Insert to tree. Has O(lg n) run time.
     * @param data Data to insert.
     */
    @Override
    public void insert(T data) {
        Node<T> n = new Node<T>(data);
        if (root == null) {
            root = n;
        } else {
            insert(data, root);
        }
    }

    private Node<T> insert(T data, Node<T> node) {
        if (node == null) {
            return new Node<>(data);
        }
        Node<T> n;
        if (node.getData().compareTo(data) > 0) {
            n = insert(data, node.getLeftChild());
            if (n != null) {
                node.setLeftChild(n);
            }
        } else {
            n = insert(data, node.getRightChild());
            if (n != null) {
                node.setRightChild(n);
            }
        }
        return null;
    }

    /**
     * Remove node from tree. Has O(lg n) run time.
     * @param data Data to remove.
     */
    @Override
    public boolean remove(T data) {
        if (root != null) {
            root = remove(data, root);
        }
        return true;
    }

    private Node<T> remove(T data, Node<T> node) {
        if (node == null) {
            return null;
        }
        int compareResult = node.getData().compareTo(data);
        switch (compareResult) {
            case 0:
                // Found the node
                if (node.getLeftChild() == null && node.getRightChild() == null) {
                    System.out.println("Removing Leaf Node");
                    return null;
                } else if (node.getLeftChild() == null) {
                    System.out.println("Removing the Right Node");
                    return node.getRightChild();
                } else if (node.getRightChild() == null) {
                    System.out.println("Removing the Left Node");
                    return node.getLeftChild();
                } else {
                    Node<T> predecessor = getMax(node.getLeftChild());
                    node.setData(predecessor.getData());
                    node.setLeftChild(remove(predecessor.getData(), node.getLeftChild()));
                    break;
                }
            case 1:
                node.setLeftChild(remove(data, node.getLeftChild()));
                break;
            case -1:
                node.setRightChild(remove(data, node.getRightChild()));
                break;
            default:
                return null;
        }
        return node;
    }

    /**
     * Search for a node
     * @param data Data to search.
     * @return Boolean.
     */
    @Override
    public boolean search(T data) {
        return search(data, root) != null;
    }

    private Node<T> search(T data, Node<T> node) {
        if (node == null) {
            return null;
        }
        int compareResult = node.getData().compareTo(data);
        switch (compareResult) {
            case 0:
                return node;
            case 1:
                return search(data, node.getLeftChild());
            case -1:
                return search(data, node.getRightChild());
            default:
                return null;
        }
    }

    /**
     * Traverses through tree. Takes O(n) run time.
     */
    @Override
    public void traversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(Node<T> n) {
        if (n == null) {
            return;
        }
        inOrderTraversal(n.getLeftChild());
        System.out.print(n + " ");
        inOrderTraversal(n.getRightChild());
    }

    /**
     * Get maximum from tree. Has O(lg n) run time.
     * @return Maximum node.
     */
    @Override
    public T getMax() {
        return getMax(root).getData();
    }

    private Node<T> getMax(Node<T> node) {
        if (node.getRightChild() == null) {
            return node;
        }
        return getMax(node.getRightChild());
    }

    /**
     * Get minimum from tree. Has O(lg n) run time.
     * @return Maximum node.
     */
    @Override
    public T getMin() {
        return getMin(root).getData();
    }

    private Node<T> getMin(Node<T> node) {
        if (node.getLeftChild() == null) {
            return node;
        }
        return getMin(node.getLeftChild());
    }



}
