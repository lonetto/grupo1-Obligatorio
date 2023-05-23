package tads.Stack;

public interface MyStack <T> {

    boolean isEmpty();
    void push(T elemento);
    T pop() throws EmptyStackException;
    T top();
    int size();
    void makeEmpty() throws EmptyStackException;
    boolean contains(T value);

}
