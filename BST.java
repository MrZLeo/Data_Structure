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

    private Node add(Node root, E e){
        
        if (root == null) {
            root = new Node(e);
        } else if (root.e.compareTo(e) > 0) {
            root.right = add(root, e);
        } else if (root.e.compareTo(e) < 0) {
            root.left  = add(root, e);
        }
        
        return root;
    }

    public void add(E e){
        add(this.root, e);
    } 
    
}