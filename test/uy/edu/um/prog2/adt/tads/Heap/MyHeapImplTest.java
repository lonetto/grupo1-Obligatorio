package uy.edu.um.prog2.adt.tads.Heap;

import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.tads.Heap.MyHeap;
import uy.edu.um.prog2.adt.tads.Heap.MyHeapImpl;
import uy.edu.um.prog2.adt.tads.Heap.exceptions.EmptyHeapException;

import static org.junit.jupiter.api.Assertions.*;
class MyHeapImplTest {

    @Test
    public void insertValido() {
        MyHeap<Integer> heapDePrueba = new MyHeapImpl<>(10);

        heapDePrueba.insert(5);
        heapDePrueba.insert(10);
        heapDePrueba.insert(3);
        heapDePrueba.insert(8);
        heapDePrueba.insert(7);

        assertEquals(5, heapDePrueba.size());
    }

    @Test
    public void deleteHeapConElementos() throws EmptyHeapException {
        MyHeap<Integer> heapDePrueba = new MyHeapImpl<>(10);

        heapDePrueba.insert(5);
        heapDePrueba.insert(10);
        heapDePrueba.insert(3);
        heapDePrueba.insert(8);
        heapDePrueba.insert(7);

        assertEquals(5, heapDePrueba.size());

        assertEquals(10, heapDePrueba.delete());
        assertEquals(4, heapDePrueba.size());
    }

    @Test
    public void deleteHeapVacio() throws EmptyHeapException{
        MyHeap<Integer> heapDePrueba = new MyHeapImpl<>(10);

        try {
            heapDePrueba.delete();
        }catch(EmptyHeapException e){
            System.out.println("Empty heap");
        }
    }

    @Test
    public void sizeHeapConElementos() {
        MyHeap<Integer> heapDePrueba = new MyHeapImpl<>(10);

        heapDePrueba.insert(5);
        heapDePrueba.insert(10);
        heapDePrueba.insert(3);
        heapDePrueba.insert(8);
        heapDePrueba.insert(-1);

        assertEquals(5, heapDePrueba.size());
    }

    @Test
    public void sizeHeapVacio() {
        MyHeap<Integer> heapDePrueba = new MyHeapImpl<>(10);

        assertEquals(0, heapDePrueba.size());
    }
}