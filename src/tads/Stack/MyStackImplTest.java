package tads.Stack;

class MyStackImplTest {

    MyStackImpl<String> myStackPrueba = new MyStackImpl<>();


    @org.junit.jupiter.api.Test
    void isEmpty() {
        System.out.println("La lista Stack está vacia? " + myStackPrueba.isEmpty());
        myStackPrueba.push("Frutilla");
        myStackPrueba.push("Durazno");
        System.out.println("La lista está vacia? " + myStackPrueba.isEmpty());

    }


    @org.junit.jupiter.api.Test
    void push() {
        myStackPrueba.push("Frutilla");
        myStackPrueba.push("Durazno");
        myStackPrueba.push("Naranja");
        System.out.println("La lista Stack está vacia? " + myStackPrueba.isEmpty());
        System.out.println("La lista Stack tiene " + myStackPrueba.size() + " elementos");

    }


    @org.junit.jupiter.api.Test
    void pop() throws EmptyStackException {
        myStackPrueba.push("Frutilla");
        myStackPrueba.push("Durazno");
        myStackPrueba.push("Naranja");
        System.out.println("La lista Stack está vacia? " + myStackPrueba.isEmpty());
        System.out.println("La lista Stack tiene " + myStackPrueba.size() + " elementos");
        myStackPrueba.pop();
        System.out.println("La lista Stack tiene " + myStackPrueba.size() + " elementos");
        System.out.println(myStackPrueba.contains("Durazno"));
        System.out.println(myStackPrueba.contains("Frutilla"));

    }


    @org.junit.jupiter.api.Test
    void top() {
        myStackPrueba.push("Frutilla");
        myStackPrueba.push("Durazno");
        myStackPrueba.push("Naranja");
        System.out.println(myStackPrueba.top());
    }


    @org.junit.jupiter.api.Test
    void size() {
        myStackPrueba.push("Frutilla");
        myStackPrueba.push("Durazno");
        myStackPrueba.push("Naranja");
        System.out.println("La lista Stack tiene " + myStackPrueba.size() + " elementos");
    }


    @org.junit.jupiter.api.Test
    void makeEmpty() throws EmptyStackException {
        myStackPrueba.push("Frutilla");
        myStackPrueba.push("Durazno");
        myStackPrueba.push("Naranja");
        myStackPrueba.makeEmpty();
        System.out.println("La lista Stack tiene " + myStackPrueba.size() + " elementos");

    }


    @org.junit.jupiter.api.Test
    void contains() {
        myStackPrueba.push("Frutilla");
        myStackPrueba.push("Durazno");
        myStackPrueba.push("Naranja");
        System.out.println(myStackPrueba.contains("Durazno"));
        System.out.println(myStackPrueba.contains("Frutilla"));
        System.out.println(myStackPrueba.contains("Pera"));
        System.out.println(myStackPrueba.contains("Naranja"));

    }


}