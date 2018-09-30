package graphSearch;

import java.util.Deque;
import java.util.LinkedList;

public class FriendCircles {
  
  class UnionFind {
    int count;
    int[] parent;
    int[] rank;
    
    public UnionFind(int n) {
      count = n;
      parent = new int[n];
      rank = new int[n];
      for (int i = 0; i < n; i++) {
        parent[i] = i;
      }
    }
    
    public int find(int p) {
      if (parent[p] != p) {
        parent[p] = find(parent[p]);
      }
      return parent[p];
    }
    
    public void union(int p, int q) {
      int rootP = find(p);
      int rootQ = find(q);
      if (rootP == rootQ) {
        return;
      } else {
        if (rank[rootP] < rank[rootQ]) {
          parent[rootP] = rootQ;
        } else if (rank[rootP] > rank[rootQ]) {
          parent[rootQ] = rootP;
        } else {
          parent[rootP] = rootQ;
          rank[rootQ]++;
        }
      }
      count--;
    }
    
    public int count() {
      return count;
    }
    
  }
  
  public int findCircleNumI(int[][] M) {
    if (M == null || M.length == 0 || M[0].length == 0) {
      return 0;
    }
    
    int count = 0;
    for (int i = 0; i < M.length; i++) {
      if (M[i][i] == 1) {
        count++;
        BFS(i, M);
      }
    }
    
    return count;
  }
  
  public void BFS(int index, int[][] M) {
    Deque<Integer> queue = new LinkedList<Integer>();
    queue.offerFirst(index);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int j = queue.pollLast();
        M[j][j] = -1;
        for (int k = 0; k < M[0].length; k++) {
          if (M[j][k] == 1 && M[k][k] == 1) {
            queue.offerFirst(k);
          }
        }
      }
    }
  }
  
  public int findCircleNumII(int[][] M) {
    if (M == null || M.length == 0 || M[0].length == 0) {
      return 0;
    }
    
    boolean[] visited = new boolean[M.length];
    int count = 0;
    for (int i = 0; i < M.length; i++) {
      if (!visited[i]) {
        DFS(M, visited, i);
        count++;
      }
    }
    
    return count;
  }
  
  public void DFS(int[][] M, boolean[] visited, int index) {
    for (int i = 0; i < M.length; i++) {
      if (M[index][i] == 1 && !visited[i]) {
        visited[i] = true;
        DFS(M, visited, i);
      }
    }
  }
  
  public int findCircleNumIII(int[][] M) {
    if (M == null || M.length == 0 || M[0].length == 0) {
      return 0;
    }
    
    UnionFind u = new UnionFind(M.length);
    for (int i = 0; i < M.length - 1; i++) {
      for (int j = i + 1; j < M.length; j++) {
        if (M[i][j] == 1) {
          u.union(i, j);
        }
      }
    }
    return u.count;
  }
}