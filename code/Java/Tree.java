package code.Java;

public interface Tree<K extends Comparable<K>, V> {
    class Node{};

    int getSize();
    boolean isEmpty();
    void add(K key, V value);
    V get(K key);
    void set(K key, V newValue);
    boolean contains(K key);
    V remove(K key);
}
