package uy.edu.um.prog2.adt.tads.ArrayList;

import java.util.Comparator;


public class MyArrayListImpl<T> implements MyArrayList<T> {


    private T[] list;
    private int size;
    private int length;

    public MyArrayListImpl (int length){
        this.list = (T[]) new Object[length];
        this.length = length;
        this.size = 0;
    }


    @Override
    public void add(T value) {
        if(value!=null) {
            if(size == length){
                T[] newlist = (T[]) new Object[2*length];
                for(int i = 0; i < size; i ++){
                    newlist[i] = list[i];
                }
                this.list = newlist;
            }
            else{
                list[size] = value;
                size = size + 1;
            }
        }
    }


    @Override
    public T get(int posicion) {
        if (posicion<size) {
            return list[posicion];
        }else{
            return null;
        }
    }


    @Override
    public void delete(T value) {
        if (value != null && this.contains(value)) {
            int posicion = 0;
            for (int i = 0; i < size; i++) {
                if (list[posicion] != value) {
                    posicion = posicion + 1;
                }
            }
            for (int i = 0; i < (size - posicion) - 1; i++) {
                list[posicion + i] = list[posicion + i + 1];
            }
            list[size - 1] = null;
            size = size - 1;
        }

    }


    @Override
    public boolean contains(T value) {
        if(value != null) {
            for (int i = 0; i < size; i++) {
                if (list[i] == value) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void sort(Comparator<T> reversed) {
        mergeSort(list, reversed, 0, size - 1);
    }

    private void mergeSort(T[] array, Comparator<T> comparator, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, comparator, left, mid);
            mergeSort(array, comparator, mid + 1, right);

            merge(array, comparator, left, mid, right);
        }
    }

    private void merge(T[] array, Comparator<T> comparator, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        T[] L = (T[]) new Object[n1];
        T[] R = (T[]) new Object[n2];

        System.arraycopy(array, left, L, 0, n1);
        System.arraycopy(array, mid + 1, R, 0, n2);

        int i = 0, j = 0;

        int k = left;
        while (i < n1 && j < n2) {
            if (comparator.compare(L[i], R[j]) <= 0) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }


}
