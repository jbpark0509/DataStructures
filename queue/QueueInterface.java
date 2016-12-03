package com.company.queue;

/**
 * Created by jbpark on 2016-12-03.
 */
public interface QueueInterface<T extends Comparable<T>> {

    public void enqueue(T data);
    public T dequeue();
    public boolean isEmpty();

}
