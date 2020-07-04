package code.Java;

/**
 *
 * @author MrZLeo
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class AVLTree<K extends Comparable<K>, V> {

    private class Node {
        K key;
        V value;
        Node left, right;
        int height;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    AVLTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param node a node that needs to get its height
     * @return node's height. If node is null, return 0;
     */
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * @param node a node that needs to get its balanced factor.
     * @return balanced Factor, if node is null, return 0;
     */
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    /**
     * here is the situation: when the new node was added into a node.left.left,
     * it seems like a linked list:   unbalanced node
     *                                     /
     *                              middle node
     *                                 /   \
     *                           new node  right child
     * then it comes to right rotation.
     * here is how we do:
     * firstly, we make unbalanced node to be middle node's right child.
     * secondly, we make middle node's right child to be unbalanced node's right child.
     * finally, we make middle node to be new root and return.
     * here is what will be after right rotation:     middle node
     *                                                /        \
     *                                           new node    unbalanced node
     *                                                          /
     *                                                     right child
     * And it is balanced.
     *
     * @param node unbalanced node that is
     * @return new root, middle node.
     */
    private Node rightRotation(Node node) {
        // store two node that will be used latter.
        Node middle = node.left;
        Node rightChild = middle.right;

        // rotation
        middle.right = node;
        node.left = rightChild;

        // update height
        middle.height = Math.max(getHeight(middle.left), getHeight(middle.right)) + 1;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        return middle;
    }

    /**
     * here is the situation: when the new node was added into a node.right.right,
     * it seems like a linked list:     unbalanced node
     *                                             \
     *                                       middle node
     *                                         /     \
     *                                  left child  new node
     * then it comes to left rotation.
     * here is what we do, it just like a duality of right rotation:
     * firstly, we make unbalanced node to be middle node's left child.
     * then, we make left child to be unbalanced node's right child.
     * finally, we make middle node new root and return.
     *
     * @param node unbalanced node
     * @return middle node, new root.
     */
    private Node leftRotation(Node node) {
        // store the node we will use latter
        Node middle = node.right;
        Node leftChild = middle.left;

        // rotation
        middle.left = node;
        node.right = leftChild;

        // update height
        middle.height = Math.max(getHeight(middle.left), getHeight(middle.right)) + 1;
        node.height = Math.max(getHeight(node.left), getHeight(node.right)) + 1;

        return middle;
    }

    /**
     *
     * @param node root of a tree that will add new entry.
     * @param key key that will be added
     * @param value value that will be added
     * @return new root
     */
    private Node add(Node node, K key, V value) {

        if (root == null) {
            size++;
            root = new Node(key, value);
        }

        if (key.compareTo(root.key) > 0) {
            root.right = add(root, key, value);
        } else if (key.compareTo(root.key) < 0) {
            root.left = add(root, key, value);
        }

        // update height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));

        // update balance factor
        int balanceFactor = getBalanceFactor(node);

        // optimize by balance factors.
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotation(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0){
            return leftRotation(node);
        }
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0){
            node.left = leftRotation(node.left);
            return rightRotation(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0){
            node.right = rightRotation(node.right);
            return leftRotation(node);
        }

        return node;
    }

    public void add(K key, V value){
        add(root, key, value);
    }

}
