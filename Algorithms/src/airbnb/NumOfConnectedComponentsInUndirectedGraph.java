package airbnb;

public class NumOfConnectedComponentsInUndirectedGraph {
  int[] father;
  int[] rank;
  public int find(int n) {
    if (father[n] == n) return n;
    father[n] = find(father[n]);
    return father[n];
  }
  
  public void union(int x, int y) {
    int xRoot = find(x);
    int yRoot = find(y);
    if (xRoot != yRoot) {
      if (rank[xRoot] > rank[yRoot]) {
        father[yRoot] = xRoot;
      } else {
        father[xRoot] = yRoot;
        if (rank[xRoot] == rank[yRoot]) {
          rank[yRoot]++;
        }
      }
    }
  }
  
  public int countComponents(int n, int[][] edges) {
    if (n <= 0) return 0;
    
    father = new int[n];
    rank = new int[n];
    for (int i = 0; i < n; i++) {
      father[i] = i;
    }
    
    int result = n;
    for (int[] edge : edges) {
      if (find(edge[0]) != find(edge[1])) {
        result--;
        union(edge[0], edge[1]);
      }
    }
    
    return result;
  }
} 