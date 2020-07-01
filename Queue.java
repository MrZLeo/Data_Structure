/**
 * @author MrZLeo
 */
public interface Queue<E> {

    void enqueue(E e);
    void dequeue();
    int getSize();
    E getFront();
    boolean isEmpty();
}
