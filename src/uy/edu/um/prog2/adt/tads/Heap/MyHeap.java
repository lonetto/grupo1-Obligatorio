package uy.edu.um.prog2.adt.tads.Heap;

import uy.edu.um.prog2.adt.tads.Heap.exceptions.EmptyHeapException;

public interface MyHeap  <T extends Comparable<T>> {
    void insert(T value);
    T delete() throws EmptyHeapException;
    int size();
}
