package airbnb;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MinVerticesToTraverseDirectedGraph {
  
  public List<Integer> getMinVertices(int[][] edges, int n) {
    List<Integer> result = new ArrayList<>();
    if (edges == null || edges.length == 0 || n <= 0) return result;
    
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    int[] indegrees = new int[n];
    int[] outdegrees = new int[n];
    HashSet<Integer> visited = new HashSet<>();
    
    for (int[] edge : edges) {
      if (!map.containsKey(edge[0])) {
        map.put(edge[0], new ArrayList<>());
      }
      map.get(edge[0]).add(edge[1]);
      outdegrees[edge[0]]++;
      if (!map.containsKey(edge[1])) {
        map.put(edge[1], new ArrayList<>());
      }
      indegrees[edge[1]]++;
    }
    
    Deque<Integer> queue = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      if (indegrees[i] == 0) {
        queue.offerFirst(i);
        result.add(i);
      }
    }
    
    while (!queue.isEmpty()) {
      int top = queue.pollLast();
      dfs(top, map, visited);
    }
    
    if (visited.size() == n) return result;
    
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>(11, (i1, i2) -> (i2[1] - i1[1]));
    for (int i = 0; i < n; i++) {
      if (!visited.contains(i)) {
        maxHeap.offer(new int[] {i, outdegrees[i]});
      }
    }
    
    while (!maxHeap.isEmpty()) {
      int[] top = maxHeap.poll();
      if (!visited.contains(top[0])) {
        result.add(top[0]);
        dfs(top[0], map, visited);
      }
    }
    
    return result;
  }
  
  public void dfs(int node, HashMap<Integer, List<Integer>> map, HashSet<Integer> visited) {
    if (visited.contains(node)) return;
    visited.add(node);
    if (map.containsKey(node)) {
      for (int i : map.get(node)) {
        dfs(i, map, visited);
      }
    }
  }
  
  public static void main(String[] args) {
    MinVerticesToTraverseDirectedGraph sol = new MinVerticesToTraverseDirectedGraph();
    int[][] edges = {{0, 0}, {1, 2}, {2, 0}, {2, 3}, {3, 1}};
    List<Integer> res = sol.getMinVertices(edges, 4);
    System.out.println(res);
    edges = new int[][]{{0, 1}, {1, 0}, {2, 1}, {2, 3}, {3, 2}};
    res = sol.getMinVertices(edges, 4);
    System.out.println(res);
    edges = new int[][]{{0, 1}, {1, 0}, {2, 1}, {3, 1}, {3, 2}};
    res = sol.getMinVertices(edges, 4);
    System.out.println(res);
    edges = new int[][]{{2, 9}, {3, 3}, {3, 5}, {3, 7}, {4, 8}, {5, 8}, {6, 6}, {7, 4}, {8, 7}, {9, 3}, {9, 6}};
    res = sol.getMinVertices(edges, 10);
    System.out.println(res);
  }
}