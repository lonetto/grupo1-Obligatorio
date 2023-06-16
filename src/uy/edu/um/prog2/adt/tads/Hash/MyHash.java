package uy.edu.um.prog2.adt.tads.Hash;

import uy.edu.um.prog2.adt.tads.ArrayList.MyArrayList;

public interface MyHash<K,V> {
    void put(K key, V value);
    V get (K key);
    void delete(K key);
    int size();
    boolean isEmpty();
    K keyListaKeys(int lugar);
    MyArrayList<K> getListaDeKeys();
}
