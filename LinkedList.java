/**
 * @author MrZLeo
 */
public class LinkedList<E> {

    private class Node {
        E e;
        Node next;

        Node(E e) {
            this.e = e;
        }
    }

    private Node dummyHead;
    private int size;

    LinkedList() {
        this.dummyHead = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        dummyHead.next = new Node(e);
        size++;
    }

    public E removeFirst() {
        E ret = dummyHead.next.e;
        Node prev = dummyHead.next;
        dummyHead.next = prev.next;

        prev = null;
        size--;
        return ret;
    }
}