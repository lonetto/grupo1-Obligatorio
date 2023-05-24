package tads.Queue;

class MyQueueImplTest {


    MyQueueImpl<String> pruebaQueue = new MyQueueImpl<>();


    @org.junit.jupiter.api.Test
    void isEmpty() {
        pruebaQueue.enqueue("Frutilla");
        pruebaQueue.enqueue("Naranja");
        pruebaQueue.enqueue("Banana");
        System.out.println("La lista está vacia? " + pruebaQueue.isEmpty());
    }


    @org.junit.jupiter.api.Test
    void enqueue() {
        pruebaQueue.enqueue("Frutilla");
        pruebaQueue.enqueue("Naranja");
        pruebaQueue.enqueue("Banana");
        System.out.println("La lista está vacia? " + pruebaQueue.isEmpty());
        System.out.println(pruebaQueue.getFirst());
        System.out.println("La lista tiene " + pruebaQueue.size() + " elementos");
    }


    @org.junit.jupiter.api.Test
    void dequeue() throws EmptyQueueException {
        pruebaQueue.enqueue("Frutilla");
        pruebaQueue.enqueue("Naranja");
        pruebaQueue.enqueue("Banana");
        System.out.println("La lista está vacia? " + pruebaQueue.isEmpty());
        System.out.println(pruebaQueue.getFirst());
        System.out.println("La lista tiene " + pruebaQueue.size() + " elementos");
        pruebaQueue.dequeue();
        System.out.println(pruebaQueue.getFirst());
        pruebaQueue.dequeue();
        System.out.println(pruebaQueue.getFirst());
    }


    @org.junit.jupiter.api.Test
    void size() {
        pruebaQueue.enqueue("Frutilla");
        pruebaQueue.enqueue("Naranja");
        pruebaQueue.enqueue("Banana");
        System.out.println("La lista tiene " + pruebaQueue.size() + " elementos");
    }


    @org.junit.jupiter.api.Test
    void getFirst() throws EmptyQueueException {
        pruebaQueue.enqueue("Frutilla");
        pruebaQueue.enqueue("Naranja");
        pruebaQueue.enqueue("Banana");
        System.out.println(pruebaQueue.getFirst());
        pruebaQueue.dequeue();
        System.out.println(pruebaQueue.getFirst());
    }


    @org.junit.jupiter.api.Test
    void getLast() {
        pruebaQueue.enqueue("Frutilla");
        pruebaQueue.enqueue("Naranja");
        pruebaQueue.enqueue("Banana");
        System.out.println(pruebaQueue.getLast());
        pruebaQueue.enqueue("Durazno");
        System.out.println(pruebaQueue.getLast());
    }


    @org.junit.jupiter.api.Test
    void contains() {
        pruebaQueue.enqueue("Frutilla");
        pruebaQueue.enqueue("Naranja");
        pruebaQueue.enqueue("Banana");
        System.out.println(pruebaQueue.contains("Frutilla"));
        System.out.println(pruebaQueue.contains("Banana"));
        System.out.println(pruebaQueue.contains("Naranja"));
        System.out.println(pruebaQueue.contains("Pera"));
    }


}