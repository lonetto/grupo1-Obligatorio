package uy.edu.um.prog2.adt.tads.LinkedList;

import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.tads.LinkedList.MyLinkedListImpl;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MyLinkedListImplTest {

    MyLinkedListImpl<String> listaPrueba = new MyLinkedListImpl<>();

    @Test
    void add() {

        listaPrueba.add("Banana"); //Elemento 0
        listaPrueba.add("Naranja"); //Elemento 1
        listaPrueba.add("Manzana"); //Elemento 2
        listaPrueba.add("Pera"); //Elemento 3
        listaPrueba.add("Uva"); //Elemento 4
        listaPrueba.add("Mandarina"); //Elemento 5
        listaPrueba.add("Durazno"); //Elemento 6

        assertTrue(listaPrueba.get(0) == "Banana");
        assertTrue(listaPrueba.get(1) == "Naranja");
        assertTrue(listaPrueba.get(2) == "Manzana");
        assertTrue(listaPrueba.get(3) == "Pera");
        assertTrue(listaPrueba.get(4) == "Uva");
        assertTrue(listaPrueba.get(5) == "Mandarina");
        assertTrue(listaPrueba.get(6) == "Durazno");

        /*
        System.out.println(listaPrueba.get(0));
        System.out.println(listaPrueba.get(2));
        System.out.println(listaPrueba.get(6));
        System.out.println(listaPrueba.get(7));
        System.out.println(listaPrueba.get(4));
        */
    }


    @Test
    void remove() {

        listaPrueba.add("Banana"); //Elemento 0
        listaPrueba.add("Naranja"); //Elemento 1
        listaPrueba.add("Manzana"); //Elemento 2

        String resultado0 = listaPrueba.get(0);
        String resultado1 = listaPrueba.get(1);
        String resultado2 = listaPrueba.get(2);

        assertEquals("Banana", resultado0);
        assertEquals("Naranja", resultado1);
        assertEquals("Manzana", resultado2);

        listaPrueba.remove(0);

        resultado0 = listaPrueba.get(0);

        assertEquals("Naranja", resultado0);

        /*
        System.out.println(listaPrueba.get(0));
        System.out.println(listaPrueba.get(2));
        System.out.println(listaPrueba.get(6));
        System.out.println(listaPrueba.get(7));
        System.out.println(listaPrueba.get(4));
        listaPrueba.remove(0);
        System.out.println(listaPrueba.get(0));
        System.out.println(listaPrueba.size());
         */
    }

    @Test
    void get() {

        listaPrueba.add("Banana"); //Elemento 0
        listaPrueba.add("Naranja"); //Elemento 1
        listaPrueba.add("Manzana"); //Elemento 2

        String resultado0 = listaPrueba.get(0);
        String resultado1 = listaPrueba.get(1);
        String resultado2 = listaPrueba.get(2);

        assertEquals("Banana", resultado0);
        assertEquals("Naranja", resultado1);
        assertEquals("Manzana", resultado2);

        /*
        System.out.println(listaPrueba.get(0));
        System.out.println(listaPrueba.get(2));
        System.out.println(listaPrueba.get(6));
        System.out.println(listaPrueba.get(7));
        System.out.println(listaPrueba.get(4));

         */
    }

    @Test
    void size() {

        listaPrueba.add("Banana"); //Elemento 0
        listaPrueba.add("Naranja"); //Elemento 1
        listaPrueba.add("Manzana"); //Elemento 2

        assertEquals(3, listaPrueba.size());

        /*
        System.out.println(listaPrueba.get(0));
        System.out.println(listaPrueba.get(2));
        System.out.println(listaPrueba.get(6));
        System.out.println(listaPrueba.get(7));
        System.out.println(listaPrueba.get(4));
        System.out.println(listaPrueba.size());

         */
    }

    @Test
    void isEmpty() {
        listaPrueba.add("Banana"); //Elemento 0
        listaPrueba.add("Naranja"); //Elemento 1
        listaPrueba.add("Manzana"); //Elemento 2

        boolean resultado = listaPrueba.isEmpty();

        assertEquals(false, resultado);

        //System.out.println("La lista está vacía? " + listaPrueba.isEmpty());
    }

    @Test
    void contains() {

        listaPrueba.add("Banana"); //Elemento 0
        listaPrueba.add("Naranja"); //Elemento 1
        listaPrueba.add("Manzana"); //Elemento 2

        boolean resultado0 = listaPrueba.contains("Banana");
        boolean resultado1 = listaPrueba.contains("Naranja");
        boolean resultado2 = listaPrueba.contains("Manzana");

        assertTrue(resultado0);
        assertTrue(resultado1);
        assertTrue(resultado2);

        /*System.out.println(listaPrueba.contains("Banana"));
        System.out.println(listaPrueba.contains("Manzana"));
        System.out.println(listaPrueba.contains("Durazno"));
        System.out.println(listaPrueba.contains("Frutilla"));
        System.out.println(listaPrueba.contains("Uva"));

         */
    }

    @Test
    void addFirst() {
        listaPrueba.add("Banana"); //Elemento 0
        listaPrueba.add("Naranja"); //Elemento 1
        listaPrueba.add("Manzana"); //Elemento 2

        String resultado0 = listaPrueba.get(0);
        String resultado1 = listaPrueba.get(1);
        String resultado2 = listaPrueba.get(2);

        assertEquals("Banana", resultado0);
        assertEquals("Naranja", resultado1);
        assertEquals("Manzana", resultado2);

        listaPrueba.addFirst("Frutilla");

         resultado0 = listaPrueba.get(0);
         resultado1 = listaPrueba.get(1);
         resultado2 = listaPrueba.get(2);
         String resultado3 = listaPrueba.get(3);

        assertEquals("Frutilla", resultado0);
        assertEquals("Banana", resultado1);
        assertEquals("Naranja", resultado2);
        assertEquals("Manzana", resultado3);

        /*
        System.out.println(listaPrueba.get(0));
        System.out.println(listaPrueba.get(2));
        System.out.println(listaPrueba.get(6));
        System.out.println(listaPrueba.get(7));
        System.out.println(listaPrueba.get(4));
        listaPrueba.addFirst("Frutilla");
        System.out.println(listaPrueba.get(0)); //El nuevo elemento 0 es Frutilla
        System.out.println(listaPrueba.get(2)); //El nuevo elemento 2 es Naranja
        System.out.println(listaPrueba.get(6)); //El nuevo elemento 6 es Mandarina
        System.out.println(listaPrueba.get(7)); //El nuevo elemento 7 es Durzano
        System.out.println(listaPrueba.get(4)); //El nuevo elemento 4 es Pera
        */
    }

    @Test
    void addLast() {
        //No necesita de pruebas ya que se usa el metodo add del comienzo. Por ende, ya probando el metodo add estaria listo.
    }
}