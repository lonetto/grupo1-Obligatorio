package uy.edu.um.prog2.adt.tads.Stack;

public class NodeStack<T> {

    private T dato;
    private NodeStack siguiente;

    public NodeStack(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodeStack getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodeStack siguiente) {
        this.siguiente = siguiente;
    }
}
