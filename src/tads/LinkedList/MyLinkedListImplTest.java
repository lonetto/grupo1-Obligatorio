package tads.LinkedList;

import org.junit.jupiter.api.Test;

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
        System.out.println(listaPrueba.get(0));
        System.out.println(listaPrueba.get(2));
        System.out.println(listaPrueba.get(6));
        System.out.println(listaPrueba.get(7));
        System.out.println(listaPrueba.get(4));
    }


    @Test
    void remove() {

        listaPrueba.add("Banana"); //Elemento 0
        listaPrueba.add("Naranja"); //Elemento 1
        listaPrueba.add("Manzana"); //Elemento 2
        listaPrueba.add("Pera"); //Elemento 3
        listaPrueba.add("Uva"); //Elemento 4
        listaPrueba.add("Mandarina"); //Elemento 5
        listaPrueba.add("Durazno"); //Elemento 6
        System.out.println(listaPrueba.get(0));
        System.out.println(listaPrueba.get(2));
        System.out.println(listaPrueba.get(6));
        System.out.println(listaPrueba.get(7));
        System.out.println(listaPrueba.get(4));
        listaPrueba.remove(0);
        System.out.println(listaPrueba.get(0));
        System.out.println(listaPrueba.size());
    }

    @Test
    void get() {

        listaPrueba.add("Banana"); //Elemento 0
        listaPrueba.add("Naranja"); //Elemento 1
        listaPrueba.add("Manzana"); //Elemento 2
        listaPrueba.add("Pera"); //Elemento 3
        listaPrueba.add("Uva"); //Elemento 4
        listaPrueba.add("Mandarina"); //Elemento 5
        listaPrueba.add("Durazno"); //Elemento 6
        System.out.println(listaPrueba.get(0));
        System.out.println(listaPrueba.get(2));
        System.out.println(listaPrueba.get(6));
        System.out.println(listaPrueba.get(7));
        System.out.println(listaPrueba.get(4));
    }

    @Test
    void size() {

        listaPrueba.add("Banana"); //Elemento 0
        listaPrueba.add("Naranja"); //Elemento 1
        listaPrueba.add("Manzana"); //Elemento 2
        listaPrueba.add("Pera"); //Elemento 3
        listaPrueba.add("Uva"); //Elemento 4
        listaPrueba.add("Mandarina"); //Elemento 5
        listaPrueba.add("Durazno"); //Elemento 6
        System.out.println(listaPrueba.get(0));
        System.out.println(listaPrueba.get(2));
        System.out.println(listaPrueba.get(6));
        System.out.println(listaPrueba.get(7));
        System.out.println(listaPrueba.get(4));
        System.out.println(listaPrueba.size());
    }

    @Test
    void isEmpty() {
        listaPrueba.add("Banana"); //Elemento 0
        listaPrueba.add("Naranja"); //Elemento 1
        listaPrueba.add("Manzana"); //Elemento 2
        listaPrueba.add("Pera"); //Elemento 3
        listaPrueba.add("Uva"); //Elemento 4
        listaPrueba.add("Mandarina"); //Elemento 5
        listaPrueba.add("Durazno"); //Elemento 6
        System.out.println("La lista está vacía? " + listaPrueba.isEmpty());
    }

    @Test
    void contains() {

        listaPrueba.add("Banana"); //Elemento 0
        listaPrueba.add("Naranja"); //Elemento 1
        listaPrueba.add("Manzana"); //Elemento 2
        listaPrueba.add("Pera"); //Elemento 3
        listaPrueba.add("Uva"); //Elemento 4
        listaPrueba.add("Mandarina"); //Elemento 5
        listaPrueba.add("Durazno"); //Elemento 6
        System.out.println(listaPrueba.contains("Banana"));
        System.out.println(listaPrueba.contains("Manzana"));
        System.out.println(listaPrueba.contains("Durazno"));
        System.out.println(listaPrueba.contains("Frutilla"));
        System.out.println(listaPrueba.contains("Uva"));
    }

    @Test
    void addFirst() {
        listaPrueba.add("Banana"); //Elemento 0
        listaPrueba.add("Naranja"); //Elemento 1
        listaPrueba.add("Manzana"); //Elemento 2
        listaPrueba.add("Pera"); //Elemento 3
        listaPrueba.add("Uva"); //Elemento 4
        listaPrueba.add("Mandarina"); //Elemento 5
        listaPrueba.add("Durazno"); //Elemento 6
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

    }

    @Test
    void addLast() {
        //No necesita de pruebas ya que se usa el metodo add del comienzo. Por ende, ya probando el metodo add estaria listo.
    }
}