package dataStructure;

import java.util.HashSet;

public class FriendCircles {
  public static class UnionFind {
    private int count;
    private int[] parent;
    private int[] rank;
    
    public UnionFind(int n) {
      count = n;
      parent = new int[n];
      rank = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }
    
    public int find(int p) {
      if (parent[p] == p) {
        return p;
      }
      
      parent[p] = find(parent[p]);
      return parent[p];
    }
    
    public void union(int p, int q) {
      int rootP = find(p);
      int rootQ = find(q);
      if (rootP == rootQ) return;
      if (rank[rootP] > rank[rootQ]) {
        parent[rootQ] = rootP;
      } else {
        parent[rootP] = rootQ;
        if (rank[rootP] == rank[rootQ]) {
          rank[rootQ]++;
        }
      }
      count--;
    }
  }
  
  public int findCircleNum(int[][] M) {
    if (M == null || M.length == 0) return 0;
    
    UnionFind u = new UnionFind(M.length);
    for (int i = 0; i < M.length; i++) {
      for (int j = i + 1; j < M.length; j++) {
        if (M[i][j] == 1) {
          u.union(i, j);
        }
      }
    }
    
    return u.count;
  }
  
  public int findCircleNumII(int[][] M) {
    if (M == null || M.length == 0) return 0;
    
    int count = 0;
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < M.length; i++) {
      if (!set.contains(i)) {
        dfs(M, i, set);
        count++;
      }
    }
    
    return count;
  }
  
  public void dfs(int[][] M, int i, HashSet<Integer> set) {
    if (set.contains(i)) return;
    
    set.add(i);
    for (int j = 0; j < M.length; i++) {
      if (M[i][j] == 1 && !set.contains(j)) {
        dfs(M, j, set);
      }
    }
  }
}