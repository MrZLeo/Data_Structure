package code.Java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * @author MrZLeo
 */
public class BST<K extends Comparable<K>, V> {

    protected class Node {
        K key;
        V value;
        Node left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    protected final Node root;
    private int size;

    BST() {
        this.root = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Recursion add.
    private Node add(Node root, K key, V value) {

        if (root == null) {
            size++;
            root = new Node(key, value);
        }

        if (key.compareTo(root.key) > 0) {
            root.right = add(root, key, value);
        } else if (key.compareTo(root.key) < 0) {
            root.left = add(root, key, value);
        }

        return root;
    }

    public void add(K key, V value) {
        add(this.root, key, value);
    }

    public boolean contains(K key) {
        return contains(root, key);
    }

    // Recursion contains
    private boolean contains(Node node, K key) {
        if (node == null) {
            return false;
        }

        if (node.key.compareTo(key) == 0) {
            return true;
        } else if (key.compareTo(node.key) < 0) {
            return contains(node.left, key);
        } else {
            return contains(node.right, key);
        }
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

    public void remove(K key) {

    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateBSTDepthString(depth)).append("null\n");
            return;
        }

        res.append(generateBSTDepthString(depth)).append(node.key).append("\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateBSTDepthString(int depth) {

        return "--".repeat(Math.max(0, depth));
    }
}