package uy.edu.um.prog2.adt.tads.Heap;

import uy.edu.um.prog2.adt.tads.Heap.exceptions.EmptyHeapException;

public class MyHeapImpl <T extends Comparable<T>> implements MyHeap<T>{

    private T[] values;
    private int heapSize;

    public MyHeapImpl(int size) {
        this.values = (T[]) new Comparable[size];
        this.heapSize = 0;
    }


    private int getFatherPosition(int position) {
        return (position - 1) / 2;
    }
    private int getLeftChildPosition(int position) {
        return 2 * position + 1;
    }
    private int getRightChildPosition(int position) {
        return 2 * position + 2;
    }


    private int maxPosition(int position1, int position2){
        if (position1 > heapSize && position2 > heapSize){
            return 0; // para que se termine de intercambiar lugares.
        }
        if (position1 <= heapSize && position2 > heapSize){
            return position1;
        }
        if (position1 > heapSize && position2 <= heapSize){
            return position2;
        }
        if (values[position1].compareTo(values[position2])>0){
            return position1;
        } else{
            return position2;
        }
    }


    @Override
    public void insert(T value) {
        int position = heapSize;
        heapSize++;
        values[position] = value;
        while(values[position].compareTo(values[getFatherPosition(position)])>0 && position !=0){
            values[position] = values[getFatherPosition(position)];
            values[getFatherPosition(position)] = value;
            position = getFatherPosition(position);
        }
    }

    @Override
    public T delete() throws EmptyHeapException {
        T returnValue = null;
        if (heapSize == 0){
            throw new EmptyHeapException();
        }
        returnValue = values[0];
        if (heapSize == 1) {
            values[0] = null;
        } else {
            values[0] = values[heapSize - 1];
            int position = 0;
            int childMaxPosition = maxPosition(getLeftChildPosition(position),
                    getRightChildPosition(position));
            while (values[position].compareTo(values[childMaxPosition])<0 &&
                    position < heapSize && childMaxPosition!=0){
                T temp = values[position];
                values[position] = values[childMaxPosition];
                values[childMaxPosition] = temp;
                position = childMaxPosition;
                childMaxPosition = maxPosition(getLeftChildPosition(position),
                        getRightChildPosition(position));
            }
        }
        heapSize--;
        return returnValue;
    }

    @Override
    public int size() {
        return heapSize;
    }

}
