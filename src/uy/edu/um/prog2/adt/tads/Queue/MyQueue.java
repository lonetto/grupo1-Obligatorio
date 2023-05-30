package uy.edu.um.prog2.adt.tads.Queue;

import uy.edu.um.prog2.adt.tads.Queue.exceptions.EmptyQueueException;

public interface MyQueue<T> {
    boolean isEmpty();
    void enqueue(T elemento);
    T dequeue() throws EmptyQueueException;
    int size();
    T getFirst();
    T getLast();
    boolean contains(T value);
}
