package tads.ArrayList;

class MyArrayListImplTest {


    MyArrayListImpl<String> arrayPrueba = new MyArrayListImpl<>(10);


    @org.junit.jupiter.api.Test
    void add() {
        arrayPrueba.add("Frutilla");
        arrayPrueba.add("Durazno");
        arrayPrueba.add("Pera");
        System.out.println(arrayPrueba.get(0));
        System.out.println(arrayPrueba.get(1));
        System.out.println(arrayPrueba.get(2));
        System.out.println(arrayPrueba.get(3));
    }


    @org.junit.jupiter.api.Test
    void get() {
        arrayPrueba.add("Frutilla");
        arrayPrueba.add("Durazno");
        arrayPrueba.add("Pera");
        System.out.println(arrayPrueba.get(0));
        System.out.println(arrayPrueba.get(1));
        System.out.println(arrayPrueba.get(2));
        System.out.println(arrayPrueba.get(3));
    }


    @org.junit.jupiter.api.Test
    void delete() {
        arrayPrueba.add("Frutilla");
        arrayPrueba.add("Durazno");
        arrayPrueba.add("Pera");
        System.out.println(arrayPrueba.get(0));
        System.out.println(arrayPrueba.get(1));
        System.out.println(arrayPrueba.get(2));
        arrayPrueba.delete("Frutilla");
        System.out.println(arrayPrueba.get(0));
        System.out.println(arrayPrueba.get(1));
        System.out.println(arrayPrueba.get(2));
    }


    @org.junit.jupiter.api.Test
    void contains() {
        arrayPrueba.add("Frutilla");
        arrayPrueba.add("Durazno");
        arrayPrueba.add("Pera");
        System.out.println(arrayPrueba.contains("Frutilla"));
        System.out.println(arrayPrueba.contains("Durazno"));
        System.out.println(arrayPrueba.contains("Pera"));
    }


    @org.junit.jupiter.api.Test
    void size() {
        arrayPrueba.add("Frutilla");
        arrayPrueba.add("Durazno");
        arrayPrueba.add("Pera");
        System.out.println(arrayPrueba.size());
    }
}