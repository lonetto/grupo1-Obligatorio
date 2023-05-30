package uy.edu.um.prog2.adt.tads.Queue;

import uy.edu.um.prog2.adt.tads.Queue.exceptions.EmptyQueueException;

public class MyQueueImpl<T> implements MyQueue<T> {


    private NodeQueue<T> inicio;
    private NodeQueue<T> fin;
    private int size;

    public MyQueueImpl(){
        inicio = fin = null;
        size = 0;
    }


    @Override
    public boolean isEmpty() {
        if(inicio == null){
            return true;
        } else{
            return false;
        }
    }


    @Override
    public void enqueue(T elemento) {
        //Creo el nodo que quiero agregar a la lista Queue
        NodeQueue<T> tmp = new NodeQueue<>(elemento);
        //Si la lista esta vacia
        if(isEmpty()) {
            inicio = fin = tmp;
        } else { //Si la lista no esta vacia entonces debo setear al ultimo nodo el nuevo nodo tmp creado. Por ultimo, deberia reasignar la variable fin al nodo tmp y sumar 1 a la variable size dado a que se agrego un nuevo nodo
            fin.setSiguiente(tmp);
        }
        fin = tmp;
        size++;
    }


    @Override
    public T dequeue() throws EmptyQueueException {
        //Si la lista Queue es vacia entonces lanzo una excepcion
        if(isEmpty()) {
            throw new EmptyQueueException();
        }
        //Si la lista Queue tiene elementos. Saco el primero por estructura de Queue, FIFO
        T auxiliar = inicio.getDato(); //Creo una variable auxiliar del tipo T para almacenar el dato primero de la lista
        inicio = inicio.getSiguiente(); //El primer nodo, ahora pasa a ser el segundo, ya que lo quiero sacar de la lista
        size--; //Resto 1 porque saco 1 elemento de la lista Queue
        return auxiliar; //Retorno la vairable auxiliar ya que se desea eliminar pero a su vez traerlo
    }


    @Override
    public int size() {
        int auxiliar = size; //Me creo una variable auxiliar a la cual le asigno la variable size y asi retornarla. Tambien se podria retornar directo pero para que quede mas claro lo hago de este modo
        return auxiliar;
    }


    @Override
    public T getFirst() {
        T auxiliar = inicio.getDato(); //Me creo una variable auxiliar a la cual le asigno el dato del primero nodo y asi retornarla. Tambien se podria retornar directo pero para que quede mas claro lo hago de este modo
        return auxiliar;
    }


    @Override
    public T getLast() {
        T auxiliar = fin.getDato(); //Me creo una variable auxiliar a la cual le asigno el dato del ultimo nodo y asi retornarla. Tambien se podria retornar directo pero para que quede mas claro lo hago de este modo
        return auxiliar;
    }


    @Override
    public boolean contains(T value) {
        int position = 0;
        NodeQueue<T> tmp = inicio;
        boolean esta = false;
        while (position<size() && !esta){
            esta = tmp.getDato().equals(value);
            tmp = tmp.getSiguiente();
            position++;
        }
        return esta;
    }


}
