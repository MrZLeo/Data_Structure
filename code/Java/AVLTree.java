package code.Java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;
import java.util.Queue;

/**
 *
 * @author MrZLeo
 * @param <K> the type of keys maintained by this map
 * @param <V> the type of mapped values
 */
public class AVLTree<K extends Comparable<K>, V> implements Tree<K, V>{

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

    @Override
    public int getSize() {
        return size;
    }

    @Override
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

    @Override
    public void add(K key, V value){
        add(root, key, value);
    }

    private Node getNode(Node node, K key) {
        if (isEmpty() || node == null) {
            return null;
        }

        if (node.key.compareTo(key) == 0) {
            return node;
        } else if (node.key.compareTo(key) > 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    @Override
    public V get(K key) {
        return Objects.requireNonNull(getNode(root, key)).value;
    }

    @Override
    public void set(K key, V value) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "is not exist!");
        }
        node.value = value;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }
    public void preorder() {
        preorder(root);
    }

    // recursion preorder
    private void preorder(Node node) {
        if (node == null) {
            return;
        }

        System.out.println(node.key);
        preorder(node.left);
        preorder(node.right);
    }

    // No recursion preorder
    public void preorderNR() {
        Deque<Node> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();

            System.out.println(cur.key);
            assert root != null;
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
    }

    public void levelorder() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node cur = queue.remove();
            System.out.println(cur.key);

            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    // sorted!
    public void inorder() {
        inorder(root);
    }

    private void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.println(node.key);
        inorder(node.right);
    }

    public void postorder() {
        postorder(root);
    }

    private void postorder(Node node) {
        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.println(node.key);
    }

    private Node getMinimum(Node node) {
        if (node.left == null) {
            return node;
        }

        return getMinimum(node.left);
    }

    public K getMinimum() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Tree is empty");
        }

        assert root != null;
        return getMinimum(root).key;
    }

    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }

        node.left = removeMin(node.left);
        return node;
    }

    private Node getMaximum(Node node) {
        if (node.right == null) {
            return node;
        }

        return getMaximum(node.right);
    }

    public K getMaximum() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Tree is empty");
        }

        assert root != null;
        return getMaximum(root).key;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);

        if (node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove(Node node, K key){
        if (node == null){
            return null;
        }

        if (node.key.compareTo(key) > 0){
            return remove(node.left, key);
        } else if (node.key.compareTo(key) < 0){
            return remove(node.right, key);
        } else {
            // left tree is empty
            if (node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            // right tree is empty
            if (node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }

            // left and right are neither empty

            // first, find out minimum of node's right child
            Node successor = getMinimum(node.right);
            // successor replace the position of node
            successor.right = removeMin(node.right);
            successor.left = node.left;
            // make node be null
            node.left = node.right = null;
            return successor;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("AVL Tree:").append("\n");
        generateString(root, 0, res);
        return res.toString();
    }

    private void generateString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth)).append("null\n");
            return;
        }

        res.append(generateDepthString(depth)).append(node.key).append("\n");
        generateString(node.left, depth + 1, res);
        generateString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        return "--".repeat(Math.max(0, depth));
    }

}
