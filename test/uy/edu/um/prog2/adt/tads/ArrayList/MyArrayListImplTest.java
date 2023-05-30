package uy.edu.um.prog2.adt.tads.ArrayList;

import uy.edu.um.prog2.adt.tads.ArrayList.MyArrayListImpl;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyArrayListImplTest {


    MyArrayListImpl<String> arrayPrueba = new MyArrayListImpl<>(10);


    @org.junit.jupiter.api.Test
    void add() {
        arrayPrueba.add("Frutilla");
        arrayPrueba.add("Durazno");
        arrayPrueba.add("Pera");
        assertTrue(arrayPrueba.get(0) == "Frutilla");
        assertTrue(arrayPrueba.get(1) == "Durazno");
        assertTrue(arrayPrueba.get(2) == "Pera");


       /* System.out.println(arrayPrueba.get(0));
        System.out.println(arrayPrueba.get(1));
        System.out.println(arrayPrueba.get(2));
        System.out.println(arrayPrueba.get(3));

        */
    }


    @org.junit.jupiter.api.Test
    void get() {
        arrayPrueba.add("Frutilla");
        arrayPrueba.add("Durazno");
        arrayPrueba.add("Pera");

        String resultado0 = arrayPrueba.get(0);
        String resultado1 = arrayPrueba.get(1);
        String resultado2 = arrayPrueba.get(2);

        assertEquals("Frutilla", resultado0);
        assertEquals("Durazno", resultado1);
        assertEquals("Pera", resultado2);


        /*
        System.out.println(arrayPrueba.get(0));
        System.out.println(arrayPrueba.get(1));
        System.out.println(arrayPrueba.get(2));
        System.out.println(arrayPrueba.get(3));

         */
    }


    @org.junit.jupiter.api.Test
    void delete() {
        arrayPrueba.add("Frutilla");
        arrayPrueba.add("Durazno");
        arrayPrueba.add("Pera");

        String resultado0 = arrayPrueba.get(0);
        String resultado1 = arrayPrueba.get(1);
        String resultado2 = arrayPrueba.get(2);

        assertEquals("Frutilla", resultado0);
        assertEquals("Durazno", resultado1);
        assertEquals("Pera", resultado2);

        arrayPrueba.delete("Frutilla");

        resultado0 = arrayPrueba.get(0);

        assertEquals("Durazno", resultado0);

        /*
        System.out.println(arrayPrueba.get(0));
        System.out.println(arrayPrueba.get(1));
        System.out.println(arrayPrueba.get(2));
        arrayPrueba.delete("Frutilla");
        System.out.println(arrayPrueba.get(0));
        System.out.println(arrayPrueba.get(1));
        System.out.println(arrayPrueba.get(2));

         */
    }


    @org.junit.jupiter.api.Test
    void contains() {
        arrayPrueba.add("Frutilla");
        arrayPrueba.add("Durazno");
        arrayPrueba.add("Pera");

        boolean resultado0 = arrayPrueba.contains("Frutilla");
        boolean resultado1 = arrayPrueba.contains("Durazno");
        boolean resultado2 = arrayPrueba.contains("Pera");

        assertTrue(resultado0);
        assertTrue(resultado1);
        assertTrue(resultado2);


       /*
        System.out.println(arrayPrueba.contains("Frutilla"));
        System.out.println(arrayPrueba.contains("Durazno"));
        System.out.println(arrayPrueba.contains("Pera"));
        */
    }


    @org.junit.jupiter.api.Test
    void size() {
        arrayPrueba.add("Frutilla");
        arrayPrueba.add("Durazno");
        arrayPrueba.add("Pera");

        //System.out.println(arrayPrueba.size());

        assertEquals(3, arrayPrueba.size());
    }
}