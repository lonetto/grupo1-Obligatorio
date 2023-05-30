package uy.edu.um.prog2.adt.tads.BinarySearchTree;

import org.junit.jupiter.api.Test;
import uy.edu.um.prog2.adt.tads.BinarySearchTree.BinarySearchTreeImpl;
import uy.edu.um.prog2.adt.tads.BinarySearchTree.MyBinarySearchTree;
import uy.edu.um.prog2.adt.tads.LinkedList.MyLinkedList;

import static org.junit.jupiter.api.Assertions.*;
class BinarySearchTreeImplTest {

    @Test
    public void testFindArbolVacio() {
        MyBinarySearchTree<Integer, String> arbolDePrueba= new BinarySearchTreeImpl<>();

        assertEquals(null, arbolDePrueba.find(1));
    }

    @Test
    public void testFindValido() {
        MyBinarySearchTree<Integer, String> arbolDePrueba= new BinarySearchTreeImpl<>();

        arbolDePrueba.insert(1, "Value1");
        arbolDePrueba.insert(2, "Value2");
        arbolDePrueba.insert(-1, "Value3");

        assertEquals("Value1", arbolDePrueba.find(1));
        assertEquals("Value2", arbolDePrueba.find(2));
        assertEquals("Value3", arbolDePrueba.find(-1));
    }
    @Test
    public void testFindElementoNoIngresado() {
        MyBinarySearchTree<Integer, String> arbolDePrueba = new BinarySearchTreeImpl<>();

        arbolDePrueba.insert(1, "Value1");
        arbolDePrueba.insert(2, "Value2");

        assertEquals(null, arbolDePrueba.find(3));
    }

        @Test
    public void testInsertValido() {
        MyBinarySearchTree<Integer, String> arbolDePrueba= new BinarySearchTreeImpl<>();

        arbolDePrueba.insert(1, "Value1");
        arbolDePrueba.insert(2, "Value2");
        arbolDePrueba.insert(21, "Value3");
        arbolDePrueba.insert(-1, "Value4");

        assertEquals("Value1", arbolDePrueba.find(1));
        assertEquals("Value2", arbolDePrueba.find(2));
        assertEquals("Value3", arbolDePrueba.find(21));
        assertEquals("Value4", arbolDePrueba.find(-1));

    }

    @Test
    public void testInsertInvalido(){
        MyBinarySearchTree<Integer, String> arbolDePrueba= new BinarySearchTreeImpl<>();

        arbolDePrueba.insert(null, "Valor1");
        arbolDePrueba.insert(1, null);
    }

    //Testeamos que cuando insertamos elementos, se hagan en el orden adecuado
    @Test
    public void testInOrder(){
        MyBinarySearchTree<Integer, String> arbolDePrueba= new BinarySearchTreeImpl<>();

        arbolDePrueba.insert(1, "Valor1");
        arbolDePrueba.insert(20, "Valor2");
        arbolDePrueba.insert(-1, "Valor1");
        arbolDePrueba.insert(30, "Valor1");
        arbolDePrueba.insert(15, "Valor1");
        arbolDePrueba.insert(9, "Valor1");

        MyLinkedList<Integer> recorrida = arbolDePrueba.inOrder();

        assertEquals(-1, recorrida.get(0));
        assertEquals(1, recorrida.get(1));
        assertEquals(9, recorrida.get(2));
        assertEquals(15, recorrida.get(3));
        assertEquals(20, recorrida.get(4));
        assertEquals(30, recorrida.get(5));

    }

    @Test
    public void deleteEnArbolVacio(){
        MyBinarySearchTree<Integer, String> arbolDePrueba= new BinarySearchTreeImpl<>();

        arbolDePrueba.delete(1);
    }

    @Test
    public void deleteElementoEnArbol() {
        MyBinarySearchTree<Integer, String> arbolDePrueba= new BinarySearchTreeImpl<>();

        arbolDePrueba.insert(1, "Value1");
        arbolDePrueba.insert(2, "Value2");
        arbolDePrueba.insert(21, "Value3");
        arbolDePrueba.insert(-1, "Value4");

        arbolDePrueba.delete(1);
        arbolDePrueba.delete(2);

        assertEquals(null, arbolDePrueba.find(1));
        assertEquals(null, arbolDePrueba.find(2));
        assertEquals("Value3", arbolDePrueba.find(21));
        assertEquals("Value4", arbolDePrueba.find(-1));

    }

    @Test
    public void deleteElementoNoIngresado() {
        MyBinarySearchTree<Integer, String> arbolDePrueba= new BinarySearchTreeImpl<>();

        arbolDePrueba.insert(1, "Value1");

        arbolDePrueba.delete(30);
    }


    @Test
    public void sizeArbolConElementos() {
        MyBinarySearchTree<Integer, String> arbolDePrueba= new BinarySearchTreeImpl<>();

        arbolDePrueba.insert(1, "Value1");
        arbolDePrueba.insert(2, "Value2");

        assertEquals(2, arbolDePrueba.size());
    }

    @Test
    public void sizeArbolVacio() {
        MyBinarySearchTree<Integer, String> arbolDePrueba= new BinarySearchTreeImpl<>();

        assertEquals(0, arbolDePrueba.size());
    }
}