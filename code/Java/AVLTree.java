package code.Java;

/**
 * @author MrZLeo
 */
public class AVLTree<K extends Comparable<K>, V> extends BST<K, V>{

    AVLTree() {
        super();
    }

    private Node rightRotation(Node node){
        return node;
    }

    private Node leftRotation(Node node){
        return node;
    }

    private Node getBalance(Node node){
        return node;
    }

    @Override
    public void add(K key, V value) {
        super.add(key, value);
        getBalance(root);
    }

    @Override
    public void remove(K key) {

    }
}
