package com.company.hashtable;

/**
 * Created by jbpark on 2016-12-10.
 */
public class HashTable<K, V> {
    HashItem<K, V>[] HashTable;
    private int capacity;
    private int size;

    public HashTable() {
        HashTable = new HashItem[Constants.INIT_TABLE_SIZE];
        capacity = Constants.INIT_TABLE_SIZE;
        size = 0;
    }

    public void put(K key, V value ) {
        int index = hash(key);
        if (HashTable[index] == null) {
            HashTable[index] = new HashItem<>(key, value);
        } else {
            HashItem<K, V> item = HashTable[index];
            while (item.getNextItem() != null) {
                item = item.getNextItem();
            }
            item.setNextItem(new HashItem<>(key, value));
        }
        size++;
        if (shouldIncreaseCap()) resize(capacity * 2);
    }

    public V search(K key) {
        if (key == null) {
            return null;
        }
        int index = hash(key);
        HashItem<K, V> item = HashTable[index];
        while (item != null) {
            if (item.getKey().equals(key)) {
                return item.getValue();
            }
            item = item.getNextItem();
        }
        return null;
    }

    public V remove(K key) {
        int index = hash(key);
        HashItem<K, V> item = HashTable[index];
        if (item == null) {
            return null;
        } else if (item.getKey().equals(key)) {
            HashTable[index] = item.getNextItem();
        } else {
            while (item.getNextItem() != null) {
                HashItem<K, V> nextItem = item.getNextItem();
                if (nextItem.getKey().equals(key)) {
                    V val = nextItem.getValue();
                    item.setNextItem(nextItem.getNextItem());
                    size--;
                    if (shouldDecreaseCap()) resize(capacity / 2);
                    return val;
                }
            }
        }
        return null;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    private boolean shouldIncreaseCap() {
        return size / (double) capacity > Constants.LOAD_INCREASE_CAP;
    }

    private boolean shouldDecreaseCap() {
        return size / (double) capacity > Constants.LOAD_DECREASE_CAP;
    }

    private void resize(int capacity) {
        System.out.println("Resizing Hash Table");
        HashItem<K, V>[] currentTable = HashTable;
        this.HashTable = new HashItem[capacity * 2];
        this.size = 0;
        this.capacity = capacity;
        for (HashItem<K, V> item : currentTable) {
            while (item != null) {
                put(item.getKey(), item.getValue());
                item = item.getNextItem();
            }
        }
    }

}
