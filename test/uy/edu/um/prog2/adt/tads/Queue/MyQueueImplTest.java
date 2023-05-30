package uy.edu.um.prog2.adt.tads.Queue;

import uy.edu.um.prog2.adt.tads.Queue.MyQueueImpl;
import uy.edu.um.prog2.adt.tads.Queue.exceptions.EmptyQueueException;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyQueueImplTest {


    MyQueueImpl<String> pruebaQueue = new MyQueueImpl<>();


    @org.junit.jupiter.api.Test
    void isEmpty() {
        pruebaQueue.enqueue("Frutilla");
        pruebaQueue.enqueue("Naranja");
        pruebaQueue.enqueue("Banana");

        boolean resultado = pruebaQueue.isEmpty();

        assertEquals(false, resultado);

        //System.out.println("La lista está vacia? " + pruebaQueue.isEmpty());
    }


    @org.junit.jupiter.api.Test
    void enqueue() {
        pruebaQueue.enqueue("Frutilla");
        pruebaQueue.enqueue("Naranja");
        pruebaQueue.enqueue("Banana");

        boolean resultado0 = pruebaQueue.contains("Frutilla");
        boolean resultado1 = pruebaQueue.contains("Naranja");
        boolean resultado2 = pruebaQueue.contains("Banana");

        assertTrue(resultado0);
        assertTrue(resultado1);
        assertTrue(resultado2);

        /*
        System.out.println("La lista está vacia? " + pruebaQueue.isEmpty());
        System.out.println(pruebaQueue.getFirst());
        System.out.println("La lista tiene " + pruebaQueue.size() + " elementos");
        */
    }


    @org.junit.jupiter.api.Test
    void dequeue() throws EmptyQueueException {
        pruebaQueue.enqueue("Frutilla");
        pruebaQueue.enqueue("Naranja");
        pruebaQueue.enqueue("Banana");

        boolean resultado0 = pruebaQueue.contains("Frutilla");
        boolean resultado1 = pruebaQueue.contains("Naranja");
        boolean resultado2 = pruebaQueue.contains("Banana");

        assertTrue(resultado0);
        assertTrue(resultado1);
        assertTrue(resultado2);

        pruebaQueue.dequeue();

        resultado0 = pruebaQueue.contains("Naranja");
        resultado1 = pruebaQueue.contains("Banana");

        assertTrue(resultado0);
        assertTrue(resultado1);

        /*
        System.out.println("La lista está vacia? " + pruebaQueue.isEmpty());
        System.out.println(pruebaQueue.getFirst());
        System.out.println("La lista tiene " + pruebaQueue.size() + " elementos");
        pruebaQueue.dequeue();
        System.out.println(pruebaQueue.getFirst());
        pruebaQueue.dequeue();
        System.out.println(pruebaQueue.getFirst());
        */
    }


    @org.junit.jupiter.api.Test
    void size() {
        pruebaQueue.enqueue("Frutilla");
        pruebaQueue.enqueue("Naranja");
        pruebaQueue.enqueue("Banana");

        assertEquals(3, pruebaQueue.size());

        //System.out.println("La lista tiene " + pruebaQueue.size() + " elementos");
    }


    @org.junit.jupiter.api.Test
    void getFirst() throws EmptyQueueException {
        pruebaQueue.enqueue("Frutilla");
        pruebaQueue.enqueue("Naranja");
        pruebaQueue.enqueue("Banana");

        String resultado0 = pruebaQueue.getFirst();

        assertEquals("Frutilla", resultado0);

        /*
        System.out.println(pruebaQueue.getFirst());
        pruebaQueue.dequeue();
        System.out.println(pruebaQueue.getFirst());
        */
    }


    @org.junit.jupiter.api.Test
    void getLast() {
        pruebaQueue.enqueue("Frutilla");
        pruebaQueue.enqueue("Naranja");
        pruebaQueue.enqueue("Banana");

        String resultado0 = pruebaQueue.getLast();

        assertEquals("Banana", resultado0);
    }


    @org.junit.jupiter.api.Test
    void contains() {
        pruebaQueue.enqueue("Frutilla");
        pruebaQueue.enqueue("Naranja");
        pruebaQueue.enqueue("Banana");

        boolean resultado0 = pruebaQueue.contains("Frutilla");
        boolean resultado1 = pruebaQueue.contains("Naranja");
        boolean resultado2 = pruebaQueue.contains("Banana");

        assertTrue(resultado0);
        assertTrue(resultado1);
        assertTrue(resultado2);

        /*
        System.out.println(pruebaQueue.contains("Frutilla"));
        System.out.println(pruebaQueue.contains("Banana"));
        System.out.println(pruebaQueue.contains("Naranja"));
        System.out.println(pruebaQueue.contains("Pera"));
        */
    }


}