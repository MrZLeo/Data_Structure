package code.Java;

/**
 * @author MrZLeo
 *
 */
public interface Set<E> {

    boolean isEmpty();
    int getSize();
    void add(E e);
    void remove(E e);
    boolean contains(E e);
}
