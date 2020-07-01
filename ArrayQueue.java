/**
 * @author MrZLeo
 */
public class ArrayQueue<E> implements Queue<E> {

    Array<E> array;

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public ArrayQueue() {
        array = new Array<>();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public void dequeue() {
        array.removeFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {

        StringBuilder res = new StringBuilder();
        res.append("Queue: ");
        res.append("Front [");
        for (int i = 0; i < array.getSize(); i++) {
            res.append(array.get(i));

            if (i != array.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");

        return res.toString();
    }


}
