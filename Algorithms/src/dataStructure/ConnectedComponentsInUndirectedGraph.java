package dataStructure;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ConnectedComponentsInUndirectedGraph {
  
  public int countComponents(int n, int[][] edges) {
    if (n <= 0 || edges == null || edges.length == 0) {
      return 0;
    }
    
    HashMap<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < edges.length; i++) {
      if (!map.containsKey(edges[i][0])) {
        map.put(edges[i][0], new HashSet<Integer>());
      }
      map.get(edges[i][0]).add(edges[i][1]);
      if (!map.containsKey(edges[i][1])) {
        map.put(edges[i][1], new HashSet<Integer>());
      }
      map.get(edges[i][1]).add(edges[i][0]);
    }
    
    boolean[] visited = new boolean[n];
    int result = 0;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        result++;
        dfs(i, map, visited); // bfs(i, map, visited);
      }
    }
    return result;
  }
  
  public void dfs(int i, HashMap<Integer, Set<Integer>> map, boolean[] visited) {
    if (visited[i]) {
      return;
    }
    if (!map.containsKey(i)) {
      return;
    }
    
    visited[i] = true;
    for (int connected : map.get(i)) {
      dfs(connected, map, visited);
    }
  }
  
  public void bfs(int i, HashMap<Integer, Set<Integer>> map, boolean[] visited) {
    if (!map.containsKey(i)) return;
    visited[i] = true;
    
    Deque<Integer> queue = new LinkedList<>();
    queue.offerFirst(i);
    while (!queue.isEmpty()) {
      int top = queue.pollLast();
      if (map.containsKey(top)) {
        for (int connected : map.get(top)) {
          if (!visited[connected]) {
            queue.offerFirst(connected);
            visited[connected] = true;
          }
        }
      }
    }
  }
  
  public int countComponentsUnionFind(int n, int[][] edges) {
    if (n <= 0 || edges == null || edges.length == 0) {
      return 0;
    }
    
    int result = n;
    father = new int[n];
    for (int i = 0; i < n; i++) {
      father[i] = i;
    }
    for (int i = 0; i < edges.length; i++) {
      if (find(edges[i][0]) != find(edges[i][1])) {
        result--;
        union(edges[i][0], edges[i][1]);
      }
    }
    return result;
  }
  
  int[] father;
  public int find(int i) {
    if (father[i] == i) {
      return i;
    }
    father[i] = find(father[i]);
    return father[i];
  }
  
  public void union(int i, int j) {
    int iRoot = find(i);
    int jRoot = find(j);
    if (iRoot != jRoot) {
      father[jRoot] = iRoot;
    }
  }
}