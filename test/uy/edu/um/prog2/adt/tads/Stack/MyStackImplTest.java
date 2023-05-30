package uy.edu.um.prog2.adt.tads.Stack;

import uy.edu.um.prog2.adt.tads.Stack.MyStackImpl;
import uy.edu.um.prog2.adt.tads.Stack.exceptions.EmptyStackException;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyStackImplTest {

    MyStackImpl<String> myStackPrueba = new MyStackImpl<>();


    @org.junit.jupiter.api.Test
    void isEmpty() {
        myStackPrueba.push("Frutilla");
        myStackPrueba.push("Naranja");
        myStackPrueba.push("Banana");

        boolean resultado = myStackPrueba.isEmpty();

        assertEquals(false, resultado);

    }


    @org.junit.jupiter.api.Test
    void push() {
        myStackPrueba.push("Frutilla");
        myStackPrueba.push("Durazno");
        myStackPrueba.push("Naranja");

        boolean resultado0 = myStackPrueba.contains("Frutilla");
        boolean resultado1 = myStackPrueba.contains("Durazno");
        boolean resultado2 = myStackPrueba.contains("Naranja");

        assertTrue(resultado0);
        assertTrue(resultado1);
        assertTrue(resultado2);

    }


    @org.junit.jupiter.api.Test
    void pop() throws EmptyStackException {
        myStackPrueba.push("Frutilla");
        myStackPrueba.push("Durazno");
        myStackPrueba.push("Naranja");

        boolean resultado0 = myStackPrueba.contains("Frutilla");
        boolean resultado1 = myStackPrueba.contains("Durazno");
        boolean resultado2 = myStackPrueba.contains("Naranja");

        assertTrue(resultado0);
        assertTrue(resultado1);
        assertTrue(resultado2);

        myStackPrueba.pop();

        String nuevoResultado = myStackPrueba.top();

       assertEquals("Durazno", nuevoResultado);

    }


    @org.junit.jupiter.api.Test
    void top() {
        myStackPrueba.push("Frutilla");
        myStackPrueba.push("Durazno");
        myStackPrueba.push("Naranja");

        String resultado = myStackPrueba.top();

        assertEquals("Naranja", resultado);
    }


    @org.junit.jupiter.api.Test
    void size() {
        myStackPrueba.push("Frutilla");
        myStackPrueba.push("Durazno");
        myStackPrueba.push("Naranja");

        assertEquals(3, myStackPrueba.size());

    }


    @org.junit.jupiter.api.Test
    void makeEmpty() throws EmptyStackException {
        myStackPrueba.push("Frutilla");
        myStackPrueba.push("Durazno");
        myStackPrueba.push("Naranja");

        boolean resultado0 = myStackPrueba.contains("Frutilla");
        boolean resultado1 = myStackPrueba.contains("Durazno");
        boolean resultado2 = myStackPrueba.contains("Naranja");

        assertTrue(resultado0);
        assertTrue(resultado1);
        assertTrue(resultado2);

        myStackPrueba.makeEmpty();

        boolean resultado = myStackPrueba.isEmpty();

        assertTrue(resultado);

    }


    @org.junit.jupiter.api.Test
    void contains() {
        myStackPrueba.push("Frutilla");
        myStackPrueba.push("Durazno");
        myStackPrueba.push("Naranja");

        boolean resultado0 = myStackPrueba.contains("Frutilla");
        boolean resultado1 = myStackPrueba.contains("Durazno");
        boolean resultado2 = myStackPrueba.contains("Naranja");

        assertTrue(resultado0);
        assertTrue(resultado1);
        assertTrue(resultado2);


    }


}