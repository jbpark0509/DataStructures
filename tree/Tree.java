package com.company.tree;

/**
 * Created by jbpark on 2016-12-04.
 */
public interface Tree<T extends Comparable<T>> {
    public void insert(T data);
    public boolean remove(T data);
    public boolean search(T data);
    public void traversal();
    public T getMax();
    public T getMin();
}
