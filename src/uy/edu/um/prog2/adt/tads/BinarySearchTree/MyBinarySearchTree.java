package uy.edu.um.prog2.adt.tads.BinarySearchTree;

import uy.edu.um.prog2.adt.tads.LinkedList.MyLinkedList;

public interface MyBinarySearchTree <K extends Comparable <K>, T> {

    T find (K key);
    void insert (K key, T data);
    void delete (K key);
    int size();

    MyLinkedList<K> inOrder();

}
