package code;

/**
 * @author MrZLeo
 * <p>
 * Quick Find version.
 */
public class ArrayUnionFind implements UnionFind {

    private final int[] id;

    ArrayUnionFind(int size) {
        id = new int[size];

        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    @Override
    public int getSize() {
        return id.length;
    }

    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("out of bound!");
        }

        return id[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);

        if (pId == qId) {
            return;
        }

        for (int i = 0; i < id.length; i++) {
            if (find(i) == pId) {
                id[i] = qId;
            }
        }
    }
}
