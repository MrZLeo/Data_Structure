package code;

/**
 * @author MrZLeo
 * O(log* n)
 */
public class TreeUnionFind implements UnionFind {

    private final int[] parent;
    private final int[] rank;

    public TreeUnionFind(int size) {
        parent = new int[size];
        rank = new int[size];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("out of bound.");
        }

        while (p != parent[p]) {
            // path compression.
            parent[p] = parent[parent[p]];
            p = parent[p];
        }

        return p;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);

        if (pRoot == qRoot) {
            return;
        }

        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot]++;
        }
    }
}
