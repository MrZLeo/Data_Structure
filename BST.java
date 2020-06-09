package Data_Structure;

public class BST<E extends Comparable<E>> {

    private class Node{
        E e;
        Node left, right;
        Node(E e){
            this.e = e;
        }
    }

    Node root;
    int size;
    BST(){
        this.root = null;
        this.size = 0;
    }

    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    // Recursion add.
    private Node add(Node root, E e){
        
        if (root == null) {
            size++;
            root = new Node(e);
        }
        
        if (e.compareTo(root.e) > 0) {
            root.right = add(root, e);
        } else if (e.compareTo(root.e) < 0) {
            root.left = add(root, e);
        }
        
        return root;
    }

    public void add(E e){
        add(this.root, e);
    } 

    public boolean contains(E e){
        return contains(root, e);
    }

    // Recursion contains
    private boolean contains(Node node, E e){
        if (node == null) {
            return false;
        }

        if (node.e.compareTo(e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0){
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    public void preorder(){
        preorder(root);
    }
    // recursion preorder
    private void preorder(Node node){
        if (node == null) {
            return;
        }

        System.out.println(node.e);
        preorder(node.left);
        preorder(node.right);
    }

    // sorted!
    public void inorder(){
        inorder(root);
    }

    private void inorder(Node node){
        if (node == null) {
            return;
        }

        inorder(node.left);
        System.out.println(node.e);
        inorder(node.right);
    }

    public void postorder(){
        postorder(root);
    }

    private void postorder(Node node){
        if (node == null) {
            return;
        }

        postorder(node.left);
        postorder(node.right);
        System.out.println(node.e);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();        
    }

    private void generateBSTString(Node node, int depth, StringBuilder res){
        if (node == null) {
            res.append(generateBSTDepthString(depth) + "null\n");
            return;
        }

        res.append(generateBSTDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateBSTDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }

        return res.toString();
    }
}