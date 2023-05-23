package tads.Queue;

public interface MyQueue<T> {
    boolean isEmpty();
    void enqueue(T elemento);
    T dequeue() throws EmptyQueueException;
    int size();
    T getFirst();
    T getLast();
    boolean contains(T value);
}
