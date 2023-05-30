package uy.edu.um.prog2.adt.tads.Stack;

import uy.edu.um.prog2.adt.tads.Stack.exceptions.EmptyStackException;

public class MyStackImpl<T> implements MyStack<T>{


    private NodeStack<T> cima;
    private int size;

    public MyStackImpl(){
        cima = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        //Si no hay cima entonces devuelvo que no hay nada, ya que no habria elementos. En caso contrario, devuelvo que si hay elementos
        if(cima == null){
            return true;
        } else{
            return false;
        }
    }

    @Override
    public void push(T elemento) {
        NodeStack<T> nuevoNodo = new NodeStack<>(elemento); //Creo un nuevo nodo a agregar
        nuevoNodo.setSiguiente(cima); //Al nuevo nodo, le seteo como siguiente el que es la cima actualmente
        cima = nuevoNodo; //Ahora la nueva cima pasa a ser el nodo que quiero agregar
        size++; //Aumento en 1 la cantidad porque agrego 1 elemento
    }

    @Override
    public T pop() throws EmptyStackException {
        //Si no hay elementos entonces lanzo exception
        if(isEmpty()){
            throw new EmptyStackException();
        }
        T auxiliar = cima.getDato();  //Me creo la variable auxiliar para cuando elimine el elemento también lo traigo (lo retorno)
        cima = cima.getSiguiente(); //La cima deja de ser el actual porque se iria para afuera por lo que al siguiente lo asigno como cima. ESTRUCTURA LIFO
        size --; //Al eliminar un elemento entonces disminuyo en 1 la cantidad de elementos
        return auxiliar; //Devuelvo la auxiliar, es decir, el nodo que voy a eliminar tambien lo traigo
    }

    @Override
    public T top() {
        T auxiliar = cima.getDato(); //Creo una variable auxiliar el cual contenga el dato del elemento de la cima
        return auxiliar; //Devuevlo el el auxiliar el cual seria el elemento de la cima
    }

    @Override
    public int size() {
        int auxiliar = size;
        return auxiliar;
    }

    @Override
    public void makeEmpty() throws EmptyStackException {
        //No estoy seguro si está bien el if.
        if(cima == null){
            throw new EmptyStackException();
        }

        while(!isEmpty()){
            pop();
        }
    }

    @Override
    public boolean contains(T value) {
        int position = 0;
        NodeStack<T> tmp = cima;
        boolean esta = false;
        while (position < size() && !esta){
            esta = tmp.getDato().equals(value);
            tmp = tmp.getSiguiente();
            position++;
        }
        return esta;
    }
}
