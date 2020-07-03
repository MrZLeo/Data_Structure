package code.Java;

/**
 * @author MrZLeo
 */
public interface Map<K, V> {

    boolean isEmpty();
    int getSize();
    void add(K key, V value);
    void set(K key, V newValue);
    V get(K key);
    void remove(K key);
//    boolean contains(K key, V value);
}
