package code;

/**
 * @author MrZLeo
 */
public class TreeUnionFind implements UnionFind{

    private final int[] parent;
    private final int[] depth;

    public TreeUnionFind(int size){
        parent = new int[size];
        depth = new int[size];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            depth[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    private int find(int p){
        if (p < 0 || p >= parent.length){
            throw new IllegalArgumentException("out of bound.");
        }

        while (p != parent[p]){
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

        if (pRoot == qRoot){
            return;
        }

        if (depth[pRoot] < depth[qRoot]){
            parent[pRoot] = qRoot;
            depth[qRoot] += depth[pRoot];
        } else {
            parent[qRoot] = pRoot;
            depth[pRoot] += depth[qRoot];
        }
    }
}
