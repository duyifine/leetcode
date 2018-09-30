package graphSearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class GraphCycle {
  
  public boolean isCyclic(List<int[]> edges, int N) {
    if (edges == null || edges.size() == 0) {
      return false;
    }
    
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();
    for (int[] edge : edges) {
      if (!map.containsKey(edge[0])) {
        map.put(edge[0], new ArrayList<>());
      }
      map.get(edge[0]).add(edge[1]);
    }
    
    for (int i = 0; i < N; i++) {
      if (map.containsKey(i) && !visited.contains(i)) {
        if (dfs(i, map, visited, new HashSet<Integer>())) {
          return true;
        }
      }
    }
    
    return false;
  }
  
  public boolean dfs(int edge, HashMap<Integer, List<Integer>> map, HashSet<Integer> visited, HashSet<Integer> visitedInCurPath) {
    if (visitedInCurPath.contains(edge)) {
      return true;
    }
    
    visited.add(edge);
    visitedInCurPath.add(edge);
    List<Integer> children = map.get(edge);
    if (children == null) return false;
    for (Integer child : children) {
      if (dfs(child, map, visited, visitedInCurPath)) {
        return true;
      }
    }
    visitedInCurPath.remove(edge);
    
    return false;
  }
}