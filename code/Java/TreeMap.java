package code.Java;

/**
 * @author MrZLeo
 */
public class TreeMap<K extends Comparable<K>, V> implements Map<K, V> {
    private final AVLTree<K, V> treeMap;

    TreeMap(){
        treeMap = new AVLTree<>();
    }

    @Override
    public boolean isEmpty() {
        return treeMap.isEmpty();
    }

    @Override
    public int getSize() {
        return treeMap.getSize();
    }

    @Override
    public void add(K key, V value) {
        treeMap.add(key, value);
    }

    @Override
    public void set(K key, V newValue) {
        treeMap.set(key, newValue);
    }

    @Override
    public V get(K key) {
        return treeMap.get(key);
    }

    @Override
    public void remove(K key) {
        treeMap.remove(key);
    }
}
