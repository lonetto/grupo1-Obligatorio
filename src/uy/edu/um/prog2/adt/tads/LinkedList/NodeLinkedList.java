package uy.edu.um.prog2.adt.tads.LinkedList;

public class NodeLinkedList<T> {

    private T value;
    private NodeLinkedList next;
    public NodeLinkedList(T value) {
        this.value = value;
        this.next = null;
    }
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public NodeLinkedList getNext() {
        return next;
    }

    public void setNext(NodeLinkedList next) {
        this.next = next;
    }
}
