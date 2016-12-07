package com.company.tree;

/**
 * Created by jbpark on 2016-12-07.
 */
public class SplayTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    /**
     * Insert a new node. Has O(lg n) run time average and O(n) worst case.
     * @param data
     */
    @Override
    public void insert(T data) {
        Node<T> tempNode = this.root;
        Node<T> parentNode = null;

        while (tempNode != null) {
            parentNode = tempNode;
            if (tempNode.getData().compareTo(data) < 0) {
                tempNode = tempNode.getRightChild();
            } else {
                tempNode = tempNode.getLeftChild();
            }
        }

        tempNode = new Node<>(data);
        tempNode.setParent(parentNode);

        if (parentNode == null) {
            this.root = tempNode;
        } else if (parentNode.getData().compareTo(tempNode.getData()) < 0) {
            parentNode.setRightChild(tempNode);
        } else {
            parentNode.setLeftChild(tempNode);
        }

        splay(tempNode);
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

    @Override
    public boolean search(T data) {
        Node<T> tempNode = this.root;
        while (tempNode != null) {
            if (tempNode.getData().compareTo(data) < 0) {
                tempNode = tempNode.getRightChild();
            } else if (tempNode.getData().compareTo(data) > 0) {
                tempNode = tempNode.getLeftChild();
            } else {
                splay(tempNode);
                return true;
            }
        }
        return false;
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

    private void rightRotate(Node<T> node) {
        System.out.println("Rotating to the right: " + node);

        Node tempLeftNode = node.getLeftChild();
        node.setLeftChild(tempLeftNode.getRightChild());

        if (node.getLeftChild() != null) {
            node.getLeftChild().setParent(node);
        }

        tempLeftNode.setParent(node.getParent());

        if (tempLeftNode.getParent() == null) {
            root = tempLeftNode;
        } else if (node == node.getParent().getLeftChild()) {
            node.getParent().setLeftChild(tempLeftNode);
        } else {
            node.getParent().setRightChild(tempLeftNode);
        }
        tempLeftNode.setRightChild(node);
        node.setParent(tempLeftNode);
    }

    private void leftRotate(Node<T> node) {
        System.out.println("Rotating to the left: " + node);

        Node tempRightNode = node.getRightChild();
        node.setRightChild(tempRightNode.getLeftChild());

        if (node.getRightChild() != null) {
            node.getRightChild().setParent(node);
        }

        tempRightNode.setParent(node.getParent());

        if (tempRightNode.getParent() == null) {
            root = tempRightNode;
        } else if (node == node.getParent().getRightChild()) {
            node.getParent().setRightChild(tempRightNode);
        } else {
            node.getParent().setLeftChild(tempRightNode);
        }
        tempRightNode.setLeftChild(node);
        node.setParent(tempRightNode);
    }

    private void splay(Node<T> node) {
        while (node.getParent() != null) {
            // Zig Situation
            if (node.getParent().getParent() == null) {
                if (node.getParent().getLeftChild() == node) {
                    rightRotate(node.getParent());
                } else {
                    leftRotate(node.getParent());
                }
            }
            // Zig-Zig Situation
            else if (node.getParent().getLeftChild() == node &&
                    node.getParent().getParent().getLeftChild() == node.getParent()) {
                rightRotate(node.getParent().getParent());
                rightRotate(node.getParent());
            }
            else if (node.getParent().getRightChild() == node &&
                    node.getParent().getParent().getRightChild() == node.getParent()) {
                leftRotate(node.getParent().getParent());
                leftRotate(node.getParent());
            }
            // Zig-Zag Situation
            else if (node.getParent().getLeftChild() == node &&
                    node.getParent().getParent().getRightChild() == node.getParent()) {
                rightRotate(node.getParent());
                leftRotate(node.getParent());
            } else if (node.getParent().getRightChild() == node &&
                    node.getParent().getParent().getLeftChild() == node.getParent()) {
                leftRotate(node.getParent());
                rightRotate(node.getParent());
            }
        }
        root = node;
    }
}
