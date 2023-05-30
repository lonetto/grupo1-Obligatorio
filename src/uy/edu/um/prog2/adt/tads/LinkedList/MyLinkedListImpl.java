package uy.edu.um.prog2.adt.tads.LinkedList;

public class MyLinkedListImpl<T> implements MyLinkedList<T> {

    private NodeLinkedList<T> head; /* Primer elemento de la lista */

    public MyLinkedListImpl() { this.head = head; }

    public MyLinkedListImpl(T valor){
        this.head = new NodeLinkedList(valor);
    }

    @Override
    public void add(T value) {
        if (this.head == null) {
            this.head = new NodeLinkedList(value);
        } else {
            NodeLinkedList<T> tmp = this.head;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            NodeLinkedList<T> newNode = new NodeLinkedList(value);
            tmp.setNext(newNode);
        }
    }

    @Override
    public boolean remove(int position) {
        //Retorna true si borra el elemento o retorna false si no lo encuentra
        int count = 0;

        //Cuando la posicion excede el tamaño de la lista
        if(position > size()){
            return false;
        }

        //Cuando la posicion que se desea borrar es la cero
        if(position == 0){
            this.head = this.head.getNext();
            return true;
        } else{
            //Cuando la posicion que se desea borrar es cualquiera de la lista
            NodeLinkedList<T> tmp = this.head;
            while(count < position - 1){
                tmp = tmp.getNext();
                count ++;
            }
            tmp.setNext(tmp.getNext().getNext());
            return true;
        }
    }

    @Override
    public T get(int position) {
        //Cuando la posicion excede el tamaño de la lista
        if(position > size()) {
            return null;
        } else{
            NodeLinkedList<T> tmp = this.head;
            while (position > 0){
                tmp = tmp.getNext();
                position = position - 1;
            }
            if (tmp == null){
                return null;
            }
            return tmp.getValue();
        }
    }

    @Override
    public int size() {
        int count = 0;
        NodeLinkedList<T> tmp = this.head;
        if(tmp == null) {
            return 0;
        }
        while (tmp != null) {
            tmp = tmp.getNext();
            count++;
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        if(this.head == null){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public boolean contains(T value) {
        NodeLinkedList<T> tmp = this.head;
        while (tmp != null){
            if (tmp.getValue().equals(value)){
                return true;
            }
            tmp = tmp.getNext();
        }
        return false;
    }

    @Override
    public void addFirst(T value) {

        NodeLinkedList<T> tmp = new NodeLinkedList<>(value); //Este es el nuevo primer nodo

        //Caso en el que la LinkedList está vacía
        if(this.head == null){
            this.head = tmp;
        } else{
            //Resto de los casos, donde ya hay elementos en la lista
            NodeLinkedList<T> tmp2 = this.head; //Este es el primer nodo que ahora pasa a ser el segundo nodo
            tmp.setNext(tmp2); //Al nuevo nodo le seteo como proximo el que era primero antes, o sea, el segundo actualmente
            this.head = tmp;
        }
    }

    @Override
    public void addLast(T value) {
        add(value);
    }

}
