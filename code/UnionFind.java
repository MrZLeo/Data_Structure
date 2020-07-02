package code;

/**
 * @author MrZLeo
 */
public interface UnionFind {

    int getSize();
    boolean isConnected(int p, int q);
    void union(int p, int q);
}
