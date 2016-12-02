package com.company.list;

/**
 * Created by jbpark on 2016-12-03.
 */
public interface List<T extends Comparable<T>> {
    public boolean insert(T data);
    public boolean insert(int index, T data);
    public T remove();
    public T remove(int index);
    public T remove(T data);
    public int search(T data);
    public int length();
}
