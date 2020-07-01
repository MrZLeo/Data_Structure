package code;

/**
 * @author MrzLeo
 */
public class TreeSet<E extends Comparable<E>> implements Set<E> {

    private final BST<E> treeSet;

    public TreeSet() {
        treeSet = new BST<>();
    }

    @Override
    public boolean isEmpty() {
        return treeSet.isEmpty();
    }

    @Override
    public int getSize() {
        return treeSet.getSize();
    }

    @Override
    public void add(E e) {
        if (!treeSet.contains(e)) {
            treeSet.add(e);
        }
    }

    @Override
    public void remove(E e) {
        if (!treeSet.contains(e)) {
            return;
        }

//        BST.remove have not finish yet!!!
    }

    @Override
    public boolean contains(E e) {
        return treeSet.contains(e);
    }
}
