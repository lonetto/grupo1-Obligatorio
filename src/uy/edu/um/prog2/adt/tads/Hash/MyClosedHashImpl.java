package uy.edu.um.prog2.adt.tads.Hash;

import uy.edu.um.prog2.adt.tads.ArrayList.MyArrayList;
import uy.edu.um.prog2.adt.tads.ArrayList.MyArrayListImpl;

public class MyClosedHashImpl <K, V> implements MyHash<K, V>{


    private int tableSize; //espacio total del array
    private int currentSize;
    private int occupiedSize; //espacio ocupado en el array (como el current pero tambien cuenta los deleted).
    private MyArrayList<K> listaDeKeys;

    private ClosedHashNode[] tableHash;

    private static final int DEFAULT_INITIAL_TABLE_HASH_SIZE = 100000;

    public void setTableHash(ClosedHashNode[] tableHash) {
        this.tableHash = tableHash;
    }

    public void setOccupiedSize(int occupiedSize) {
        this.occupiedSize = occupiedSize;
    }

    public void setListaDeKeys(MyArrayList<K> listaDeKeys) {
        this.listaDeKeys = listaDeKeys;
    }

    public MyClosedHashImpl(int maxExpectedSize){
        tableHash = new ClosedHashNode[maxExpectedSize];
        tableSize = maxExpectedSize;
        this.listaDeKeys = new MyArrayListImpl<>(maxExpectedSize);
        initVector();
    }

    public MyClosedHashImpl(){
        tableHash = new ClosedHashNode[DEFAULT_INITIAL_TABLE_HASH_SIZE];
        tableSize = DEFAULT_INITIAL_TABLE_HASH_SIZE;
        this.listaDeKeys = new MyArrayListImpl<>(100000);
        initVector();
    }

    private void initVector(){
        for (int i = 0; i< tableSize; i++){
            tableHash[i] = null;
        }
        currentSize = 0;
    }


    @Override
    public void put(K key, V value) {
        if ((float) occupiedSize / tableSize >= 0.7){
            reSize();
        }
        int x = key.hashCode();
        if (key.hashCode()<0){
            x = -key.hashCode();
        }
        int hash = x % tableSize;

        while (tableHash[hash] != null && !(tableHash[hash].isDeleted())){
            hash = (hash + 1) % tableSize;
        }
        tableHash[hash] = new ClosedHashNode<>(key, value);
        currentSize ++;
        occupiedSize ++;
        listaDeKeys.add(key);
    }

    @Override
    public V get(K key) {
        int x = key.hashCode();
        if (key.hashCode()<0){
            x = -key.hashCode();
        }
        int hash = x % tableSize;
        while (tableHash[hash] != null){
            if (tableHash[hash].getKey().equals(key) && !tableHash[hash].isDeleted()){
                return (V) tableHash[hash].getValue();
            }
            hash = (hash + 1) % tableSize;
        }
        return null;
    }

    @Override
    public void delete(K key) {
        int hash = key.hashCode() % tableSize;
        while (tableHash[hash] != null){
            if (tableHash[hash].getKey().equals(key) && !tableHash[hash].isDeleted()){
                tableHash[hash].setDeleted(true);
                currentSize --;
                listaDeKeys.delete(key);
            }
            hash = (hash + 1) % tableSize;
        }
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    public V getPosicion(int posicion){
        K key = listaDeKeys.get(posicion);
        return get(key);
    }

    public MyArrayList<K> getListaDeKeys() {
        return listaDeKeys;
    }

    public K keyListaKeys (int lugarDellArrayList){
        return listaDeKeys.get(lugarDellArrayList);
    }

    private void reSize(){
        this.tableSize = tableSize * 2;
        MyClosedHashImpl newHash = new MyClosedHashImpl(tableSize);
        for (int i = 0; i < tableSize/2 ; i++){
            if (tableHash[i] != null && tableHash[i].isDeleted() == false){
                newHash.put(tableHash[i].getKey(), tableHash[i].getValue());
            }
        }
        setTableHash(newHash.tableHash);
        setOccupiedSize(newHash.occupiedSize);
        setListaDeKeys(newHash.listaDeKeys);
    }
}