package code.Java;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 *
 * @author MrZLeo
 * @param <K>
 * @param <V>
 */
public class RBTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
        K key;
        V value;
        Node left, right;
        boolean color;

        Node(K key, V value){
            this.key = key;
            this.value = value;
            color = RED;
            left = right = null;
        }
    }

    private Node root;
    private int size;

    public RBTree(){
        root = null;
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isBlack(Node node) {
        return node.color == BLACK;
    }

    public boolean isRed(Node node){
        return node.color == RED;
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
        res.append("Red Black Tree:").append("\n");
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
