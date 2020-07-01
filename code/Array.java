package code;

/**
 * @author MrZLeo
 */
public class Array<E> {

    private E[] data;
    private int size;

    // 构造函数，传入数组的容量capacity构造Array.
    public Array(int capacity) {
        this.data = (E[]) new Object[capacity];
        this.size = 0;
    }

    // 构造函数，不传入参数，默认capacity=10构造Array.
    public Array() {
        this(10);
    }

    // 获取数组中的元素个数
    public int getSize() {
        return this.size;
    }

    // 获取数组的容量
    public int getCapacity() {
        return this.data.length;
    }

    // 判断Array是否为空
    public boolean isEmpty() {
        return size == 0;
    }

    // 向Array中索引为index的空间插入一个元素
    public void add(int index, E e) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("add is failed, " +
                    "required index >= 0 and index <= size");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }


        if (size - index >= 0) {
            System.arraycopy(data, index, data, index + 1, size - index);
        }

        data[index] = e;
        size++;
    }

    // 向array末尾处添加一个元素
    public void addLast(E e) {
        add(size, e);
    }

    // 向array第一个元素处插入一个元素
    public void addFirst(E e) {
        add(0, e);
    }

    // 查询Array中索引为index的元素
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get failed, illegal index.");
        }
        return data[index];
    }

    // 查询array中第一个元素
    public E getFirst() {
        return get(0);
    }

    // 查询Array最后一个元素
    public E getLast() {
        return get(size - 1);
    }

    // 修改索引为index的元素为e
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("set failed, illegal index.");
        }
        this.data[index] = e;
    }

    // 查询Array中是否含有匹配的元素e
    public boolean contains(E e) {
        boolean check = false;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                check = true;
                break;
            }
        }
        return check;
    }

    // 查询Array中匹配元素e的索引，若没找到则返回-1
    public int find(E e) {
        int check = -1;
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                check = i;
            }
        }
        return check;
    }

    //在Array中删除指定索引index的元素
    public E remove(int index) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("remove failed, illegal index.");
        }
        E ret = data[index];
        if (size - index + 1 >= 0) {
            System.arraycopy(data, index + 1, data, index + 1 - 1, size - index + 1);
        }
        size--;
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }

        return ret;
    }

    // 删除Array的第一个元素
    public E removeFirst() {
        return remove(0);
    }

    // 删除Array的最后一个元素
    public E removeLast() {
        return remove(size - 1);
    }

    // 删除指定的元素e
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        res.append(String.format("src.Array: size = %d, capacity = %d\n", size, data.length));
        res.append("[");
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append("]");

        return res.toString();
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        if (size >= 0) {
            System.arraycopy(data, 0, newData, 0, size);
        }
        data = newData;
    }
}
