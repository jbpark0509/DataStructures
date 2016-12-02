package com.company.stack;

/**
 * Created by jbpark on 2016-12-03.
 */
public interface StackInterface<T extends Comparable<T>> {
    public void push(T data);
    public T pop();
    public T peek();
    public boolean isEmpty();
}
