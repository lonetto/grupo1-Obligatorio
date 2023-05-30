package uy.edu.um.prog2.adt.tads.Queue;

public class NodeQueue <T> {
    private T dato;
    private NodeQueue siguiente;

    public NodeQueue(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodeQueue getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodeQueue siguiente) {
        this.siguiente = siguiente;
    }
}
