package tads.BinarySearchTree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class BinarySearchTreeTest {

    @Test
    public void testFindArbolVacio() {
        MyBinarySearchTree<Integer, String> arbolDePrueba= new BinarySearchTree<>();

        assertEquals(null, arbolDePrueba.find(1));
    } //No se como probarlo con la excepcion

    @Test
    public void testFindValido() {
        MyBinarySearchTree<Integer, String> arbolDePrueba= new BinarySearchTree<>();

        arbolDePrueba.insert(1, "Value1");
        arbolDePrueba.insert(2, "Value2");
        arbolDePrueba.insert(-1, "Value3");

        assertEquals("Value1", arbolDePrueba.find(1));
        assertEquals("Value2", arbolDePrueba.find(2));
        assertEquals("Value3", arbolDePrueba.find(-1));
    }
    @Test
    public void testFindElementoNoIngresado() {
        MyBinarySearchTree<Integer, String> arbolDePrueba = new BinarySearchTree<>();

        arbolDePrueba.insert(1, "Value1");
        arbolDePrueba.insert(2, "Value2");

        assertEquals(null, arbolDePrueba.find(3));
    }

        @Test
    public void testInsertValido() {
        MyBinarySearchTree<Integer, String> arbolDePrueba= new BinarySearchTree<>();

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
        //Se me ocurre que si se intenta insertar un elemento null que largue una excepcion, pero para eso
        //habria que cambiar el codigo de la tad
    }

    @Test
    public void delete() {

    }


    @Test
    void size() {
    }
}