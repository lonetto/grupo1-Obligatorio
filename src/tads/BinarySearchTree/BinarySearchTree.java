package tads.BinarySearchTree;

public class BinarySearchTree<K extends Comparable<K>, T> implements MyBinarySearchTree<K, T>{

    private int treeSize = 0;
    private NodeBST<K, T> root;
    public NodeBST<K, T> getRoot() {
        return root;
    }
    public void setRoot(NodeBST<K, T> root) {
        this.root = root;
    }


    private NodeBST<K, T> find(K key, NodeBST<K, T> root) throws NotInTreeException {
        NodeBST<K, T> resultado = null;
        if(root != null) {
            if(key.compareTo(root.getKey()) == 0){
                resultado = root;
            } else if (key.compareTo(root.getKey()) < 0) {
                resultado = find(key, root.getLeftChild());
            } else {
                resultado = find(key, root.getRightChild());
            }
        }
        if (resultado == null) {
            throw new NotInTreeException();
        }
        return resultado;
    }

    private NodeBST<K, T> insert(K key, T data, NodeBST<K, T> subtree) {
        NodeBST<K, T> NuevoElemento = new NodeBST<K, T>(key, data);
        if (subtree == null) {
            return NuevoElemento;
        } else {
            if (subtree.getKey().compareTo(key) > 0) { // root key > key
                NodeBST<K, T> NuevoIzquierda = insert(key, data, subtree.getLeftChild());
                subtree.setLeftChild(NuevoIzquierda);
                return subtree;
            } else if (subtree.getKey().compareTo(key) < 0) { // root key < key
                NodeBST<K, T> NuevoDerecha = insert(key, data, subtree.getRightChild());
                subtree.setRightChild(NuevoDerecha);
                return subtree;
            }
        }
        return null;
    }

    public NodeBST delete(K key, NodeBST subtree) throws NotInTreeException {
        if (subtree == null) {
            return null;
        }
        if (this.find(key) == null) {
            throw new NotInTreeException();
        }
        if (key.compareTo((K) subtree.getKey()) == 0) { //encontre el nodo a eliminar
            if (subtree.getLeftChild() == null && subtree.getRightChild() == null) { // no queda ningún hijo
                return null;
            }
            if (subtree.getLeftChild() == null) { //solo queda hijo derecho
                return subtree.getRightChild();
            }
            if (subtree.getRightChild() == null) { //solo queda hijo izquierdo
                return subtree.getLeftChild();
            }
            //cuando tengo dos hijos, busco el menor valor del lado derecho.
            K minKey = minKey(subtree.getRightChild());
            subtree.setData(find(minKey));
            subtree.setKey(minKey);
            subtree.setRightChild(delete(minKey, subtree.getRightChild()));
            return subtree;
        } else if (key.compareTo((K) subtree.getKey()) < 0) {
            subtree.setLeftChild(delete(key, subtree.getLeftChild()));
        } else {
            subtree.setRightChild(delete(key, subtree.getRightChild()));
        }
        return subtree;
    }

    private K minKey(NodeBST node) {
        if (node == null) {
            return null;
        }
        if (node.getLeftChild() != null) {
            return minKey(node.getLeftChild());
        }
        return (K) node.getKey();
    }


    @Override
    public T find(K key) {
        try {
            return find(key, root).getData();
        } catch (NotInTreeException e) {
            return null;
        }
    }


    @Override
    public void insert(K key, T data) {
        root = insert(key, data, root);
        treeSize ++;
    }


    @Override
    public void delete(K key) {
        try {
            root = delete(key, root);
            treeSize--;
        } catch (NotInTreeException e) {
            System.out.println("Not in tree.");
        }
    }


    @Override
    public int size() {
        return treeSize;
    }
}
