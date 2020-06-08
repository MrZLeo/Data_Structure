package Data_Structure;

public class SBT<E extends Comparable<E>> {

    private class Node{
        E e;
        Node left, right;
        Node(E e){
            this.e = e;
        }
    }
}