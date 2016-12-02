package com.company.list;

import java.lang.reflect.Array;

/**
 * Created by jbpark on 2016-12-03.
 */
public class ArrayList<T extends Comparable<T>> implements List<T> {

    private int len;
    private int cap;
    private T[] list;

    public ArrayList() {
        this.len = 0;
        this.cap = 10;
        list = (T[]) Array.newInstance(Comparable.class, cap);
    }

    public ArrayList(int cap) {
        this.len = 0;
        this.cap = cap;
        list = (T[]) Array.newInstance(Comparable.class, cap);

    }

    /**
     * Insert at the end of ArrayList. Has O(1) constant run time.
     * @param data to insert
     * @return boolean
     */
    @Override
    public boolean insert(T data) {
        if (len == cap) {
            resize(cap * 2);
        }
        list[len++] = data;
        return true;
    }

    /**
     * Insert at specified index. Has O(n) linear run time.
     * @param index index to insert
     * @param data data to insert
     * @return boolean
     */
    @Override
    public boolean insert(int index, T data) {
        if (len == index) {
            return insert(data);
        } else if (index > len) {
            return false;
        }
        if (len == cap) {
            resize(cap * 2);
        }
        for (int i = len - 1; i >= index; i--) {
            list[i+1] = list[i];
        }
        list[index] = data;
        len++;
        return true;
    }

    /**
     * Remove the last element in ArrayList. Has O(1) constant run time.
     * @return Last element
     */
    @Override
    public T remove() {
        if (len == 0) {
            return null;
        }
        T data = list[len-1];
        list[len-1] = null;
        len--;
        if (len * 2 < cap) {
            resize(cap/2);
        }
        return data;
    }

    /**
     * Remove element by index. Has O(n) run time.
     * @param index Index to remove.
     * @return Element removed.
     */
    @Override
    public T remove(int index) {
        if (index == len - 1) {
            return remove();
        } else if (index < 0 || index > len - 1) {
            return null;
        }
        T data = list[index];
        for (int i = index+1; i < len; i++) {
            list[i-1] = list[i];
        }
        list[len-1] = null;
        len--;
        if (len * 2 < cap) {
            resize(cap/2);
        }
        return data;
    }

    /**
     * Remove element by data. Has O(n) rune time.
     * @param data Element to remove.
     * @return Element removed.
     */
    @Override
    public T remove(T data) {
        int index = search(data);
        return remove(index);
    }

    /**
     * Get Index by element. Has O(n) run time.
     * @param data Element to search.
     * @return Element index.
     */
    @Override
    public int search(T data) {
        int index = -1;
        for (int i = 0; i < len; i++) {
            if (list[i].compareTo(data) == 0) {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Length of ArrayList
     * @return length
     */
    @Override
    public int length() {
        return len;
    }

    /**
     * Resize ArrayList
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        T[] tempList = (T[]) Array.newInstance(Comparable.class, newCapacity);

        int i = 0;
        for (T data : list) {
            if (data == null) break;
            tempList[i++] = data;
        }
        list = tempList;
        cap = newCapacity;
    }

    @Override
    public String toString() {
        return traverse();
    }

    private String traverse() {
        String o = "[ ";
        int i;
        T data;
        for (i = 0; i < cap; i++) {
            data = list[i];
            if (data == null) break;
            o += data.toString() + " ";
        }
        o += "]";
        return o;
    }
}
