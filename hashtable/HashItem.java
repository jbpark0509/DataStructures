package com.company.hashtable;

/**
 * Created by jbpark on 2016-12-10.
 */
public class HashItem<K, V> {
    private K key;
    private V value;
    private HashItem<K, V> nextItem;

    public HashItem(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public HashItem<K, V> getNextItem() {
        return nextItem;
    }

    public void setNextItem(HashItem<K, V> nextItem) {
        this.nextItem = nextItem;
    }
}

